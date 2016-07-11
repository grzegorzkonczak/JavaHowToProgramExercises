// Grzegorz Koñczak, 11.07.2016
// Exercise number 7.22 page 345
// Exercise from Java:How to program 10th edition

// Unfinished

package chapter7;

public class KnightsTourHeuristic {

	private static enum Direction {
		UP_RIGHT, RIGHT_UP, RIGHT_DOWN, DOWN_RIGHT, DOWN_LEFT, LEFT_DOWN, LEFT_UP, UP_LEFT
	}

	public static void main(String[] args) {

		calculateAccessibility();
		int moves = moveOnCheckerboard();
		displayReport(moves);
	}

	private static int moveOnCheckerboard() {
		int movesTaken = 0;

		while (isPossibleMovesLeft()) {
			movesTaken++;
			moveToLeastAccessable(movesTaken);
			calculateAccessibility();
		}
		return movesTaken;
	}

	private static void moveToLeastAccessable(int moves) {
		int[] leastAccessibleCoordinates = calculateLeastAccesible();
		moveToCoordinate(leastAccessibleCoordinates, moves);
	}

	private static void moveToCoordinate(int[] leastAccessibleCoordinates, int moves) {
		Direction whichDirection = determineDirection(leastAccessibleCoordinates);
		move(whichDirection, moves);
		System.out.println(whichDirection);
		displayReport(moves);
	}

	private static void move(Direction whichDirection, int moves) {
		boolean moved = false;
		while (!moved && isPossibleMovesLeft()) {
			switch (whichDirection) {
			case LEFT_UP:
			case UP_LEFT:
				if (!validateOutOfBounds(currentRow + horizontal[3], currentColumn + vertical[3])) {
					if (isNotVisited(currentRow + horizontal[3], currentColumn + vertical[3])) {
						board[currentRow + horizontal[3]][currentColumn + vertical[3]] = moves;
						currentRow = currentRow + horizontal[3];
						currentColumn = currentColumn + vertical[3];
						moved = true;
					}
				} else if (!validateOutOfBounds(currentRow + horizontal[2], currentColumn + vertical[2])) {
					if (isNotVisited(currentRow + horizontal[2], currentColumn + vertical[2])) {
						board[currentRow + horizontal[2]][currentColumn + vertical[2]] = moves;
						currentRow = currentRow + horizontal[2];
						currentColumn = currentRow + vertical[2];
						moved = true;
					}
				}
				break;
			case LEFT_DOWN:
			case DOWN_LEFT:
				if (!validateOutOfBounds(currentRow + horizontal[4], currentColumn + vertical[4])) {
					if (isNotVisited(currentRow + horizontal[4], currentColumn + vertical[4])) {
						board[currentRow + horizontal[4]][currentColumn + vertical[4]] = moves;
						currentRow = currentRow + horizontal[4];
						currentColumn = currentColumn + vertical[4];
						moved = true;
					}
				} else if (!validateOutOfBounds(currentRow + horizontal[0], currentColumn + vertical[0])) {
					if (isNotVisited(currentRow + horizontal[0], currentColumn + vertical[0])) {
						board[currentRow + horizontal[0]][currentColumn + vertical[0]] = moves;
						currentRow = currentRow + horizontal[0];
						currentColumn = currentColumn + vertical[0];
						moved = true;
					}
				}
				break;
			case RIGHT_DOWN:
			case DOWN_RIGHT:
				if (!validateOutOfBounds(currentRow + horizontal[6], currentColumn + vertical[6])) {
					if (isNotVisited(currentRow + horizontal[6], currentColumn + vertical[6])) {
						board[currentRow + horizontal[6]][currentColumn + vertical[6]] = moves;
						currentRow = currentRow + horizontal[6];
						currentColumn = currentColumn + vertical[6];
						moved = true;
					}
				} else if (!validateOutOfBounds(currentRow + horizontal[7], currentColumn + vertical[7])) {
					if (isNotVisited(currentRow + horizontal[7], currentColumn + vertical[7])) {
						board[currentRow + horizontal[7]][currentColumn + vertical[7]] = moves;
						currentRow = currentRow + horizontal[7];
						currentColumn = currentColumn + vertical[7];
						moved = true;
					}
				}
				break;
			case RIGHT_UP:
			case UP_RIGHT:
				if (!validateOutOfBounds(currentRow + horizontal[5], currentColumn + vertical[5])) {
					if (isNotVisited(currentRow + horizontal[5], currentColumn + vertical[5])) {
						board[currentRow + horizontal[5]][currentColumn + vertical[5]] = moves;
						currentRow = currentRow + horizontal[5];
						currentColumn = currentRow + vertical[5];
						moved = true;
					}
				} else if (!validateOutOfBounds(currentRow + horizontal[1], currentColumn + vertical[1])) {
					if (isNotVisited(currentRow + horizontal[1], currentColumn + vertical[1])) {
						board[currentRow + horizontal[1]][currentColumn + vertical[1]] = moves;
						currentRow = currentRow + horizontal[1];
						currentColumn = currentColumn + vertical[1];
						moved = true;
					}
				}
				break;
			}
			whichDirection = changeDirection(whichDirection);
		}

	}

