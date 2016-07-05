// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.9 page 280
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class RoundingNumbers {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter double or end of file (Ctrl + z) to quit: ");
		while (input.hasNext()){
			double number = input.nextDouble();
			int roundedNumber = (int) Math.floor(number + 0.5);
			
			System.out.println("Original: " + number + ", rounded: " + roundedNumber);
			System.out.print("Enter double or end of file (Ctrl + z) to quit: ");
		}
	}
}
