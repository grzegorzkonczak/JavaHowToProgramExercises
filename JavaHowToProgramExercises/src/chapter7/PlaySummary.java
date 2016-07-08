// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.18 page 343
// Exercise from Java:How to program 10th edition

// Simple class for generating summary of simulated game of craps

package chapter7;

public class PlaySummary {

	int rolls;
	boolean gameWon;

	public int getRolls() {
		return rolls;
	}

	public void setRolls(int rolls) {
		this.rolls = rolls;
	}

	public boolean isGameWon() {
		return gameWon;
	}

	public void setGameWon(boolean gameWon) {
		this.gameWon = gameWon;
	}

}
