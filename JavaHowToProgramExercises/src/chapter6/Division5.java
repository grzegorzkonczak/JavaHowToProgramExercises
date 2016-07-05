// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.17 page 281
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class Division5 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter integers or end of file to exit:");
		while (input.hasNext()) {
			int num1 = input.nextInt();
			boolean divisable = isDivisable(num1);
			System.out.println(divisable);
			System.out.println("Enter integer or end of file to exit:");
		}
	}

	private static boolean isDivisable(int num1) {
		if (num1 % 5 == 0)
			return true;
		else
			return false;
	}
}
