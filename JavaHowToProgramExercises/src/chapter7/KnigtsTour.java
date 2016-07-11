// Grzegorz Koñczak, 11.07.2016
// Exercise number 7.23 page 346
// Exercise from Java:How to program 10th edition

package chapter7;

import java.security.SecureRandom;

public class KnigtsTour {

	private static final SecureRandom random = new SecureRandom();

	public static void main(String[] args) {

		int highestCounter = 0;
		int[][] highestBoard = new int[8][8];
		int passCounter = 0;
		while (highestCounter < 64) {
			int[][] board = new int[8][8];
			int counter = 0;
			int moveNumber = 0;
			boolean validMove = false;
			
			while (!validMove) {
				moveNumber = random.nextInt(8);
				validMove = validateMove(board, moveNumber);
			}
			boolean firstTimeOnSpot = checkSpot(board, moveNumber);

			while (firstTimeOnSpot) {
				counter++;
				currentRow += vertical[moveNumber];
				currentColumn += horizontal[moveNumber];
				board[currentRow][currentColumn] = counter;
				moveNumber = random.nextInt(8);
				validMove = validateMove(board, moveNumber);
				if (validMove) {
					firstTimeOnSpot = checkSpot(board, moveNumber);
				}
				while (!validMove || !firstTimeOnSpot) {
					moveNumber = random.nextInt(8);
					validMove = validateMove(board, moveNumber);
					if (validMove) {
						firstTimeOnSpot = checkSpot(board, moveNumber);
					}
					if (noPossibleMove(board))
						break;
				}
				if (noPossibleMove(board))
					break;
			}

			if(highestCounter < counter){
				highestCounter = counter;
				highestBoard = board;
			}
			passCounter++;
		}
		
		displayBoard(highestBoard);
		System.out.println(highestCounter);
		System.out.println(passCounter);
	}

	private static boolean noPossibleMove(int[][] board) {
		boolean noPossibleMove = true;
		for (int i = 0; i < 8; i++) {
			noPossibleMove = checkMove(i, board);
			if (!noPossibleMove)
				return noPossibleMove;
		}
		return noPossibleMove;
	}

	private static boolean checkMove(int i, int[][] board) {
		if ((currentRow + vertical[i] >= 0 && currentRow + vertical[i] <= 7)
				&& (currentColumn + horizontal[i] >= 0 && currentColumn + horizontal[i] <= 7))
			if ((board[currentRow + vertical[i]][currentColumn + horizontal[i]]) == 0)
				return false;
		return true;
	}

	private static boolean checkSpot(int[][] board, int moveNumber) {
		if ((board[currentRow + vertical[moveNumber]][currentColumn + horizontal[moveNumber]]) == 0)
			return true;
		return false;
	}

	private static void displayBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.printf("%3d", board[i][j]);
			}
			System.out.println();
		}

	}

	private static boolean validateMove(int[][] board, int moveNumber) {
		if ((currentRow + vertical[moveNumber] >= 0 && currentRow + vertical[moveNumber] <= 7)
				&& (currentColumn + horizontal[moveNumber] >= 0 && currentColumn + horizontal[moveNumber] <= 7)) {
			return true;
		}
		return false;
	}

	static int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int currentRow = 0;
	static int currentColumn = 0;
}
