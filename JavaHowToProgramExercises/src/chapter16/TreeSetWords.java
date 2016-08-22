// Grzegorz Koñczak, 22.08.2016
// Exercise number 16.20 page 770
// Exercise from Java:How to program 10th edition

package chapter16;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetWords {

	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Input text:");
		String text = input.nextLine();
		String[] words = text.split(" ");
		
		Set<String> sortedWords = new TreeSet<>();
		for (String string : words) {
			sortedWords.add(string);
		}
		
		for (String string : sortedWords) {
			System.out.println(string);
		}
	}
}
