// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.31 page 192
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class BinaryDecimalConverter {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter how many digits number has: ");
		int counter = input.nextInt();
		System.out.print("Enter binary number: "); // prompt
		int number = input.nextInt();
		int totalDecimal = 0;

		while(counter > 1){
			int digit = number / (int) Math.pow(10, counter - 1);
			number = number % (1 * (int) Math.pow(10, counter - 1));
			totalDecimal += digit * (int)Math.pow(2, counter - 1);
			counter--;
		}
		int digit = number % 10;
		totalDecimal += digit;
		System.out.println(totalDecimal + " is decimal equivalent of binary number " + number);
		input.close();
	}
}
