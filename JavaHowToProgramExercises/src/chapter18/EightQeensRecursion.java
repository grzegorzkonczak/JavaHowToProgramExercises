// Grzegorz Koñczak, 23.08.2016
// Exercise number 18.15 page 849
// Exercise from Java:How to program 10th edition

package chapter18;

public class EightQeensRecursion {

	public static void main(String[] args) {

		for (int i = 0; i < 8; i++) {
			int[] placeForQueen = placeQueen(0, 0);
			board[placeForQueen[0]][placeForQueen[1]] = 1;
			displayBoard(board);
			System.out.println();
		}
		displayBoard(board);
	}

	private static int[] placeQueen(int x, int y) {
		int[] place = new int[2];
		if (board[x][y] == 0 && noThreat(x, y)) {
			place[0] = x;
			place[1] = y;
			return place;
		} else if (x == board.length - 1){
			return placeQueen(0, y + 1);
		} else {
			return placeQueen(x + 1, y);
		}
	}

	private static boolean noThreat(int x, int y) {
		boolean noThreat = true;
		if (!rowClear(x, y)) {
			noThreat = false;
		} else if (!columnClear(x, y)) {
			noThreat = false;
		} else if (!diagonalClear(x, y)) {
			noThreat = false;
		}
		return noThreat;
	}

	private static boolean diagonalClear(int x, int y) {
		boolean clear = true;
		// diagonal left-up
		for (int i = 0; i < board.length; i++) {
			if (x - i >= 0 && y - i >= 0) {
				if (board[x - i][y - i] == 1) {
					clear = false;
				}
			}
		}
		// diagonal left-down
		for (int i = 0; i < board.length; i++) {
			if (x - i >= 0 && y + i < board.length) {
				if (board[x - i][y + i] == 1) {
					clear = false;
				}
			}
		}
		// diagonal right-up
		for (int i = 0; i < board.length; i++) {
			if (x + i < board.length && y - i >= 0) {
				if (board[x + i][y - i] == 1) {
					clear = false;
				}
			}
		}
		// diagonal right-down
		for (int i = 0; i < board.length; i++) {
			if (x + i < board.length && y + i < board.length) {
				if (board[x + i][y + i] == 1) {
					clear = false;
				}
			}
		}
		return clear;
	}

	private static boolean columnClear(int x, int y) {
		boolean clear = true;
		for (int i = 0; i < board.length; i++) {
			if (board[x][i] != 0) {
				clear = false;
			}
		}
		return clear;
	}

	private static boolean rowClear(int x, int y) {
		boolean clear = true;
		for (int i = 0; i < board.length; i++) {
			if (board[i][y] != 0) {
				clear = false;
			}
		}
		return clear;

	}

	private static void displayBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.printf("%3d", board[i][j]);
			}
			System.out.println();
		}
	}

	static int[][] board = new int[8][8];
}
