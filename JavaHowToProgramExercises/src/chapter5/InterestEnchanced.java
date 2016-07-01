// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.14 page 238
// Exercise from Java:How to program 10th edition

package chapter5;

public class InterestEnchanced {
	public static void main(String args[]) {
		double amount; // amount on deposit at end of each year
		double principal = 1000.0; // initial amount before interest
		double rate = 1.05; // interest rate
		double rateChange = 0.01;

		// display headers
		System.out.printf("%5s%6s%20s%n","Rate", "Year", "Amount on deposit");

		// calculate amount on deposit for each of ten years
		for (int year = 1; year <= 10; year++) {
			// calculate amount on deposit for various interest rates
			for (int i = 0; i < 6; i++) {
				// calculate new amount for specified year
				amount = principal * Math.pow(rate + (rateChange * i), year);

				// display the year and the amount
				System.out.printf("%4.1f%%%6d%,20.2f%n",(double)5 + i, year, amount);
			}
			System.out.println();
		}
	}
}
