// Grzegorz Koñczak, 06.07.2016
// Exercise number 6.32 page 283
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class PointsDistance {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter coordinates of points you want to calculate distance between (in order x1, y1, x2, y2): ");
		double distance = distance(input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble());
		System.out.println("The distance is " + distance);
	}
	
	private static double distance(double x1, double y1, double x2, double y2){
		double side1 = Math.abs(x1 - x2);
		double side2 = Math.abs(y1 - y2);
		
		double distance = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
		return distance;
	}
}
