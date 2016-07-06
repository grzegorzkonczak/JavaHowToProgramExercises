// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.29 page 283
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;
import java.security.SecureRandom;

public class CoinTosser {
	
	private static final SecureRandom random = new SecureRandom();
	private enum Coin { HEADS, TAILS };

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 1 to flip coin or 0 to quit:");
		int wantToPlay = input.nextInt();
		int headsFlipped = 0;
		int tailsFlipped = 0;
		int totalFlips = 0;
		
		while(wantToPlay == 1){
			Coin currentFlip = flip();
			if(currentFlip == Coin.HEADS){
				headsFlipped++;
				System.out.println("Heads!");
			}else{
				tailsFlipped++;
				System.out.println("Tails!");
			}
			totalFlips++;
			System.out.print("Enter 1 to flip coin or 0 to quit:");
			wantToPlay = input.nextInt();
		}
		
		System.out.println("Total flips: " + totalFlips);
		System.out.println("Heads: " + headsFlipped);
		System.out.println("Tails: " + tailsFlipped);
	}
	
	private static Coin flip(){
		int toss = random.nextInt(2);
		if(toss == 0){
			return Coin.HEADS;
		}else{
			return Coin.TAILS;
		}
	}
}
