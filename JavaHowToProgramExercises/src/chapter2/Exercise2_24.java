// Grzegorz Koñczak, 27.06.2016
// Exercise number 2.24 page 107
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_24 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int a, b, c, d, e;
		
		System.out.println("Enter 5 integers:");
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		d = input.nextInt();
		e = input.nextInt();
		
		int smallest = a;
		int largest = a;
		
		// Finding the smallest number given by user
		if (b < a)
			smallest = b;
		if (c < b)
			smallest = c;
		if (d < c)
			smallest = d;
		if (e < d)
			smallest = e;
		
		// Finding the largest number given by user
		if (b > a)
			largest = b;
		if (c > b)
			largest = c;
		if (d > c)
			largest = d;
		if (e > d)
			largest = e;
		
		System.out.printf("The smallest number is %d and the largest is %d", smallest, largest);
		
		input.close();
	}

}
