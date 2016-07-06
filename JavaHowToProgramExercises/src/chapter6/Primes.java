// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.25 page 282
// Exercise from Java:How to program 10th edition

package chapter6;

public class Primes {

	public static void main(String[] args) {
		int total = 0;
		for (int i = 2; i <= 100; i++) {
			if (isPrime(i)){
				System.out.println(i);
				total++;
			}
		}
		System.out.println("Total: " + total);
	}

	/*
	private static boolean isPrime(int number){
		boolean prime = true;
		for (int i = 2; i < (number / 2) + 1; i++){
			System.out.println("Pass " + (i - 2)); // line added to compare two algorithms (n/2 loops)
			if(number % i == 0){
				prime = false;
			}
		}
		return prime;
	}
	*/
	
	private static boolean isPrime(int number){
		boolean prime = true;
		for (int i = 2; i <= Math.ceil(Math.sqrt(number)); i++){
			System.out.println("Pass " + (i- 2)); // line added to compare two algorithms (sqrt(n) loops)
			if(number % i == 0){
				prime = false;
			}
		}
		if(number == 2)
			prime = true;
		return prime;
	}
	
}
