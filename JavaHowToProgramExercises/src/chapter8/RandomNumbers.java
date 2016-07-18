// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.9 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

import java.util.Scanner;
import java.util.Random;

public class RandomNumbers {

	private static final Random randomNumber = new Random();
	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("How many numbers to generate?");
		int numbersToGenerate = input.nextInt();
		
		for (int i = 0; i < numbersToGenerate; i++){
			System.out.println(10 + randomNumber.nextInt(91));
		}
	}
}
