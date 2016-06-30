// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.38 page 193
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class Decryptor {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int coded;

		System.out.println("Enter 4 digit number to decrypt: ");
		coded = input.nextInt();

		int thousands;
		int hundreds;
		int tens;
		int ones;

		// dividing number to digits
		thousands = coded / 1000;
		coded = coded - thousands * 1000;
		hundreds = coded / 100;
		coded = coded - hundreds * 100;
		tens = coded / 10;
		ones = coded % 10;

		// decoding single digits
		thousands = decryptor1(thousands);
		hundreds = decryptor1(hundreds);
		tens = decryptor1(tens);
		ones = decryptor1(ones);

		// putting digits to their place
		int decodedNumber = decryptor2(thousands, hundreds, tens, ones);

		System.out.println("Your decoded number is: " + decodedNumber);

		input.close();
	}

	public static int decryptor1(int number) {
		if (number == 0) {
			number = 3;
		} else if (number == 1) {
			number = 4;
		} else if (number == 2) {
			number = 5;
		} else if (number == 3) {
			number = 6;
		} else if (number == 4) {
			number = 7;
		} else if (number == 5) {
			number = 8;
		} else if (number == 6) {
			number = 9;
		} else if (number == 7) {
			number = 0;
		} else if (number == 8) {
			number = 1;
		} else if (number == 9) {
			number = 2;
		}
		return number;
	}

	public static int decryptor2(int thousands, int hundreds, int tens, int ones) {
		int decrypted = tens * 1000 + ones * 100 + thousands * 10 + hundreds;
		return decrypted;
	}
}