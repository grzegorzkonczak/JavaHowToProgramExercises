// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.10 page 280
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class RoundingNumbersEnchanced {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter double or end of file (Ctrl + z) to quit: ");
		while (input.hasNext()){
			double number = input.nextDouble();
			
			System.out.println("Original: " + number + ", rounded: " + roundToInteger(number) + 
					", rounded to tenths: " + roundToTenths(number) + 
					", rounded to tenths: " + roundToHundreths(number) + 
					", rounded to tenths: " + roundToThousandths(number));
			System.out.print("Enter double or end of file (Ctrl + z) to quit: ");
		}
	}
	
	private static double roundToThousandths(double number) {
		double result = Math.floor(number * 1000 + 0.5) / 1000;
		return result;
	}
	
	private static double roundToHundreths(double number) {
		double result = Math.floor(number * 100 + 0.5) / 100;
		return result;
	}

	private static double roundToTenths(double number) {
		double result = Math.floor(number * 10 + 0.5) / 10;
		return result;
	}

	private static double roundToInteger(double number) {
		double result = Math.floor(number + 0.5);
		return result;
	}
}
