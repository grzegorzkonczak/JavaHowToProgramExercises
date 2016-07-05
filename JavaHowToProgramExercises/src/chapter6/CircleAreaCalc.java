// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.20 page 281
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class CircleAreaCalc {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter radius of circle: ");
		System.out.println("Circle area is : " + circleArea(input.nextDouble()));
	}

	private static double circleArea(double r) {
		double area = Math.PI * Math.pow(r, 2);
		return area;
	}
}
