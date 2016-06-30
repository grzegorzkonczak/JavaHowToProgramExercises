// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.29 page 192
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class RightAngledTriangle {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int base = 0;
		int counter = 0;
		System.out.print("Enter base of triangle: ");
		base = input.nextInt();

		while (base > 0) {
			counter = 1;
			base--;
			while (base > counter) {
				System.out.print("*");
				counter++;
			}
			System.out.println();
		}
	}

}
