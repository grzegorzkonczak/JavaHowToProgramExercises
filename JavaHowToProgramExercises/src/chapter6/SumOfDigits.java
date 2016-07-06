// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.26 page 282
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter 4 digit integer: ");
		System.out.println("Sum of digits: " + digitSum(input.nextInt()));
	}

	private static int digitSum(int number) {
		// dividing number to digits
		int thousands = number / 1000;
		number = number - thousands * 1000;
		int hundreds = number / 100;
		number = number - hundreds * 100;
		int tens = number / 10;
		int ones = number % 10;
		int sum = thousands + hundreds + tens + ones;
		return sum;
	}
}
