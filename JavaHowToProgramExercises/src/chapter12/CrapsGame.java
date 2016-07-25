// Grzegorz Koñczak, 25.07.2016
// Exercise number 12.16 page 592
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.EventQueue;
import java.security.SecureRandom;

import javax.swing.JFrame;

public class CrapsGame extends JFrame {

	private CrapsGUI gui;

	// create secure random number generator for use in method rollDice
	private static final SecureRandom randomNumbers = new SecureRandom();

	// enum type with constants that represent the game status
	private enum Status {
		CONTINUE, WON, LOST
	};

	// constants that represent common rolls of the dice
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;

	int myPoint = 0; // point if no win or loss on first roll
	Status gameStatus; // can contain CONTINUE, WON or LOST

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrapsGame frame = new CrapsGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrapsGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		gui = new CrapsGUI(this);
		this.add(gui);
	}

	public void rollDiceClicked() {

		if (myPoint == 0) {
			gui.setPoint(String.format(""));
			int sumOfDice = rollDice(); // first roll of the dice

			// determine game status and point based on first roll
			switch (sumOfDice) {
			case SEVEN: // win with 7 on first roll
			case YO_LEVEN: // win with 11 on first roll
				gameStatus = Status.WON;
				gui.setGameStatus(Status.WON.toString());
				break;
			case SNAKE_EYES: // lose with 2 on first roll
			case TREY: // lose with 3 on first roll
			case BOX_CARS: // lose with 12 on first roll
				gameStatus = Status.LOST;
				gui.setGameStatus(Status.LOST.toString());
				break;
			default: // did not win or lose, so remember point
				gameStatus = Status.CONTINUE; // game is not over
				gui.setGameStatus(Status.CONTINUE.toString());
				myPoint = sumOfDice; // remember the point
				gui.setPoint(String.valueOf(myPoint));
				break;
			}
		} else {
			int sumOfDice = rollDice(); // roll dice again

			// determine game status
			if (sumOfDice == myPoint) { // win by making point
				gameStatus = Status.WON;
				gui.setGameStatus(Status.WON.toString());
				myPoint = 0;
			} else if (sumOfDice == SEVEN) { // lose by rolling 7 before
												// point
				gameStatus = Status.LOST;
				gui.setGameStatus(Status.LOST.toString());
				myPoint = 0;
			}
		}
	}

	public int rollDice() {
		// pick random die values
		int die1 = 1 + randomNumbers.nextInt(6); // first die roll
		int die2 = 1 + randomNumbers.nextInt(6); // second die roll

		int sum = die1 + die2; // sum of die values

		// display results of this roll
		gui.setRollOne(String.valueOf(die1));
		gui.setRollTwo(String.valueOf(die2));
		gui.setRollSum(String.valueOf(die1 + die2));

		return sum;
	}
}
