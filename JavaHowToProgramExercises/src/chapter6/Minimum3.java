// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.23 page 282
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class Minimum3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 3 doubles:");
		double x = input.nextDouble();
		double y = input.nextDouble();
		double z = input.nextDouble();
		
		System.out.println("Minimum number is: " + isMinimum(x, y, z));
	}

	private static double isMinimum(double x, double y, double z) {
		double min = Math.min(x, Math.min(y, z));
		return min;
	}
}
