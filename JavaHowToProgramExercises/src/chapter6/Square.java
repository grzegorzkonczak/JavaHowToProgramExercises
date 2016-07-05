// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.18 page 281
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class Square {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter side length: ");
		int side = input.nextInt();
		squareOfAsterisks(side);
	}

	private static void squareOfAsterisks(int side) {
		for(int i = 0; i < side; i++){
			for(int j = 0; j < side; j++){
				System.out.print('*');
			}
			System.out.println();
		}
		
	}
}
