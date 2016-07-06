// Grzegorz Koñczak, 06.07.2016
// Exercise number 6.33 page 283
// Exercise from Java:How to program 10th edition

package chapter6;

import java.security.SecureRandom;
import java.util.Scanner;

public class CrapsEnchanced {
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

	// plays one game of craps
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int balance = 1000;
		System.out.println("Wanna play? (1 - play, 0 - quit)"); // prompting user if he wants to play
		int gameOn = input.nextInt();
		int wager = 1001;
		System.out.println("Your balance is: " + balance); // displaying balance of player account
		while (wager > balance || wager < 1) { // loop for checking correct wager amount
			System.out.print("Enter wager (no more then balance, no less then 1):");
			wager = input.nextInt();
			chatter();
		}

		while (balance != 0 && gameOn != 0) {
			int myPoint = 0; // point if no win or loss on first roll
			Status gameStatus; // can contain CONTINUE, WON or LOST

			int sumOfDice = rollDice(); // first roll of the dice

			// determine game status and point based on first roll
			switch (sumOfDice) {
			case SEVEN: // win with 7 on first roll
			case YO_LEVEN: // win with 11 on first roll
				gameStatus = Status.WON;
				balance += wager;
				break;
			case SNAKE_EYES: // lose with 2 on first roll
			case TREY: // lose with 3 on first roll
			case BOX_CARS: // lose with 12 on first roll
				gameStatus = Status.LOST;
				balance -= wager;
				break;
			default: // did not win or lose, so remember point
				gameStatus = Status.CONTINUE; // game is not over
				myPoint = sumOfDice; // remember the point
				System.out.printf("Point is %d%n", myPoint);
				break;
			}

			// while game is not complete
			while (gameStatus == Status.CONTINUE) // not WON or LOST
			{
				sumOfDice = rollDice(); // roll dice again

				// determine game status
				if (sumOfDice == myPoint){ // win by making point
					gameStatus = Status.WON;
					balance += wager;
				}else if (sumOfDice == SEVEN){ // lose by rolling 7 before point
					gameStatus = Status.LOST;
					balance -= wager;
				}
			}

			// display won or lost message
			if (gameStatus == Status.WON){
				System.out.println("Player wins");
				chatter();
			}else
				System.out.println("Player loses");
			
			System.out.println("Your balance is: " + balance); // display current balance
			if(balance != 0){ // Asking about next game if player is not busted
				System.out.println("Still wanna play? (1 - play, 0 - quit)"); // prompting user if he still wants to play
				gameOn = input.nextInt();
				System.out.print("Enter wager (no more then balance, no less then 1):");
				wager = input.nextInt();
				chatter();
				
				while (wager > balance || wager < 1) { // loop for checking correct wager amount if player is not busted
					System.out.print("Enter wager (no more then balance, no less then 1):");
					wager = input.nextInt();
				}
			}
		}

		if (balance <= 0)
			System.out.println("Sorry, You busted!"); // message at the end if
														// player lost all money
		else if (gameOn == 0)
			System.out.println("Goodbye!"); // message at the end if player
											// quits
	}

	// roll dice, calculate sum and display results
	public static int rollDice() {
		// pick random die values
		int die1 = 1 + randomNumbers.nextInt(6); // first die roll
		int die2 = 1 + randomNumbers.nextInt(6); // second die roll

		int sum = die1 + die2; // sum of die values

		// display results of this roll
		System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

		return sum;
	}
	
	public static void chatter(){ // simple chatter simulation method
		int randomChatter = randomNumbers.nextInt(5);
		switch(randomChatter){
		case 0:
			System.out.println("Oh, you'r going for broker, huh?");
			break;
		case 1:
			System.out.println("You'r up big! Now is the time to chip in!");
			break;
		case 2:
			System.out.println("Aw c'mon, take a chance!");
			break;
		case 3:
			System.out.println("Nice! Your a man.");
			break;
		case 4:
			System.out.println("Here comes Johnny!");
			break;
		}
	}
}