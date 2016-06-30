// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.37 page 192
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class Factorial1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter integer you want to get factorial of: ");
		int number = input.nextInt();
		int factorial = number;
		
		while (number > 1){
			number--;
			factorial *= number;
		}
		System.out.println("The factorial of your number is " + factorial);
		input.close();
	}
}
