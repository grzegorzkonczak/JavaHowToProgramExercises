// Grzegorz Koñczak, 29.06.2016
// Exercise number 4.21 page 189
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class FindLargestNumber {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int counter = 1;
		int largest = 0;
		
		while(counter <= 10){
			System.out.print("Enter next number: ");
			int number = input.nextInt();
			if(number > largest)
				largest = number;
			counter++;
		}
		System.out.println("Largest number was: " + largest);
		input.close();
	}

}
