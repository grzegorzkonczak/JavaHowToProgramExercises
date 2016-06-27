// Grzegorz Koñczak, 27.06.2016
// Exercise number 2.16 page 107
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_16 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int x;
		int xsquare;
		
		System.out.print("Enter integer: ");
		x = input.nextInt();
		xsquare = x * x;
		
		if (x > 100)
			System.out.println("Number and it's square is greater then 100");
		if (x < 100)
			System.out.println("Number is less then 100");
		if (xsquare < 100)
			System.out.println("It's square also");
		if (xsquare > 100)
			System.out.println("Numbers square is greater then 100");
		if (x == 100)
			System.out.println("Number is exactly 100");
		if (xsquare == 100)
			System.out.println("Square of the number is exactly 100");
		if (x != 100)
			System.out.println("The number is not equal to 100");
		if (xsquare != 100)
			System.out.println("Square of the number is not equal 100");
		
		input.close();
	}

}
