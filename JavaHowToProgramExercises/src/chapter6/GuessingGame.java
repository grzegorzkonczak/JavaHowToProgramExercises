// Grzegorz Koñczak, 06.07.2016
// Exercise number 6.30/6.31 page 283
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;
import java.security.SecureRandom;

public class GuessingGame {

	private static final SecureRandom random = new SecureRandom();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int numberToGuess = 1 + random.nextInt(1000);
		System.out.print("Enter your first guess: ");
		int guess =input.nextInt();
		int totalGuesses = 0;
		
		while (numberToGuess != guess){
			if(guess > numberToGuess)
				System.out.println("Too high. Try again.");
			else
				System.out.println("Too low. Try again");
			
			totalGuesses++;
			System.out.print("Enter your guess: ");
			guess =input.nextInt();
		}
		System.out.println("Congratulations - " + guess + " is correct!");
		if(totalGuesses < 10)
			System.out.println("Either You know a secret or You got lucky!");
		else if(totalGuesses == 10)
			System.out.println("Aha, You know the secret!");
		else
			System.out.println("You should do better!");
	}
}
