// Grzegorz Koñczak, 27.06.2016
// Adding program for exercising use of basic Java functions
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Adder2_6 {

	public static void main(String[] args) {

		// Create Scanner to read input from user
		Scanner input = new Scanner(System.in);
		int x, y, z, result;
		
		// Promp the user repedatly to provide numbers for adding
		System.out.print("Enter first integer: ");
		x = input.nextInt();
		System.out.print("Enter second integer: ");
		y = input.nextInt();
		System.out.print("Enter third integer: ");
		z = input.nextInt();
		
		// Compute the result and display it to user
		result = x + y + z;
		System.out.printf("The product is %d%n", result);
		input.close();

	}

}
