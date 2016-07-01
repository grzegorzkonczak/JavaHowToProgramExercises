// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.16 page 239
// Exercise from Java:How to program 10th edition

package chapter5;

import java.util.Scanner;

public class BarChart {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 5 numbers beatween 1 and 30:");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		int number4 = input.nextInt();
		int number5 = input.nextInt();
		
		printBar(number1);
		printBar(number2);
		printBar(number3);
		printBar(number4);
		printBar(number5);
		
		input.close();
		
	}
	public static void printBar(int length){
		
		for(int i = 0; i < length; i++){
			System.out.print('*');
		}
		System.out.println();
	}
}
