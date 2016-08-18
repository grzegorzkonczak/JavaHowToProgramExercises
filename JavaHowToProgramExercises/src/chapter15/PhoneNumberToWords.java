// Grzegorz Koñczak, 18.08.2016
// Exercise number 15.7 page 723
// Exercise from Java:How to program 10th edition

package chapter15;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneNumberToWords {

	private static final Scanner input = new Scanner(System.in);
	private static final String[][] keypads  = new String[][] {{"0", "0", "0"},
		{"1", "1", "1"},
		{"A", "B", "C"}, 
		{"D", "E", "F"}, 
		{"G", "H", "I"}, 
		{"J", "K", "L"}, 
		{"M", "N", "O"}, 
		{"P", "R", "S"}, 
		{"T", "U", "V"}, 
		{"W", "X", "Y"}};
		private static PrintWriter writer;
	
	public static void main(String[] args) {
		
		System.out.println("Input 7 digit phone number");
		int phoneNumber = input.nextInt();
		int[] digits = pullOutDigits(phoneNumber);
		try {
			writer = new PrintWriter("words.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		constructWords(digits);
		writer.close();
	}

	private static void constructWords(int[] digits) {
		for (int i = 0; i < 3; i++) {
			StringBuilder builder = new StringBuilder();
			builder.replace(0, 1, keypads[digits[0]][i]);
			for (int j = 0; j < 3; j++) {
				builder.replace(1, 2, keypads[digits[1]][j]);
				for (int j2 = 0; j2 < 3; j2++) {
					builder.replace(2, 3, keypads[digits[2]][j2]);
					for (int k = 0; k < 3; k++) {
						builder.replace(3, 4, keypads[digits[3]][k]);
						for (int k2 = 0; k2 < 3; k2++) {
							builder.replace(4, 5, keypads[digits[4]][k2]);
							for (int l = 0; l < 3; l++) {
								builder.replace(5, 6, keypads[digits[5]][l]);
								for (int l2 = 0; l2 < 3; l2++) {
									builder.replace(6, 7, keypads[digits[6]][l2]);
									writer.println(builder.toString());
								}
							}
						}
					}
				}
			}
		}
	}

	private static int[] pullOutDigits(int phoneNumber) {
		int[] digits = new int[7];
		String[] nums = Integer.toString(phoneNumber).split("");
		for (int i = 0; i < nums.length; i++) {
			digits[i] = Integer.parseInt(nums[i]);
		}
//		int[] digits = new int[7];
//		for (int i = 0; i < digits.length - 1; i++) {
//			digits [i] = phoneNumber / (int)Math.pow((int)10, (int)digits.length - (i + 1));
//			phoneNumber = phoneNumber - (digits[i] * (int)Math.pow((int)10, (int)digits.length - (i + 1)));
//		}
//		digits [06] = phoneNumber % 10;
		return digits;
	}
}
