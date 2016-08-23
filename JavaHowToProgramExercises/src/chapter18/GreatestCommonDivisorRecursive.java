// Grzegorz Koñczak, 23.08.2016
// Exercise number 18.11 page 848
// Exercise from Java:How to program 10th edition

package chapter18;

import java.util.Scanner;

public class GreatestCommonDivisorRecursive {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter two integers to find greatest common divisor for:");
		int int1 = input.nextInt();
		int int2 = input.nextInt();
		int result1 = gcd(int1, int2);
		int result2 = gcdRecursive(int1, int2);
		System.out.println("Gratest common divisor traditional is: " + result1);
		System.out.println("Gratest common divisor recursive is: " + result2);
	}

	private static int gcdRecursive(int int1, int int2) {
		if (int2 == 0){
			return int1;
		} else {
			return gcdRecursive(int2, int1 % int2);
		}
	}

	private static int gcd(int number1, int number2) {
		boolean divisorFound = false;

		while (!divisorFound) {
			int tempMax = Math.max(number1, number2);
			int tempMin = Math.min(number1, number2);
			number1 = tempMax;
			number2 = tempMin;
			number1 = number1 - number2;
			if (number1 == number2)
				divisorFound = true;
		}
		return number1;
	}
}
