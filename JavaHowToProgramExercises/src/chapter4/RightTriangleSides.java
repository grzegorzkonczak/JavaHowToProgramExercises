// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.36 page 192
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class RightTriangleSides {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter 3 integers for sides of possible triangle:");
		int side1 = input.nextInt();
		int side2 = input.nextInt();
		int side3 = input.nextInt();

		int side1Squr = side1 * side1;
		int side2Squr = side2 * side2;
		int side3Squr = side3 * side3;

		if (side1Squr + side2Squr == side3Squr){
			System.out.println("It is a right triangle!");
		}else if (side2Squr + side3Squr == side1Squr){
			System.out.println("It is a right triangle!");
		}else if (side1Squr + side3Squr == side2Squr){
			System.out.println("It is a right triangle!");
		}else
			System.out.println("This cannot be right triangle!");
		
		input.close();
	}
}
