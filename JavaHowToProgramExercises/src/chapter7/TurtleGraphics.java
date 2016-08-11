// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.21 page 344
// Exercise from Java:How to program 10th edition

package chapter7;

import java.util.Scanner;

public class TurtleGraphics {

	private static final Scanner input = new Scanner(System.in);

	private enum Facing {
		NORTH, SOUTH, WEST, EAST
	};

	public static void main(String[] args) {

		// initialize board
		int[][] board = new int[20][20];

		// display menu
		System.out.println("Enter command:");
		System.out.println("1 - Pen up");
		System.out.println("2 - Pen down");
		System.out.println("3 - Turn right");
		System.out.println("4 - Turn left");
		System.out.println("5, 10 - Move forward 10 spaces (replace 10 for a diffrent number of spaces)");
		System.out.println("6 - Display board");
		System.out.println("9 - End");
		int command = input.nextInt();

		// main drawing loop
		while (command != 9) {
			
			// loop for deciding witch command to take
			switch (command) {
			
			// Drawing on or off
			case 1:
				penDown = false;
				break;
			case 2:
				penDown = true;
				break;
				
			// Turning turtle
			case 3:
				if (turtleFaceing == Facing.SOUTH)
					turtleFaceing = Facing.WEST;
				else if (turtleFaceing == Facing.WEST)
					turtleFaceing = Facing.NORTH;
				else if (turtleFaceing == Facing.NORTH)
					turtleFaceing = Facing.EAST;
				else if (turtleFaceing == Facing.EAST)
					turtleFaceing = Facing.SOUTH;
				break;
			case 4:
				if (turtleFaceing == Facing.SOUTH)
					turtleFaceing = Facing.EAST;
				else if (turtleFaceing == Facing.WEST)
					turtleFaceing = Facing.SOUTH;
				else if (turtleFaceing == Facing.NORTH)
					turtleFaceing = Facing.WEST;
				else if (turtleFaceing == Facing.EAST)
					turtleFaceing = Facing.NORTH;
				break;
			
			// Moving turtle
			case 5:
				board = move(board);
				break;
				
			// displaying board
			case 6:
				display(board);
				break;
			}

			// displaying menu after completing command
			System.out.println("Enter command:");
			System.out.println("1 - Pen up");
			System.out.println("2 - Pen down");
			System.out.println("3 - Turn right");
			System.out.println("4 - Turn left");
			System.out.println("5, 10 - Move forward 10 spaces (replace 10 for a diffrent number of spaces)");
			System.out.println("6 - Display board");
			System.out.println("9 - End");
			command = input.nextInt();
		}
	}

	// method for displaying board
	private static void display(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == turtleLocation[0] && j == turtleLocation[1])
					System.out.print("T");
				else
					System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	private static int[][] move(int[][] board) {
		int distance = input.nextInt();
		
		// Moving turtle in south direction (with or without drawing along the way)
		if (turtleFaceing == Facing.SOUTH) {
			if (penDown) {
				for (int i = 0; i < distance; i++) {
					board[turtleLocation[0]][turtleLocation[1]] = 1;
					turtleLocation[0]++;
				}
			}else{
				turtleLocation[0] += distance;
			}
			return board;
		}
		
		// Moving turtle in north direction (with or without drawing along the way)
		if (turtleFaceing == Facing.NORTH) {
			if (penDown) {
				for (int i = 0; i < distance; i++) {
					board[turtleLocation[0]][turtleLocation[1]] = 1;
					turtleLocation[0]--;
				}
			}else{
				turtleLocation[0] -= distance;
			}
			return board;
		}
		
		// Moving turtle in west direction (with or without drawing along the way)
		if (turtleFaceing == Facing.EAST) {
			if (penDown) {
				for (int i = 0; i < distance; i++) {
					board[turtleLocation[0]][turtleLocation[1]] = 1;
					turtleLocation[1]--;
				}
			}else{
				turtleLocation[1] -= distance;
			}
			return board;
		}
		
		// Moving turtle in east direction (with or without drawing along the way)
		if (turtleFaceing == Facing.WEST) {
			if (penDown) {
				for (int i = 0; i < distance; i++) {
					board[turtleLocation[0]][turtleLocation[1]] = 1;
					turtleLocation[1]++;
				}
			}else{
				turtleLocation[1] += distance;
			}
			return board;
		}
		return board;
	}

	static int[] turtleLocation = { 0, 0 };
	static Facing turtleFaceing = Facing.SOUTH;
	static boolean penDown = false;
}
