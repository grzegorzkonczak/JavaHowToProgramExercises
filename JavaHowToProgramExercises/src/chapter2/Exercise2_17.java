// Grzegorz Koñczak, 27.06.2016
// Exercise number 2.17 page 107
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_17 {
	
	public static void main(String[] args) {	
		
		// Declaring all needed variables
		Scanner input = new Scanner(System.in);
		int x, y, z;
		int sum;
		int average;
		int product;
		int smallest;
		int largest;
		
		// Prompting user for data
		System.out.println("Please enter 3 integers:");
		x = input.nextInt();
		y = input.nextInt();
		z = input.nextInt();
		
		// Calculating according to exercise specification
		sum = x + y + z;
		average = sum / 3;
		product = x * y * z;
		
		// Crude way to determine smallest and largest numbers
		smallest = x;
		if (y < x)
			smallest = y;
		if (z < y)
			smallest = z;
		
		largest = x;
		if (y > x)
			largest = y;
		if (z > y)
			largest = z;
		
		// Displaying the results
		System.out.printf("The sum = %d%nThe average = %d%nThe product = %d%nThe smallest = %d%nThe largest = %d%n",
				sum, average, product, smallest, largest);
		
		input.close();
	}
}
