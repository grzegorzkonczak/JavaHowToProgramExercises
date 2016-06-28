// Grzegorz Koñczak, 28.06.2016
// Exercise number 2.32 page 109
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_32 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int a, b, c, d, e;
		int positive = 0;
		int negative = 0;
		int zero = 0;
		
		System.out.println("Enter 5 positive, negative or zero integers:");
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		d = input.nextInt();
		e = input.nextInt();
		
		if (a == 0)
			zero++;
		if (a < 0)
			negative++;
		if (a > 0)
			positive++;
		
		if (b == 0)
			zero++;
		if (b < 0)
			negative++;
		if (b > 0)
			positive++;
		
		if (c == 0)
			zero++;
		if (c < 0)
			negative++;
		if (c > 0)
			positive++;
		
		if (d == 0)
			zero++;
		if (d < 0)
			negative++;
		if (d > 0)
			positive++;
		
		if (e == 0)
			zero++;
		if (e < 0)
			negative++;
		if (e > 0)
			positive++;
		
		System.out.printf("Number of positive integers: %d%nNumber of negative integers: %d%nNumber of zero's: %d%n",
				positive, negative, zero);
		
		input.close();
	}

}
