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

	private JTextField idField; // text field to display players color
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
	private Integer[] pieceToRelocate = new Integer[2]; // stores location of player piece that changes place
	private Integer[] capturedPiece = new Integer[2]; // stores location of captured piece
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

		idField = new JTextField(); // set up text field
		idField.setEditable(false);
		add(idField, BorderLayout.NORTH);

		panel2 = new JPanel(); // set up panel to contain boardPanel
		panel2.add(boardPanel, BorderLayout.CENTER); // add board panel
		add(panel2, BorderLayout.CENTER); // add container panel

		setSize(400, 400); // set size of window
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
				Integer[] location1 = {row, column}; // determine location of square
													// that's created
				Integer[] location2 = {row, column + 1};

				// create board with checkers pattern and with pieces on it
				if (row < 3) {
					// create board with white pieces
					if (column % 2 == 0 && row % 2 == 0) {
						board[row][column] = new Square("", location1, Color.LIGHT_GRAY);
						boardPanel.add(board[row][column]); // add square
						board[row][column + 1] = new Square("W", location2, Color.WHITE);
						boardPanel.add(board[row][column + 1]); // add square
					} else {
						board[row][column] = new Square("W", location1, Color.WHITE);
						boardPanel.add(board[row][column]); // add square
						board[row][column + 1] = new Square("", location2, Color.LIGHT_GRAY);
						boardPanel.add(board[row][column + 1]); // add square
					}
				} else if (row > 4) {
					// create board with black pieces
					if (column % 2 == 0 && row % 2 == 0) {
						board[row][column] = new Square("", location1, Color.LIGHT_GRAY);
						boardPanel.add(board[row][column]); // add square
						board[row][column + 1] = new Square("B", location2, Color.WHITE);
						boardPanel.add(board[row][column + 1]); // add square
					} else {
						board[row][column] = new Square("B", location1, Color.WHITE);
						boardPanel.add(board[row][column]); // add square
						board[row][column + 1] = new Square("", location2, Color.LIGHT_GRAY);
						boardPanel.add(board[row][column + 1]); // add square
					}
				} else {
					// create board without pieces
					if (column % 2 == 0 && row % 2 == 0) {
						board[row][column] = new Square("", location1, Color.LIGHT_GRAY);
						boardPanel.add(board[row][column]); // add square
						board[row][column + 1] = new Square("", location2, Color.WHITE);
						boardPanel.add(board[row][column + 1]); // add square
					} else {
						board[row][column] = new Square("", location1, Color.WHITE);
						boardPanel.add(board[row][column]); // add square
						board[row][column + 1] = new Square("", location2, Color.LIGHT_GRAY);
						boardPanel.add(board[row][column + 1]); // add square
					}
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
		// valid move occurred
		if (message.equals("Valid move.")) {
			displayMessage("Valid move, please wait.\n");
			removePieceFromBoard(board[pieceToRelocate[0]][pieceToRelocate[1]]); // remove piece from previous location
			putPieceOnBoard(currentSquare, myColor); // set piece in new location 
			
		// client captured piece of opponent
		} else if (message.equals("You captured opponent piece.")) {
			displayMessage("You captured opponent piece.\n");
			capturedPiece[0] = input.nextInt(); // get capture location
			capturedPiece[1] = input.nextInt();
			input.nextLine(); // skip newline after int location
			removePieceFromBoard(board[capturedPiece[0]][capturedPiece[1]]); // remove captured piece
		
		// choosing move end location
		} else if (message.equals("Where to move piece?.")) {
			displayMessage(message + "\n");
			myTurn = true; // still this client's turn
			pieceToRelocate[0] = input.nextInt(); // get move location
			pieceToRelocate[1] = input.nextInt();
			input.nextLine(); // skip newline after int location
			
		// Invalid move occured
		} else if (message.equals("Invalid move, try again")) {
			displayMessage(message + "\n");
			myTurn = true; // still this client's turn
			
		// Opponent chose move end location
		} else if (message.equals("Opponent choosed piece to move.")){
			pieceToRelocate[0] = input.nextInt(); // get piece location
			pieceToRelocate[1] = input.nextInt();
			input.nextLine(); // skip newline after int location
			displayMessage("Oppenent choosed piece at location " + pieceToRelocate[0] + ", " + pieceToRelocate[1] + "\n");
			
		// opponent moved
		} else if (message.equals("Opponent moved")) {
			int row = input.nextInt(); // get move location
			int column = input.nextInt();
			input.nextLine(); // skip newline after int location

			// relocate piece
			removePieceFromBoard(board[pieceToRelocate[0]][pieceToRelocate[1]]); // remove piece from previous location
			putPieceOnBoard(board[row][column], (myColor.equals(WHITE_COLOR) ? BLACK_COLOR : WHITE_COLOR));
			displayMessage("Oppenent moved. Your turn.\n");
			myTurn = true; // now this client's turn
			
		// opponent captured clients piece
		} else if (message.equals("Opponent captured your piece.")){
			capturedPiece[0] = input.nextInt(); // get piece location
			capturedPiece[1] = input.nextInt();
			input.nextLine(); // skip newline after int location
			displayMessage("Oppenent captured piece at location " + capturedPiece[0] + ", " + capturedPiece[1] + "\n");
			// relocate piece
			removePieceFromBoard(board[capturedPiece[0]][capturedPiece[1]]); // remove captured piece
			
		// more captures possible for client
		} else if (message.equals("More captures possible, still your turn.")){
			displayMessage(message + "\n");
			removePieceFromBoard(board[pieceToRelocate[0]][pieceToRelocate[1]]); // remove piece from previous location
			putPieceOnBoard(currentSquare, myColor); // set piece in new location 
			myTurn = true;
			
		// opponent moved and still has moves
		}else if (message.equals("Opponent moved but still has moves.")){
			int row = input.nextInt(); // get move location
			int column = input.nextInt();
			input.nextLine(); // skip newline after int location

			// relocate piece
			removePieceFromBoard(board[pieceToRelocate[0]][pieceToRelocate[1]]); // remove piece from previous location
			putPieceOnBoard(board[row][column], (myColor.equals(WHITE_COLOR) ? BLACK_COLOR : WHITE_COLOR));
			displayMessage(message + "\n");
			
		// other message
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

	// utility method to set piece on board in event-dispatch thread
	private void putPieceOnBoard(final Square squareToPut, final String piece) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				squareToPut.setPiece(piece); // set mark in square
			}
		});
	}
	
	private void removePieceFromBoard(final Square squareToPut) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				squareToPut.setPiece(""); // set mark in square
			}
		});
	}

	// send message to server indicating clicked square
	public void sendClickedSquare(Integer[] location) {
		// if it is my turn
		if (myTurn) {
			output.format("%d\n", location[0]); // send location to server
			output.format("%d\n", location[1]);
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
		private Integer[] location; // location of square
		private Color squareColor; // color of square

		public Square(String squarePieceColor, Integer[] squareLocation, Color squareColor) {
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

		// set piece for Square
		public void setPiece(String newPiece) {
			pieceColor = newPiece; // set mark of square
			repaint(); // repaint square
		}

		// return Square location
		public Integer[] getSquareLocation() {
			return location; // return location of square
		}

		// draw Square
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(squareColor);
			g.drawRect(0, 0, 29, 29); // draw square
			g.drawString(pieceColor, 11, 20); // draw piece
		}
	}
}
