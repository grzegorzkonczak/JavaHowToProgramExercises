// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.19 page 281
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class SquareAnyChar {

public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter side length: ");
		int side = input.nextInt();
		System.out.print("Enter character to print: ");
		char fill = input.next().charAt(0);
		squareOfCharacters(side, fill);
	}

	private static void squareOfCharacters(int side, char fill) {
		for(int i = 0; i < side; i++){
			for(int j = 0; j < side; j++){
				System.out.print(fill);
			}
			System.out.println();
		}
		
	}
}
