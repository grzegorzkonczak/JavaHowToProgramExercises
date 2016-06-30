// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.38 page 193
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class Encryptor {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int plain;
		
		System.out.println("Enter 4 digit number: ");
		plain = input.nextInt();
		
		int thousands;
		int hundreds;
		int tens;
		int ones;
		
		// dividing number to digits
		thousands = plain / 1000;
		plain = plain - thousands * 1000;
		hundreds = plain / 100;
		plain = plain - hundreds * 100;
		tens = plain / 10;
		ones = plain % 10;
		
		// encrypting single digits
		thousands = encryptor1(thousands);
		hundreds = encryptor1(hundreds);
		tens = encryptor1(tens);
		ones = encryptor1(ones);
		
		// shuffling whole number
		int codedNumber = encryptor2(thousands, hundreds, tens, ones);
		
		// displaying encrypted number
		System.out.println("Your coded number is: " + codedNumber);
		
		input.close();
	}
	
	public static int encryptor1(int number){
		number += 7;
		number %= 10;
		return number;
	}
	
	public static int encryptor2(int thousands, int hundreds, int tens, int ones){
		int encrypted = tens * 1000 + ones * 100 + thousands * 10 + hundreds;
		return encrypted;
	}
}
