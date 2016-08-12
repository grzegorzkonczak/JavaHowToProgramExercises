// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.24 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class KnightsTourGui extends JPanel {
	
	private static final SecureRandom random = new SecureRandom();


	public void run() {
		int highestCounter = 0;
		highestBoards = new int[8][8];
		int passCounter = 0;
		while (highestCounter < 64) {
			boards = new int[8][8];
			counter = 0;
			int moveNumber = 0;
			boolean validMove = false;
			
			while (!validMove) {
				moveNumber = random.nextInt(8);
				validMove = validateMove(boards, moveNumber);
			}
			boolean firstTimeOnSpot = checkSpot(boards, moveNumber);

			while (firstTimeOnSpot) {
				counter++;
				currentRow += vertical[moveNumber];
				currentColumn += horizontal[moveNumber];
				boards[currentRow][currentColumn] = counter;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				moveNumber = random.nextInt(8);
				validMove = validateMove(boards, moveNumber);
				if (validMove) {
					firstTimeOnSpot = checkSpot(boards, moveNumber);
				}
				while (!validMove || !firstTimeOnSpot) {
					moveNumber = random.nextInt(8);
					validMove = validateMove(boards, moveNumber);
					if (validMove) {
						firstTimeOnSpot = checkSpot(boards, moveNumber);
					}
					if (noPossibleMove(boards))
						break;
				}
				if (noPossibleMove(boards))
					break;
			}

			if(highestCounter < counter){
				highestCounter = counter;
				highestBoards = boards;
				repaint();
			}
			passCounter++;
		}
		repaint();
		displayBoard(highestBoards);
		System.out.println(highestCounter);
		System.out.println(passCounter);
	}
	
	private  boolean noPossibleMove(int[][] board) {
		boolean noPossibleMove = true;
		for (int i = 0; i < 8; i++) {
			noPossibleMove = checkMove(i, board);
			if (!noPossibleMove)
				return noPossibleMove;
		}
		return noPossibleMove;
	}

	private  boolean checkMove(int i, int[][] board) {
		if ((currentRow + vertical[i] >= 0 && currentRow + vertical[i] <= 7)
				&& (currentColumn + horizontal[i] >= 0 && currentColumn + horizontal[i] <= 7))
			if ((board[currentRow + vertical[i]][currentColumn + horizontal[i]]) == 0)
				return false;
		return true;
	}

	private  boolean checkSpot(int[][] board, int moveNumber) {
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
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int [][] board = getBoards();
		
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				if (board[i][j] == getCounter() && board[i][j] != 0){
					g.setColor(Color.YELLOW);
					g.fillRect(0 + (i * (getWidth()/10)), 0 + (j * (getHeight()/10)), getWidth()/10, getHeight()/10);
					g.setColor(Color.BLACK);
					g.drawString(String.valueOf(board[i][j]), 0 + (i * (getWidth()/10) + 12), 0 + (j * (getHeight()/10) + 25));
				}else{
					g.drawRect(0 + (i * (getWidth()/10)), 0 + (j * (getHeight()/10)), getWidth()/10, getHeight()/10);
					g.drawString(String.valueOf(board[i][j]), 0 + (i * (getWidth()/10) + 12), 0 + (j * (getHeight()/10) + 25));
				}
			}
		}
	}

	private boolean validateMove(int[][] board, int moveNumber) {
		if ((currentRow + vertical[moveNumber] >= 0 && currentRow + vertical[moveNumber] <= 7)
				&& (currentColumn + horizontal[moveNumber] >= 0 && currentColumn + horizontal[moveNumber] <= 7)) {
			return true;
		}
		return false;
	}

	int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
	int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };
	int currentRow = 0;
	int currentColumn = 0;
	private int[][] highestBoards;
	private int[][] boards;
	private int counter;


	public int getCounter() {
		return counter;
	}

	public int[][] getBoards() {
		return boards;
	}

	public int[][] getHighestBoards() {
		return highestBoards;
	}

}
