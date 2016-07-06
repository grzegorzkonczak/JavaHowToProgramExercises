// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.27 page 282
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two integers to find greatest common divisor for:");
		System.out.println("Gratest common divisor is: " + gcd(input.nextInt(), input.nextInt()));
	}
	
	private static int gcd(int number1, int number2){
		boolean divisorFound = false;
		
		while (!divisorFound){
			int tempMax = Math.max(number1, number2);
			int tempMin = Math.min(number1, number2);
			number1 = tempMax;
			number2 = tempMin;
			System.out.println(tempMax);
			number1 = number1 - number2;
			if(number1 == number2)
				divisorFound = true;
		}
		return number1;
	}
}
