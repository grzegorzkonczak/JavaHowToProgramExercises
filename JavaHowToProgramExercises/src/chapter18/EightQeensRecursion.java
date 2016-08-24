// Grzegorz Koñczak, 23/24.08.2016
// Exercise number 18.15 page 849
// Exercise from Java:How to program 10th edition

package chapter18;

public class EightQeensRecursion {

	public static void main(String[] args) {

		// First non-recursive call to method solve
		solve(0);
		
		// After solving display board to console
		displayBoard(board);
	}

	// Solve problem using recursion
	private static boolean solve(int numQueens) {
		// When 8 queens are on board (queen number 0, 1, 2... 7) numQueens is
		// equal 8,
		// that means
		// we reached solution for the whole board and return true for previous
		// calls to solve method - this will trigger series of return true
		// statements
		// with the last one exiting the method back to main
		if (numQueens == 8) {
			System.out.println("DONE");
			return true;
		} else {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					// if there are no threats (not attacked or occupied space)
					// place queen in that spot and increment number of
					// numQueens
					// for next recursive call to this method
					if (noThreat(i, j)) {
						placeQueen(i, j, 0);
						numQueens++;

						// Recursive call to solve method which serves as
						// boolean test
						// If solution to whole problem is found at the end of
						// all
						// recursive calls it will trigger series of return true
						// statements which all serve as tests in if statement
						// except last one. Last one exits method from execution
						// (the call from main)
						if (solve(numQueens)) {
							return true;
						} else {
							// Triggers when no solution was found by previous
							// call to solve method
							// When last method call reached end of nested for
							// loops and numQueens not
							// reached vale 8 it returns false. In that case
							// queen is picked up and
							// nested for loops in this method call resume the
							// looping process to find
							// next possible threat-free place for queen
							placeQueen(i, j, 1);
							numQueens--;
						}
					}
				}
			}
		}
		// If we reached end of nested loops and numQeens did not reached
		// number 8 that means there is no solution in that configuration
		// returning false to previous recursive call of method
		// triggers else clause where queen is picked up from where it was
		// placed and nested loops continue their work from the place they last
		// ended effectively changing the place for that queen
		return false;
	}

	// Places or picks up queen from given spot
	private static void placeQueen(int x, int y, int type) {
		// Pick up the queen from given spot
		if (type == 0) {
			board[x][y] = 1;
		// Place queen in given spot
		} else if (type == 1) {
			board[x][y] = 0;
		}
	}

	// Checks if given spot is not attacked by other queens on board
	private static boolean noThreat(int x, int y) {
		boolean noThreat = true;
		// Check if row is clear
		if (!rowClear(x, y)) {
			noThreat = false;
			// Check if column is clear
		} else if (!columnClear(x, y)) {
			noThreat = false;
			// Check if diagonal lines are clear
		} else if (!diagonalClear(x, y)) {
			noThreat = false;
		}
		return noThreat;
	}

	// Tests if diagonal lines are not attacked by other queen
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

	// Tests if column is not attacked by other queen
	private static boolean columnClear(int x, int y) {
		boolean clear = true;
		for (int i = 0; i < board.length; i++) {
			if (board[x][i] != 0) {
				clear = false;
			}
		}
		return clear;
	}

	// Tests if row is not attacked by other queen
	private static boolean rowClear(int x, int y) {
		boolean clear = true;
		for (int i = 0; i < board.length; i++) {
			if (board[i][y] != 0) {
				clear = false;
			}
		}
		return clear;

	}

	// Prints board in console as series of zero's (vacant) and one's (queens)
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
