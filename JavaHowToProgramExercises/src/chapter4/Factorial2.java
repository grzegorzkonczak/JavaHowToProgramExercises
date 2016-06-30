// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.37 page 192
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class Factorial2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of terms to calculate: ");
		double number = input.nextDouble();
		
		double eEstimate = 1;
		
		while (number > 0){
			eEstimate += 1 / factorialCalculation(number);
			number--;
		}
		
		System.out.println("The estimate value of e is " + eEstimate);
		input.close();
	}

	public static double factorialCalculation(double number) {
		double factorial = number;

		while (number > 1) {
			number--;
			factorial *= number;
		}
		return factorial;
	}
}