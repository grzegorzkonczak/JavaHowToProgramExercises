// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.37 page 192
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class Factorial3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of terms to calculate: ");
		double number = input.nextDouble();
		double power = 1;
		double eEstimate = 1;
		
		while (number > 0){
			eEstimate = eEstimate + (Math.pow(number + power - 1, power) / factorialCalculation(power));
			System.out.println(eEstimate);
			number--;
			power++;
		}
		
		System.out.println("The estimate value of e^x is " + eEstimate);
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