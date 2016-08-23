// Grzegorz Koñczak, 23.08.2016
// Exercise number 18.9 page 847
// Exercise from Java:How to program 10th edition

package chapter18;

import java.util.Scanner;

public class RecursivePowerMethod {

	private final static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Enter base number: ");
		int base = input.nextInt();
		System.out.print("Enter exponent: ");
		int exponent = input.nextInt();
		
		int result = recursivePower(base, exponent);
		
		System.out.println("Result is: " + result);
	}

	private static int recursivePower(int base, int exponent) {
		if(exponent == 1){
			return base;
		} else {
			return base * recursivePower(base, exponent - 1);
		}
	}
}
