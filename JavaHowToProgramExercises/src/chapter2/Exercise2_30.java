// Grzegorz Koñczak, 27.06.2016
// Exercise number 2.30 page 109
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_30 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int number;
		int tensThousands;
		int thousands;
		int hundreds;
		int tens;
		int ones;
		
		System.out.print("Enter 5 digit integer: ");
		number = input.nextInt();
		
		tensThousands = number / 10000;
		number = number - tensThousands * 10000;
		thousands = number / 1000;
		number = number - thousands * 1000;
		hundreds = number / 100;
		number = number - hundreds * 100;
		tens = number / 10;
		ones = number % 10;
		
		System.out.printf("%d %d %d %d %d", tensThousands, thousands, hundreds, tens, ones);
		
		input.close();
	}

}
