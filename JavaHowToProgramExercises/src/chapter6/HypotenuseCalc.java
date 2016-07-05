// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.15 page 280
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class HypotenuseCalc {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter sides of triangle as doubles to calculate hypotenuse:");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		System.out.println("Hypotenuse is: " + hypotenuse(side1, side2));
	}
	
	private static double hypotenuse(double side1, double side2){
		double hypotenuseSquare = Math.pow(side1, 2) + Math.pow(side2, 2);
		double hypotenuse = Math.sqrt(hypotenuseSquare);
		return hypotenuse;
	}
}
