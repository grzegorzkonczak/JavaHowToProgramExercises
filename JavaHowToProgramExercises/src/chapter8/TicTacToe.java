// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.17 page 400
// Exercise from Java:How to program 10th edition

package chapter8;

public class TicTacToe {

	public static enum Sign {O, X, EMPTY};
	private Sign[][] board = new Sign[3][3];
	
	public TicTacToe(){
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				board[i][j] = Sign.EMPTY;
			}
		}
	}

	public Sign getSign(int row, int column) {
		return board[row][column];
	}

	public void setSign(int row, int column, Sign x) {
		board[row][column] = x;
	}
	
	public void displayBoard(){
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				System.out.printf("%-7s", board[i][j]);
			}
			System.out.println();
		}
	}
	
}
