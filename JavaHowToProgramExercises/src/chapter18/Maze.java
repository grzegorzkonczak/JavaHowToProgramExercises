// Grzegorz Koñczak, 24.08.2016
// Exercise number 18.20/21/22 page 850/851
// Exercise from Java:How to program 10th edition

// Partially finished, still need to build maze generator

package chapter18;

import java.security.SecureRandom;

public class Maze {

	private static final SecureRandom randomNumbers = new SecureRandom();
	private static char[][] maze = { 
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#' },
			{ '.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#' },
			{ '#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#' },
			{ '#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.' },
			{ '#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
			{ '#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
			{ '#', '#', '.', '#', '.', '#', '.', '#', '.', '.', '.', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#' },
			{ '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#' },
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };
	
	public static void main(String[] args) {

		int[] start = {2,0};
		boolean startFlag = true;
		char[][] generatedMazeWithData = mazeGenerator(12, 12);
		mazeTraversal(maze, start, startFlag);
		displayMaze(maze);
	}

	private static void displayMaze(char[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static char[][] mazeGenerator(int height, int width) {
		char[][] generatedMaze = new char[height][width];
		int startingPoint = 1 + randomNumbers.nextInt(height - 1);
		int startingWall = randomNumbers.nextInt(4);
		int endingPoint = 1 + randomNumbers.nextInt(width - 1);
		int endingWall = randomNumbers.nextInt(4);
		return null;
	}

	private static boolean mazeTraversal(char[][] maze, int[] startingPosition, boolean startFlag){
		maze[startingPosition[0]][startingPosition[1]] = 'x';
		displayMaze(maze);
		System.out.println();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if ((startingPosition[1] + 1 == maze.length && startFlag != true) ||
				(startingPosition[0] - 1 < 0 && startFlag != true) ||
				(startingPosition[1] - 1 < 0 && startFlag != true) ||
				(startingPosition[0] + 1 == maze.length && startFlag != true)){
			System.out.println("DONE");
			return true;
		} else {
			for (int i = 0; i < 4; i++) {
				if (checkPath(i, maze, startingPosition)){
					int[] position = determinePosition(i, startingPosition);
					if (mazeTraversal(maze, position, false)){
						return true;
					}
				}
			}
		}
		maze[startingPosition[0]][startingPosition[1]] = '.';
		return false;
	}

	private static int[] determinePosition(int i, int[] position) {
		int[] newPosition = new int[2];
		// move up
		if (i == 0){
			newPosition[0] = position[0] + 1;
			newPosition[1] = position[1];
		}
		// move down
		if (i == 1){
			newPosition[0] = position[0] - 1;
			newPosition[1] = position[1];
		}
		// move left
		if (i == 2){
			newPosition[0] = position[0];
			newPosition[1] = position[1] - 1;
		}
		// move right
		if (i == 3){
			newPosition[0] = position[0];
			newPosition[1] = position[1] + 1;
		}
		return newPosition;
	}

	private static boolean checkPath(int i, char[][] maze, int[] position) {
		boolean goodToGo = false;
		// check up
		if (i == 0) {
			if (position[0] + 1 < maze.length && maze[position[0] + 1][position[1]] == '.') {
				goodToGo = true;
			}
		}
		// check down
		if (i == 1) {
			if (position[0] - 1 >= 0 && maze[position[0] - 1][position[1]] == '.') {
				goodToGo = true;
			}
		}
		// check left
		if (i == 2) {
			if (position[1] - 1 >= 0 && maze[position[0]][position[1] - 1] == '.') {
				goodToGo = true;
			}
		}
		// check right
		if (i == 3) {
			if (position[1] + 1 < maze.length && maze[position[0]][position[1] + 1] == '.') {
				goodToGo = true;
			}
		}
		return goodToGo;
	}
}