	private static Direction changeDirection(Direction whichDirection) {
		if (Direction.DOWN_LEFT == whichDirection)
			whichDirection = Direction.DOWN_RIGHT;
		else if (Direction.DOWN_RIGHT == whichDirection)
			whichDirection = Direction.LEFT_UP;
		else if (Direction.LEFT_UP == whichDirection)
			whichDirection = Direction.LEFT_DOWN;
		else if (Direction.LEFT_DOWN == whichDirection)
			whichDirection = Direction.RIGHT_UP;
		else if (Direction.RIGHT_UP == whichDirection)
			whichDirection = Direction.UP_LEFT;
		else if (Direction.UP_LEFT == whichDirection)
			whichDirection = Direction.UP_RIGHT;
		else if (Direction.UP_RIGHT == whichDirection)
			whichDirection = Direction.RIGHT_DOWN;
		else
			whichDirection = Direction.DOWN_LEFT;
		return whichDirection;
	}

	private static boolean isNotVisited(int i, int j) {
		if (board[i][j] == 0)
			return true;
		return false;
	}

	private static Direction determineDirection(int[] leastAccessibleCoordinates) {
		if (leastAccessibleCoordinates[0] >= currentRow && leastAccessibleCoordinates[1] <= currentColumn)
			return Direction.LEFT_DOWN;
		if (leastAccessibleCoordinates[0] <= currentRow && leastAccessibleCoordinates[1] <= currentColumn)
			return Direction.LEFT_UP;
		if (leastAccessibleCoordinates[0] <= currentRow && leastAccessibleCoordinates[1] >= currentColumn)
			return Direction.RIGHT_UP;
		if (leastAccessibleCoordinates[0] >= currentRow && leastAccessibleCoordinates[1] >= currentColumn)
			return Direction.RIGHT_DOWN;
		return Direction.UP_RIGHT;
	}

	private static int[] calculateLeastAccesible() {
		int[] leastAccessibleCoordinates = new int[2];
		int numberOfPossibleAccesses = 10;
		for (int i = 0; i < accessibility.length; i++) {
			for (int j = 0; j < accessibility[i].length; j++) {
				if (i != currentRow && j != currentColumn) {
					if (accessibility[i][j] < numberOfPossibleAccesses && accessibility[i][j] != 0) {
						leastAccessibleCoordinates[0] = i;
						leastAccessibleCoordinates[1] = j;
					}
				}
			}
		}
		return leastAccessibleCoordinates;
	}

	private static boolean isPossibleMovesLeft() {
		for (int i = 0; i < 8; i++) {
			if (!validateOutOfBounds(currentRow + horizontal[i], currentColumn + vertical[i])) {
				if (board[currentRow + horizontal[i]][currentColumn + vertical[i]] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	private static void displayReport(int moves) {
		displayBoard(board);
		System.out.println(moves);
		displayBoard(accessibility);
		System.out.println();

	}

	private static void calculateAccessibility() {
		for (int i = 0; i < accessibility.length; i++) {
			int possibleSpacesAround = 0;
			for (int j = 0; j < accessibility[i].length; j++) {
				possibleSpacesAround = checkAccessableSpaces(i, j);
				accessibility[i][j] = possibleSpacesAround;
			}
		}
	}

	private static int checkAccessableSpaces(int x, int y) {
		int possibleSpacesAround = 0;
		for (int i = 0; i < 8; i++) {
			if (!validateOutOfBounds(x + horizontal[i], y + vertical[i])) {
				if (board[x + horizontal[i]][y + vertical[i]] == 0) {
					possibleSpacesAround++;
				}
			}
		}
		return possibleSpacesAround;
	}

	private static boolean validateOutOfBounds(int i, int j) {
		if (i < 0 || i > 7 || j < 0 || j > 7)
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

	static int[][] accessibility = new int[8][8];
	static int[][] board = new int[8][8];
	static int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int currentRow = 0;
	static int currentColumn = 0;
}
