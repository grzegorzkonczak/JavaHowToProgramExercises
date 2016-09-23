// Grzegorz Koñczak, 22/23.09.2016
// Exercise number 28.16 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CheckersClient extends JFrame implements Runnable {

	private JTextField idField; // textfield to display players color
	private JTextArea displayArea; // JTextArea to display output
	private JPanel boardPanel; // panel for checkers board
	private JPanel panel2; // panel to hold board
	private Square[][] board; // checkers board
	private Square currentSquare; // current Square
	private Socket connection; // connection to server
	private Scanner input; // input from server
	private Formatter output; // output to server
	private String checkersHost; // host name for host
	private String myColor; // this clients color
	private boolean myTurn; // determines which client's turn it is
	private final String WHITE_COLOR = "W"; // color for first client
	private final String BLACK_COLOR = "B"; // color for second client

	// set up user interface and board
	public CheckersClient(String host) {
		checkersHost = host; // set name of server
		displayArea = new JTextArea(4, 30); // set up JTextArea
		displayArea.setEditable(false);
		add(new JScrollPane(displayArea), BorderLayout.SOUTH);

		boardPanel = new JPanel(); // set up panel for squares in board
		boardPanel.setLayout(new GridLayout(8, 8, 0, 0));

		board = new Square[8][8]; // create board

		idField = new JTextField(); // set up textfield
		idField.setEditable(false);
		add(idField, BorderLayout.NORTH);

		panel2 = new JPanel(); // set up panel to contain boardPanel
		panel2.add(boardPanel, BorderLayout.CENTER); // add board panel
		add(panel2, BorderLayout.CENTER); // add container panel

		setSize(300, 225); // set size of window
		setVisible(true); // show window

		startClient();
	}

	// start the client thread
	public void startClient() {
		try { // connect to server and get streams

			createBoard(); // initialize board

			// make connection to server
			connection = new Socket(InetAddress.getByName(checkersHost), 12345);

			// get streams for input and output
			input = new Scanner(connection.getInputStream());
			output = new Formatter(connection.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}

		// create and start worker thread for this client
		ExecutorService worker = Executors.newFixedThreadPool(1);
		worker.execute(this); // execute client
	}

	private void createBoard() {
		// loop over the rows in the board
		for (int row = 0; row < board.length; row++) {
			// loop over the columns in the board
			for (int column = 0; column < board[row].length; column += 2) {
				// create square
				int location = row * 8 + column; // determine location of square
													// that's created
				
				// create board with checkers pattern
				if (location  % 2 == 0 && row % 2 == 0) {
					board[row][column] = new Square("", location, Color.LIGHT_GRAY);
					boardPanel.add(board[row][column]); // add square
					board[row][column] = new Square("", location + 1, Color.WHITE);
					boardPanel.add(board[row][column]); // add square
				} else {
					board[row][column] = new Square("", location, Color.WHITE);
					boardPanel.add(board[row][column]); // add square
					board[row][column] = new Square("", location + 1, Color.LIGHT_GRAY);
					boardPanel.add(board[row][column]); // add square
				}
			}
		}

	}

	// control thread that allows continuous update of displayArea
	public void run() {
		myColor = input.nextLine(); // get player's color (W or B)

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// display player's color
				idField.setText("You are player \"" + myColor + "\"");
			}
		});

		myTurn = (myColor.equals(WHITE_COLOR)); // determine if client's turn

		// receive messages sent to client and output them
		while (true) {
			if (input.hasNextLine()) {
				processMessage(input.nextLine());
			}
		}
	}

	// process messages received by client
	private void processMessage(String message) {
		// valid move occured
		if (message.equals("Valid move.")) {
			displayMessage("Valid move, please wait.\n");
			setMark(currentSquare, myColor); // set mark in square TODO: change
												// for checkers
		} else if (message.equals("Invalid move, try again")) {
			displayMessage(message + "\n");
			myTurn = true; // still this client's turn
		} else if (message.equals("Opponent moved")) {
			int location = input.nextInt(); // get move location
			input.nextLine(); // skip newline after int location
			int row = location / 8; // calculate row
			int column = location % 8; // calculate column

			// mark move TODO: reimplement for checkers
			setMark(board[row][column], (myColor.equals(WHITE_COLOR) ? BLACK_COLOR : WHITE_COLOR));
			displayMessage("Oppenent moved. Your turn.\n");
			myTurn = true; // now this client's turn
		} else {
			displayMessage(message + "\n");
		}
	}

	// manipulate displayArea in event-dispatch thread
	private void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				displayArea.append(messageToDisplay); // updates output
			}
		});
	}

	// utility method to set mark on board in event-dispatch thread
	// TODO: reimplement for checkers
	private void setMark(final Square squareToMark, final String mark) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				squareToMark.setMark(mark); // set mark in square
			}
		});
	}

	// send message to server indicating clicked squre
	// TODO: reimplement for checkers
	public void sendClickedSquare(int location) {
		// if it is my turn
		if (myTurn) {
			output.format("%d\n", location); // send location to server
			output.flush();
			myTurn = false; // not my turn any more
		}
	}

	// set current Square
	public void setCurrentSquare(Square square) {
		currentSquare = square; // set current square to argument
	}

	// private inner class for the squares on the board
	private class Square extends JPanel {
		private String pieceColor; // set color of piece in that square
		private Integer location; // location of square
		private Color squareColor; // color of square

		public Square(String squarePieceColor, Integer squareLocation, Color squareColor) {
			pieceColor = squarePieceColor; // set piece color for this square
			location = squareLocation; // set location of this square
			this.squareColor = squareColor;

			addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					setCurrentSquare(Square.this); // set current square

					// send location of this square
					sendClickedSquare(getSquareLocation());
				}
			});
		}

		// return preferred size of square
		public Dimension getPreferredSize() {
			return new Dimension(30, 30); // return preferred size
		}

		// return minimum size of Square
		public Dimension getMinimumSize() {
			return getPreferredSize(); // return preferred size
		}

		// set Mark for Square
		// TODO: reimplement for checkers
		public void setMark(String newMark) {
			pieceColor = newMark; // set mark of square
			repaint(); // repaint square
		}

		// return Square location
		public int getSquareLocation() {
			return location; // return location of square
		}

		// draw Square
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(squareColor);
			g.fillRect(0, 0, 29, 29); // draw square
			g.drawString(pieceColor, 11, 20); // draw mark
		}
	}
}
