// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.17 page 342
// Exercise from Java:How to program 10th edition

package chapter7;

import java.security.SecureRandom;

public class DiceRolling {

	private static final SecureRandom random = new SecureRandom();
	
	public static void main(String[] args) {
		
		int rollOne;
		int rollTwo;
		int[] frequency = new int[13];
		int sum;
		
		for(int i = 0; i < 36000000; i++){
			rollOne = rollDie();
			rollTwo = rollDie();
			sum = rollOne + rollTwo;
			++frequency[sum];
		}
		
		System.out.println("Frequency of rolls:");
		for(int i = 1; i < frequency.length - 1; i++){
			System.out.printf("%2d --> %-10d%n", (i + 1), frequency[i + 1]);
		}
	}
	
	private static int rollDie(){
		int oneRoll = 1 + random.nextInt(6);
		return oneRoll;
	}
}
