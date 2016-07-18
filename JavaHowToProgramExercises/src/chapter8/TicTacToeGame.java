// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.17 page 400
// Exercise from Java:How to program 10th edition

package chapter8;

import java.util.Scanner;

import chapter8.TicTacToe.Sign;

public class TicTacToeGame {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		game.play();
	}

	private void play() {
		int playerThatWon = 0;
		TicTacToe board = new TicTacToe();
		boolean gameNotWon = true;
		board.displayBoard();
		while (gameNotWon) {
			takeTurnX(board);
			board.displayBoard();
			gameNotWon = !isGameWon(board);
			if (gameNotWon) {
				takeTurnO(board);
				board.displayBoard();
			} else
				playerThatWon = 1;
			gameNotWon = !isGameWon(board);
			if (gameNotWon)
				playerThatWon = 2;
		}
		announceWinner(playerThatWon);
	}

	private void takeTurnO(TicTacToe board) {
		boolean properSpot = false;
		int row = 0;
		int column = 0;
		while (!properSpot) {
			System.out.println("Which row you choose player two?");
			row = input.nextInt();
			System.out.println("Which column you choose player two?");
			column = input.nextInt();
			if(board.getSign(row - 1, column - 1) == Sign.EMPTY)
				properSpot = true;
		}

		board.setSign(row - 1, column - 1, Sign.O);

	}

	private void announceWinner(int playerThatWon) {
		System.out.println("Grats! Player " + playerThatWon + " won!");

	}

	private boolean isGameWon(TicTacToe board) {
		// Upper row
		if ((board.getSign(0, 0) == Sign.O && board.getSign(0, 1) == Sign.O && board.getSign(0, 2) == Sign.O)
				|| (board.getSign(0, 0) == Sign.X && board.getSign(0, 1) == Sign.X && board.getSign(0, 2) == Sign.X))
			return true;
		// Middle row
		if ((board.getSign(1, 0) == Sign.O && board.getSign(1, 1) == Sign.O && board.getSign(1, 2) == Sign.O)
				|| (board.getSign(1, 0) == Sign.X && board.getSign(1, 1) == Sign.X && board.getSign(1, 2) == Sign.X))
			return true;
		// Bottom row
		if ((board.getSign(2, 0) == Sign.O && board.getSign(2, 1) == Sign.O && board.getSign(2, 2) == Sign.O)
				|| (board.getSign(2, 0) == Sign.X && board.getSign(2, 1) == Sign.X && board.getSign(2, 2) == Sign.X))
			return true;
		// Left column
		if ((board.getSign(0, 0) == Sign.O && board.getSign(1, 0) == Sign.O && board.getSign(2, 0) == Sign.O)
				|| (board.getSign(0, 0) == Sign.X && board.getSign(1, 0) == Sign.X && board.getSign(2, 0) == Sign.X))
			return true;
		// Middle column
		if ((board.getSign(0, 1) == Sign.O && board.getSign(1, 1) == Sign.O && board.getSign(2, 1) == Sign.O)
				|| (board.getSign(0, 1) == Sign.X && board.getSign(1, 1) == Sign.X && board.getSign(2, 1) == Sign.X))
			return true;
		// Right column
		if ((board.getSign(0, 2) == Sign.O && board.getSign(1, 2) == Sign.O && board.getSign(2, 2) == Sign.O)
				|| (board.getSign(0, 2) == Sign.X && board.getSign(1, 2) == Sign.X && board.getSign(2, 2) == Sign.X))
			return true;
		// Left up to Right down diagonal
		if ((board.getSign(0, 0) == Sign.O && board.getSign(1, 1) == Sign.O && board.getSign(2, 2) == Sign.O)
				|| (board.getSign(0, 0) == Sign.X && board.getSign(1, 1) == Sign.X && board.getSign(2, 2) == Sign.X))
			return true;
		// Left down to Right up diagonal
		if ((board.getSign(0, 2) == Sign.O && board.getSign(1, 1) == Sign.O && board.getSign(2, 0) == Sign.O)
				|| (board.getSign(0, 2) == Sign.X && board.getSign(1, 1) == Sign.X && board.getSign(2, 0) == Sign.X))
			return true;
		return false;
	}

	private void takeTurnX(TicTacToe board) {
		boolean properSpot = false;
		int row = 0;
		int column = 0;
		while (!properSpot) {
			System.out.println("Which row you choose player one?");
			row = input.nextInt();
			System.out.println("Which column you choose player one?");
			column = input.nextInt();
			if(board.getSign(row - 1, column - 1) == Sign.EMPTY)
				properSpot = true;
		}

		board.setSign(row - 1, column - 1, Sign.X);
	}
}
