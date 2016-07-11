// Grzegorz Koñczak, 11.07.2016
// Exercise number 7.24 page 347
// Exercise from Java:How to program 10th edition


// Unfinished

package chapter7;

public class EightQueens {

	public static void main(String[] args) {

		int queenCount = 0;
		int blocked = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) {
					blocked = countForThisSquare(i, j);
				}
			}
		}

		displayBoard(board);
	}

	private static int countForThisSquare(int i, int j) {
		int total = 0;
		total += countRow(i);
		total += countColumn(j);
		total += countDiagonal(i, j);
		return total;
	}

	private static int countDiagonal(int x, int y) {
		int blockedDiagonal = 0;
		for (int i = 0; i < board.length - x; i++){
			if(board[x + i][y + i] == 0)
				blockedDiagonal++;
		}
		for (int i = 0; i < board.length - x; i++){
			if(board[x - i][y - i] == 0)
				blockedDiagonal++;
		}
		return blockedDiagonal;
	}

	private static int countColumn(int y) {
		int blockedCollumn = 0;
		for (int i = 0; i < 8; i++){
			if (board[i][y] == 0){
				blockedCollumn++;
			}
		}
		return blockedCollumn - 1;
	}

	private static int countRow( int x) {
		int blockedRow = 0;
		for (int i = 0; i < 8; i++){
			if (board[x][i] == 0){
				blockedRow++;
			}
		}
		return blockedRow - 1;
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
