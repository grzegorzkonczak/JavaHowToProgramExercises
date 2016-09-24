// Grzegorz Koñczak, 22/23.09.2016
// Exercise number 28.16 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class CheckersServer extends JFrame {

	private String[][] board = new String[8][8]; // checkers board
	private JTextArea outputArea; // for outputting moves
	private Player[] players; // array of players
	private ServerSocket server; // server socket to connect with clients
	private Integer currentPlayer; // keeps track of player with clients
	private Integer notCurrentPlayer; // keeps track of player with clients
	private final static Integer PLAYER_WHITE = 0; // constant for first player
	private final static Integer PLAYER_BLACK = 1; // constant for second player
	private final static String[] pieceColors = { "W", "B" }; // array of
																// strings
	private ExecutorService runGame; // will run players
	private Lock gameLock; // to lock game for synchronization
	private Condition otherPlayerConnected; // to wait for other player
	private Condition otherPlayerTurn; // to wait for other player's turn

	// set up checkers server and GUI that displays messages
	public CheckersServer() {
		super("Checkers Server");

		// create ExecutorService with a thread for each player
		runGame = Executors.newFixedThreadPool(2);
		gameLock = new ReentrantLock(); // create lock for games

		// condition variable for both players being connected
		otherPlayerConnected = gameLock.newCondition();

		// condition variable for other player's turn
		otherPlayerTurn = gameLock.newCondition();

		createBoard();

		players = new Player[2]; // create array of players
		currentPlayer = PLAYER_WHITE; // set current player to first player
		notCurrentPlayer = PLAYER_BLACK; // set not current player to second player

		try {
			server = new ServerSocket(12345, 2); // set up ServerSocket
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		outputArea = new JTextArea(); // create JTextArea for output
		add(new JScrollPane(outputArea), BorderLayout.CENTER);
		outputArea.setText("Server awaiting connections\n");

		setSize(300, 300); // set window size
		setVisible(true);
	}

	private void createBoard() {
		// loop over the rows in the board
		for (int row = 0; row < board.length; row++) {
			// loop over the columns in the board
			for (int column = 0; column < board[row].length; column += 2) {
				// create square
				int location = row * 8 + column; // determine location of square
													// that's created

				// create board with checkers pattern and with pieces on it
				if (row < 3) {
					// create board with white pieces
					if (location % 2 == 0 && row % 2 == 0) {
						board[row][column] = "";
						board[row][column + 1] = "W";
					} else {
						board[row][column] = "W";
						board[row][column + 1] = "";
					}
				} else if (row > 4) {
					// create board with black pieces
					if (location % 2 == 0 && row % 2 == 0) {
						board[row][column] = "";
						board[row][column + 1] = "B";
					} else {
						board[row][column] = "B";
						board[row][column + 1] = "";
					}
				} else {
					// create board without pieces
					if (location % 2 == 0 && row % 2 == 0) {
						board[row][column] = "";
						board[row][column + 1] = "";
					} else {
						board[row][column] = "";
						board[row][column + 1] = "";
					}
				}
			}
		}

	}

	// wait for two connections so game can be played
	public void execute() {
		// wait for each client to connect
		for (int i = 0; i < players.length; i++) {
			try { // wait for connection, create Player, start runnable
				players[i] = new Player(server.accept(), i);
				runGame.execute(players[i]); // execute player runnable
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}

		gameLock.lock(); // lock game to signal player white thread

		try {
			players[PLAYER_WHITE].setSuspended(false); // resume player white
			otherPlayerConnected.signal(); // wake up player white thread
		} finally {
			gameLock.unlock(); // unlock game after signaling player white
		}
	}

	// display message in outputArea
	private void displayMessage(final String messageToDisplay) {
		// display message from event-dispatch thread of execution
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() { // updates outputArea
				outputArea.append(messageToDisplay); // add message
			}
		});
	}

	// determine if move is valid
	// TODO: Reimplement validation method for checkers game
	public boolean validateStartLocation(Integer[] location, Integer player) {
		// while not current player, must wait for turn
		while (player != currentPlayer) {
			gameLock.lock(); // lock game to wait for other player to go

			try {
				otherPlayerTurn.await(); // wait for player's turn
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				gameLock.unlock(); // unlock game after waiting
			}
		}

		// if location has player piece return true
		if (isPlayerPiece(location)) {
			players[notCurrentPlayer].otherPlayerChoosedPiece(location);
			return true; // notify player that move was valid
		} else { // move was not valid
			return false; // notify player that move was invalid
		}
	}

	public boolean validateEndLocation(Integer[] location, Integer player) {
		// if move is valid move piece to new location
		if (isMoveValid(location)) {
			board[location[0]][location[1]] = pieceColors[currentPlayer]; // set
																			// move
																			// on
																			// board
			currentPlayer = (currentPlayer + 1) % 2; // change player
			notCurrentPlayer = (notCurrentPlayer + 1) % 2; // change player

			// let new current player know that move occurred
			players[currentPlayer].otherPlayerMoved(location);

			gameLock.lock(); // lock game to signal other player to go

			try {
				otherPlayerTurn.signal(); // signal other player to continue
			} finally {
				gameLock.unlock(); // unlock game after signaling
			}

			return true; // notify player that move was valid
		} else { // move was not valid
			return false; // notify player that move was invalid
		}
	}

	private boolean isMoveValid(Integer[] location) {
		// TODO implement move validation
		return true;
	}

	// determine whether player wants to move his piece
	public boolean isPlayerPiece(Integer[] location) {
		if ((board[location[0]][location[1]].equals(pieceColors[PLAYER_WHITE]) && currentPlayer == PLAYER_WHITE)
				|| (board[location[0]][location[1]].equals(pieceColors[PLAYER_BLACK])
						&& currentPlayer == PLAYER_BLACK)) {
			return true; // player wants to move his piece
		} else {
			return false; // player wants to move not his piece
		}
	}

	// TODO: Implement isGameOver() method
	public boolean isGameOver() {
		return false;
	}

	// private inner class Player manages each Player as a runnable
	private class Player implements Runnable {
		private Socket connection; // connection to client
		private Scanner input; // input from client
		private Formatter output; // output to client
		private Integer playerNumber; // tracks which player this is
		private String color; // color for this player
		private boolean suspended = true; // weather tread is suspended

		public Player(Socket socket, int number) {
			playerNumber = number; // store this player's number
			color = pieceColors[playerNumber]; // specify player's color
			connection = socket; // store socket for client

			try { // obtain streams from Socket
				input = new Scanner(connection.getInputStream());
				output = new Formatter(connection.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}

		// control thread's execution
		@Override
		public void run() {
			// send client its color (WHITE or BLACK), process messages from
			// client
			try {
				displayMessage("Player " + color + " connected\n");
				output.format("%s\n", color); // send player's color
				output.flush(); // flush output

				// if player WHITE, wait for another player to arrive
				if (playerNumber == PLAYER_WHITE) {
					output.format("%s\n%s", "Player WHITE connected", "Waiting for another player\n");
					output.flush();

					gameLock.lock(); // lock game to wait for second player

					try {
						while (suspended) {
							otherPlayerConnected.await(); // wait for BLACK
															// player
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						gameLock.unlock(); // unlock game after second player
					}

					// send message that other player connected
					output.format("Other player connected. Your move.\n");
					output.flush();
				} else {
					output.format("Player BLACK connected, please wait\n");
					output.flush();
				}

				// while game not over
				while (!isGameOver()) {
					Integer[] location = { 0, 0 }; // initialize move location

					if (input.hasNext()) {
						location[0] = input.nextInt(); // get move location
						location[1] = input.nextInt();
					}

					// check for valid move
					if (validateStartLocation(location, playerNumber)) {
						displayMessage("\npiece start location: " + location[0] + ", " + location[1]);
						output.format("Where to move piece?.\n"); // ask client
																	// for
																	// destination
																	// of move
						output.flush();
						output.format("%d\n", location[0]); // send location of move
						output.format("%d\n", location[1]); // send location of move
						output.flush();
						
						// get piece destination location
						location[0] = input.nextInt();
						location[1] = input.nextInt();
						
						// validate piece end location
						if (validateEndLocation(location, playerNumber)) {
							displayMessage("\npiece end location: " + location[0] + ", " + location[1]);
							output.format("Valid move.\n"); // notify client
							output.flush();
						} else { // move was invalid
							output.format("Invalid move, try again\n");
							output.flush();
						}

					} else { // move was invalid
						output.format("Invalid move, try again\n");
						output.flush();
					}
				}
			} finally {
				try {
					connection.close(); // close connection to client
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		}

		// set weather or not thread is suspended
		public void setSuspended(boolean status) {
			suspended = status;
		}

		// send message that other player moved
		public void otherPlayerMoved(Integer[] location) {
			output.format("Opponent moved\n");
			output.format("%d\n", location[0]); // send location of move
			output.format("%d\n", location[1]); // send location of move
			output.flush();
		}
		
		// send message that other player moved
		public void otherPlayerChoosedPiece(Integer[] location) {
			output.format("Opponent choosed piece to move.\n");
			output.format("%d\n", location[0]); // send location of move
			output.format("%d\n", location[1]); // send location of move
			output.flush();
		}
	}
}
