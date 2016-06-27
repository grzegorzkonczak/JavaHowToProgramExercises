// Grzegorz Koñczak, 27.06.2016
// Exercise number 2.15 page 107
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_15 {

	public static void main(String[] args) {
		
		// Declaring variables needed for exercise
		Scanner input = new Scanner(System.in);
		int x, y;
		int xsquare, ysquare;
		int sumsquare;
		int difsquare;
		
		// Prompting user for two integers
		System.out.print("Enter first integer: ");
		x = input.nextInt();
		System.out.println("Eter second integer: ");
		y = input.nextInt();
		
		// Performing calculations as described in exercise specification
		xsquare = x * x;
		ysquare = y * y;
		sumsquare = xsquare + ysquare;
		difsquare = xsquare - ysquare;
		
		// Displaying results to user
		System.out.printf("Square of x = %s, Square o y = %s.%nSum of squares = %s, Difference of squares = %s", 
				xsquare, ysquare, sumsquare, difsquare);
		
		input.close();
	}
}
