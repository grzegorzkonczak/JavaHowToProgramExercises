// Grzegorz Koñczak, 27.06.2016
// Exercise number 2.25 page 108
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_25 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int x;
		
		System.out.print("Enter integer you wish to check: ");
		x = input.nextInt();
		
		if (x % 3 == 0)
			System.out.println("Yep, it's divisable by 3!");
		if (x % 3 != 0)
			System.out.println("Nope, it's not divisble by 3!");
		
		input.close();
	}

}
