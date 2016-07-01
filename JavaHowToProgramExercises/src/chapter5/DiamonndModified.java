// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.25 page 240
// Exercise from Java:How to program 10th edition

package chapter5;

import java.util.Scanner;

public class DiamonndModified {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter odd number between 1 and 19: ");
		int size = input.nextInt();
		
		// Printing top and middle of diamond
		for (int i = 1; i < size + 1; i += 2){
			for (int j = 1; j < size - (i / 2); j++){
				System.out.print(' ');
			}
			for (int j = 0; j < i; j++){
				System.out.print('*');
			}
			System.out.println();
		}
		
		// Printing bottom of diamond
		for (int i = size - 2; i > 0; i -= 2 ){
			for (int j = 1; j < size - (i / 2); j++){
				System.out.print(' ');
			}
			for (int j = 0; j < i; j++){
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
