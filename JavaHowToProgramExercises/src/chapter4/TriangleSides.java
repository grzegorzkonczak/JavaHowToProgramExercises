// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.35 page 192
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class TriangleSides {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter 3 integers for sides of possible triangle:");
		int side1 = input.nextInt();
		int side2 = input.nextInt();
		int side3 = input.nextInt();

		if (side1 + side2 > side3) {
			if (side1 + side3 > side2) {
				if (side2 + side3 > side1)
					System.out.println("It could be triangle!");
				else
					System.out.println("Impossible triangle!");
			} else
				System.out.println("Impossible triangle!");
		} else
			System.out.println("Impossible triangle!");

		input.close();
	}

}
