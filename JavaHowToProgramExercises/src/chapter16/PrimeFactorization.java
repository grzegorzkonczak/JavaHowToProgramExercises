// Grzegorz Koñczak, 22.08.2016
// Exercise number 16.19 page 769
// Exercise from Java:How to program 10th edition

package chapter16;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeFactorization {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Input integer:");
		int number = input.nextInt();
		if (isPrime(number)) {
			System.out.println("This is Prime number.");
		} else {
			Set<Integer> factors = factorize(number);
			System.out.print("Prime factors of " + number + " are: ");
			for (Integer integer : factors) {
				System.out.print(integer + " ");
			}
		}
	}

	private static Set<Integer> factorize(int number) {
		Set<Integer> factors = new HashSet<Integer>();
		for (int i = 2; i <= number; i++) {
			while (number % i == 0) {
				factors.add(i);
				number /= i;
			}
		}
		return factors;
	}

	private static boolean isPrime(int number) {
		boolean prime = true;
		for (int i = 2; i <= Math.ceil(Math.sqrt(number)); i++) {
			if (number % i == 0) {
				prime = false;
			}
		}
		if (number == 2)
			prime = true;
		return prime;
	}
}
