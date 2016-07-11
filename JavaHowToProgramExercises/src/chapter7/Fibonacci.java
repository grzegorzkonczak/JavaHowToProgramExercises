// Grzegorz Koñczak, 11.07.2016
// Exercise number 7.29 page 349
// Exercise from Java:How to program 10th edition

package chapter7;

import java.util.Scanner;

public class Fibonacci {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			System.out.println("Enter n-th number of fibbonaci series:");
			double num = calculateFib(input.nextDouble());
			System.out.println(num);
		}
	}

	private static double calculateFib(double n) {
		double fib = 0;
		double a = 0;
		double b = 1;
		double temp = 0;
		for (int i = 0; i < n - 1; i++) {
			fib = b;
			temp = b;
			b = a + temp;
			a = temp;
		}
		return fib;
	}
}
