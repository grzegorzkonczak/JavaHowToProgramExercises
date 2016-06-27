// Grzegorz Koñczak, 27.06.2016
// Exercise number 2.26 page 108
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_26 {

		public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in);
			int x, y;
			
			System.out.println("Enter two integers:");
			x = input.nextInt();
			y = input.nextInt();
			
			x = x * 3;
			y = y * 2;
			
			if (x % y == 0)
				System.out.println("First number tripled is multiple of second number doubled.");
			if (x % y != 0)
				System.out.println("First number tripled is not multiple of second number doubled.");
			
			input.close();
		}
}
