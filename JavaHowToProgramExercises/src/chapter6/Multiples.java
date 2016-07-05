// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.16 page 281
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class Multiples {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter pairs of integers or end of file to exit:");
		while (input.hasNext()) {
			int num1 = input.nextInt();
			int num2 = input.nextInt();
			boolean multiple = isMultiple(num1, num2);
			System.out.println(multiple);
			System.out.println("Enter pairs of integers or end of file to exit:");
		}
	}

	private static boolean isMultiple(int num1, int num2) {
		if (num2 % num1 == 0)
			return true;
		else
			return false;
	}
}
