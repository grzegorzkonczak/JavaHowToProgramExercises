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
	private boolean captureOccurred = false; // if there was capture in players move
	private Integer[] captureLocation = {0, 0}; // stores location of captured piece
	private boolean captureIndicator = false; // indicates that move should be capture move at the end of player turn
	private boolean nextCapturePossible = false; // indicates that more captures are possible for player

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
		notCurrentPlayer = PLAYER_BLACK; // set not current player to second
											// player

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
		
		// check if move can be capture move
		if (isCaptureMove(location, player)) {
			players[notCurrentPlayer].otherPlayerChoosedPiece(location);
			captureIndicator = true;
			return true; // notify player that move was valid
			// check if capture move is possible for player
		} else if (isCapturePossibleForPlayer(player)) {
			return false; // notify player that move was invalid
		} else {
			if (isPlayerPiece(location, player)) {
				players[notCurrentPlayer].otherPlayerChoosedPiece(location);
				return true; // notify player that move was valid
			} else { // move was not valid
				return false; // notify player that move was invalid
			}
		}
	}


	// check if there are possible capture moves on board for particular player
	private boolean isCapturePossibleForPlayer(Integer player) {
		Integer[] location = new Integer[2];
		// loop all rows
		for (int row = 0; row < board.length; row++) {
			// loop all columns
			for (int column = 0; column < board[row].length; column++) {
				location[0] = row;
				location[1] = column;
				if (isCaptureMove(location, player)){ // check if capture possible at this location
					return true; // possible capture present on board
				}
			}
		}
		return false; // no possible captures on board
	}

	// check if location has potential for capture
	private boolean isCaptureMove(Integer[] location, Integer player) {
		Integer row = location[0];
		Integer column = location[1];
		// if player white check for possible capture of that piece and
		// if found return true
		if (player == PLAYER_WHITE){
			if (isPlayerPiece(location, player)) { // check if player piece
				if ((borderCheck(location, 1) // check if lower left direction is not near border
						&& (board[row + 1][column - 1].equals(pieceColors[PLAYER_BLACK]) // check if lower left has opponent piece
						&& (board[row + 2][column - 2].equals("")))) // check if after opponent piece there is free space
						|| (borderCheck(location, 2) // check if lower right direction is not near border
						&& (board[row + 1][column + 1].equals(pieceColors[PLAYER_BLACK])) // check if lower right has opponent piece
						&& (board[row + 2][column + 2].equals("")))) { // check if after opponent piece there is free space
					return true;
				}
			}
		// if player black check for possible capture of that piece
		// and if found return true
		} else if (player == PLAYER_BLACK){
			if (isPlayerPiece(location, player)) { // check if player piece
				if ((borderCheck(location, 3) // check if upper left direction is not near border
						&& (board[row - 1][column - 1].equals(pieceColors[PLAYER_WHITE]) // check if upper left has opponent piece
						&& (board[row - 2][column - 2].equals("")))) // check if after opponent piece there is free space
						|| (borderCheck(location, 4) // check if upper right direction is not near border
						&& (board[row - 1][column + 1].equals(pieceColors[PLAYER_WHITE])) // check if upper right has opponent piece
						&& (board[row - 2][column + 2].equals("")))) { // check if after opponent piece there is free space
					return true;
				}
			}
		}
		return false; // notify player that move is not capture move
	}

	private boolean borderCheck(Integer[] location, Integer checkDirection) {
		Integer row = location[0];
		Integer column = location[1];
		switch (checkDirection) {
		// check lower left direction for border
		case 1:
			if (row + 2 >= board.length || column - 2 < 0){
				return false; // out of border
			}
			break;
		// check lower right direction for border
		case 2:
			if (row + 2 >= board.length || column + 2 >= board[0].length){
				return false; // out of border
			}
			break;
		// check upper left direction for border
		case 3:
			if (row - 2 < 0 || column - 2 < 0){
				return false; // out of border
			}
			break;
		// check upper right direction for border
		case 4:
			if (row - 2 < 0 || column + 2 >= board[0].length){
				return false; // out of border
			}
			break;
		}
		return true; // checking this move will not go out of border
	}

	public boolean validateEndLocation(Integer[] startLocation, Integer[] endLocation, Integer player) {
		// if move is valid move piece to new location
		if (isMoveValid(startLocation, endLocation)) {
			// update board on server
			board[startLocation[0]][startLocation[1]] = "";
			board[endLocation[0]][endLocation[1]] = pieceColors[currentPlayer];
			if (captureOccurred){
				board[captureLocation[0]][captureLocation[1]] = ""; // take captured piece off board
				players[notCurrentPlayer].otherPlayerCaptured(captureLocation); // let opponent know that his piece was captured
				if (isCaptureMove(endLocation, player)){ // check if more captures for player is possible
					players[notCurrentPlayer].moreCapturesForOpponent(endLocation); // let opponent know that more captures are possible
					nextCapturePossible = true;
					return false;
				}
			}
			currentPlayer = (currentPlayer + 1) % 2; // change player
			notCurrentPlayer = (notCurrentPlayer + 1) % 2; // change player

			// let new current player know that move occurred
			players[currentPlayer].otherPlayerMoved(endLocation);

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

	private boolean isMoveValid(Integer[] startLocation, Integer[] endLocation) {
		if (isSquareOccupied(endLocation)){ // check if end destination is not occupied
			return false; // invalid move
		} else if (isCapture(startLocation, endLocation)){ // check if move is capture move
			return true; // valid move
		// if move should be capture but is not (started capture, ended as plain diagonal move) - return false
		}else if (captureIndicator){
			return false; // invalid move
		} else if (isMoveDiagonal(startLocation, endLocation)){ // check if move is diagonal in forward direction for current player
			return true; // valid move
		}
		return false; // invalid move
	}

	private boolean isMoveDiagonal(Integer[] startLocation, Integer[] endLocation) {
		Integer startRow = startLocation[0];
		Integer startColumn = startLocation[1];
		Integer endRow = endLocation[0];
		Integer endColumn = endLocation[1];
		
		// check if move is diagonal specific for white player without capture
		if (currentPlayer == PLAYER_WHITE){
			if (startRow + 1 == endRow && (startColumn - 1 == endColumn || startColumn + 1 == endColumn) ){
				return true;
			}
		// check if move is diagonal specific for white player without capture
		} else {
			if (startRow - 1 == endRow && (startColumn - 1 == endColumn || startColumn + 1 == endColumn) ){
				return true;
			}
		}
		return false;
	}

	private boolean isCapture(Integer[] startLocation, Integer[] endLocation) {
		Integer startRow = startLocation[0];
		Integer startColumn = startLocation[1];
		Integer endRow = endLocation[0];
		Integer endColumn = endLocation[1];
		// check capture for player white
		if (currentPlayer == PLAYER_WHITE){
			// check lower left capture possibility
			if (startRow + 2 == endRow && startColumn - 2 == endColumn 
					&& board[startRow + 1][startColumn - 1].equals(pieceColors[PLAYER_BLACK])){
				captureOccurred = true; // indicate that capture occurred
				
				// store capture location
				captureLocation[0] = startRow + 1;
				captureLocation[1] = startColumn - 1;
				return true;
			// check lower right capture possibility
			} else if (startRow + 2 == endRow && startColumn + 2 == endColumn 
					&& board[startRow + 1][startColumn + 1].equals(pieceColors[PLAYER_BLACK])){
				captureOccurred = true; // indicate that capture occurred
				
				// store capture location
				captureLocation[0] = startRow + 1;
				captureLocation[1] = startColumn + 1;
				return true;
			}
		// check capture for player black
		} else {
			// check upper left capture possibility
			if (startRow - 2 == endRow && startColumn - 2 == endColumn 
					&& board[startRow - 1][startColumn - 1].equals(pieceColors[PLAYER_WHITE])){
				captureOccurred = true; // indicate that capture occurred
				
				// store capture location
				captureLocation[0] = startRow - 1;
				captureLocation[1] = startColumn - 1;
				return true;
			// check upper right capture possibility
			} else if (startRow - 2 == endRow && startColumn + 2 == endColumn 
					&& board[startRow - 1][startColumn + 1].equals(pieceColors[PLAYER_WHITE])){
				captureOccurred = true; // indicate that capture occurred
				
				// store capture location
				captureLocation[0] = startRow - 1;
				captureLocation[1] = startColumn + 1;
				return true;
			}
		}
		return false;
	}

	// determine if square is not occupied by another piece
	private boolean isSquareOccupied(Integer[] endLocation) {
		if (board[endLocation[0]][endLocation[1]].equals("")){
			return false; // square is free
		}
		return true; // square is occupied
	}

	// determine whether player wants to move his piece
	public boolean isPlayerPiece(Integer[] location, Integer player) {
		if ((board[location[0]][location[1]].equals(pieceColors[player]) && currentPlayer == player)){
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
					Integer[] startLocation = { 0, 0 }; // initialize move start location
					Integer[] endLocation = {0, 0}; // initialize move end location
					// reset capture information
					captureOccurred = false;
					captureIndicator = false;
					nextCapturePossible = false;

					if (input.hasNext()) {
						startLocation[0] = input.nextInt(); // get move location
						startLocation[1] = input.nextInt();
					}

					// check for valid move
					if (validateStartLocation(startLocation, playerNumber)) {
						displayMessage("\npiece start location: " + startLocation[0] + ", " + startLocation[1]);
						output.format("Where to move piece?.\n"); // ask client
																	// for
																	// destination
																	// of move
						output.flush();
						output.format("%d\n", startLocation[0]); // send location of
															// move
						output.format("%d\n", startLocation[1]); // send location of
															// move
						output.flush();

						// get piece destination location
						endLocation[0] = input.nextInt();
						endLocation[1] = input.nextInt();

						// validate piece end location
						if (validateEndLocation(startLocation, endLocation, playerNumber)) {
							if (captureOccurred){
								displayMessage("\ncaptured piece: " + captureLocation[0] + ", " + captureLocation[1]);
								output.format("You captured opponent piece.\n"); // notify client
								output.format("%d\n", captureLocation[0]); // send location of move
								output.format("%d\n", captureLocation[1]); // send location of move
								output.flush();
							}
							displayMessage("\npiece end location: " + endLocation[0] + ", " + endLocation[1]);
							output.format("Valid move.\n"); // notify client
							output.flush();
						} else { // move was invalid or there were capture and more captures  are possible
							if (nextCapturePossible){
								displayMessage("\ncaptured piece: " + captureLocation[0] + ", " + captureLocation[1]);
								output.format("You captured opponent piece.\n"); // notify client
								output.format("%d\n", captureLocation[0]); // send location of move
								output.format("%d\n", captureLocation[1]); // send location of move
								output.flush();
								output.format("More captures possible, still your turn.\n"); // notify client that he has next move
								output.flush();
							} else {
								output.format("Invalid move, try again\n");
								output.flush();
							}
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
		
		// send message that other player captured piece
		public void otherPlayerCaptured(Integer[] captureLocation) {
			output.format("Opponent captured your piece.\n");
			output.format("%d\n", captureLocation[0]); // send location of capture
			output.format("%d\n", captureLocation[1]); // send location of capture
			output.flush();
			
		}
		
		// send message that more capture for opponent possible
		public void moreCapturesForOpponent(Integer[] location) {
			output.format("Opponent moved but still has moves.\n");
			output.format("%d\n", location[0]); // send location of move
			output.format("%d\n", location[1]); // send location of move
			output.flush();
		}
		
	}
}
