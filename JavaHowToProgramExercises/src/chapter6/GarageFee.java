// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.8 page 279
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class GarageFee {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter time spent by car in garage or -1 to quit:");
		int time = input.nextInt();
		double totalFees = 0;
		
		while (time != -1){
			double carFee = calculateCharges(time);
			totalFees += carFee;
			System.out.println("This customer paid " + carFee + " fee. Total for yeasterday is: " + totalFees + ".");
			System.out.print("Enter time spent by next car in garage or -1 to quit: ");
			time = input.nextInt();
		}
		System.out.println("Total for yeasterday is: " + totalFees + ".");
	}

	private static double calculateCharges(int time) {
		double fee = 2;
		if (time > 3){
			fee += (time - 3) * 0.5;
		}
		if (fee > 10)
			fee = 10;
		return fee;
	}
}
