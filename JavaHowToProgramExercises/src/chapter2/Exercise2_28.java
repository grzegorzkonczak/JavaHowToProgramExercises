// Grzegorz Koñczak, 27.06.2016
// Exercise number 2.28 page 108
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_28 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int radius;
		
		System.out.print("Enter radius of circle: ");
		radius = input.nextInt();
		
		System.out.printf("Diameter = %d%nCircumference = %f%nArea = %f%n",
				radius * 2, 2 * Math.PI * radius, Math.PI * radius * radius);
		
		input.close();
	}

}
