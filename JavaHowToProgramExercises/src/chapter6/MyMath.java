// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.14 page 280
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class MyMath {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter double: ");
		double number = input.nextDouble();
		System.out.println("Floor: " + myFloor(number) + ", Ceil: " + myCeil(number));
		System.out.println("Math Floor: " + Math.floor(number) + ", Math Ceil: " + Math.ceil(number));
	}

	public static int myFloor (double num){
		int result = (int) num;
		return result;
	}
	
	public static int myCeil (double num){
		int result;
		if (num - (int)num != 0){
			result = (int) num + 1;
		}else{
			result = (int) num;
		}
		return result;
	}
}
