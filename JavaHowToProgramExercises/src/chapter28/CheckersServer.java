// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.16 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CheckersServer extends JFrame{

	private String[] board = new String[64]; // checkers board
	private JTextArea outputArea; // for outputting moves
	private Player[] players; // array of players
	private ServerSocket server; // server socket to connect with clients
	private Integer currentPlayer; // keeps track of player with clients
	private final static Integer PLAYER_WHITE = 0; // constant for first player
	private final static Integer PLAYER_BLACK = 1; // constant for second player
	private final static Color[] pieceColors = {Color.WHITE, Color.BLACK}; // array of colors
	private ExecutorService runGame; // will run players
	private Lock gameLock; // to lock game for synchronization
	private Condition otherPlayerConnected; // to wait for other player
	private Condition otherPlayerTurn; // to wait for other player's turn
	
	// set up checkers server and GUI that displays messages
	public CheckersServer(){
		super("Checkers Server");
		
		// create ExecutorService with a thread for each player
		runGame = Executors.newFixedThreadPool(2);
		gameLock = new ReentrantLock(); // create lock for games
		
		// condition variable for both players being connected
		otherPlayerConnected = gameLock.newCondition();
		
		// condition variable for other player's turn
		otherPlayerTurn = gameLock.newCondition();
		
		for (int i = 0; i < board.length; i++) {
			board[i] = new String(""); // create checkers board TODO: refactor (method maybe?)
		}
		players = new Player[2]; // create array of players
		currentPlayer = PLAYER_WHITE; // set current player to first player
		
		try {
			server = new ServerSocket(12345, 2); // set up ServerSocket
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		outputArea = new JTextArea(); // create JTextArea for output
		add(outputArea, BorderLayout.CENTER);
		outputArea.setText("Server awaiting connections\n");
		
		setSize(300, 300); // set window size
		setVisible(true);
	}
	
	// wait for two connections so game can be played
	public void execute(){
		// wait for each client to connect
		for (int i = 0; i < players.length; i++) {
			try { // wait for connection, create Player, start runnable
				players[i] = new Player(server.accept(), i);
				runGame.execute(players[i]); // execute player runnable
			} catch (IOException e){
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
}
