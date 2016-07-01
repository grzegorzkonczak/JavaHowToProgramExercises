// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.11 page 238
// Exercise from Java:How to program 10th edition

package chapter5;

import java.util.Scanner;

public class Extremes {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int largest = 0;
		int smallest = 0;
		int counter = 0;
		
		System.out.println("How many integers you want to check?");
		counter = input.nextInt();
		
		for(int i = 0; i < counter; i++){
			System.out.print("Enter integer: ");
			int num = input.nextInt();
			
			if ((num > largest) || (largest == 0))
				largest = num;
			if ((num < smallest) || (smallest == 0))
				smallest = num;
		}
		
		System.out.println("Largest number: " + largest);
		System.out.println("Smallest number: " + smallest);
		System.out.printf("Sum of extremes: %d", largest + smallest);
	}
}
