// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.31 page 192
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class PalindromeTester {

	public static void main(String[] args) {

		// initializing variables to store numbers and sentinel
		Scanner input = new Scanner(System.in);
		int number;
		int tensThousands;
		int thousands;
		int hundreds;
		int tens;
		int ones;
		int isPalindrome = 0;

		// loop allows to ask about 5 digit palindromes until one is provided
		while (isPalindrome == 0) {
			System.out.print("Enter 5 digit integer: "); // prompt
			number = input.nextInt();

			// dividing 5 digit number into five separate digits
			tensThousands = number / 10000;
			number = number - tensThousands * 10000;
			thousands = number / 1000;
			number = number - thousands * 1000;
			hundreds = number / 100;
			number = number - hundreds * 100;
			tens = number / 10;
			ones = number % 10;
			
			// testing if the number is palindrome by comparing it's individual digits
			if(tensThousands == ones){
				if(thousands == tens){
					System.out.println("It is palindrome!");
					isPalindrome = 1;
				}else{
					System.out.println("Not a palindrome.\n");
				}
			}else{
				System.out.println("Not a palindrome.\n");
			}
		}
		input.close();
	}
}