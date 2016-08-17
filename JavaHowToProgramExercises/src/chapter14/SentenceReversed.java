// Grzegorz Koñczak, 17.08.2016
// Exercise number 14.9 page 679
// Exercise from Java:How to program 10th edition

package chapter14;

import java.util.Scanner;

public class SentenceReversed {

	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Input sentence and confirm with enter");
		String originalSentence = input.nextLine();
		String[] tokenizedSentence = originalSentence.split("\\s");
		
		for (int i = tokenizedSentence.length - 1; i >= 0; i--) {
			System.out.print(tokenizedSentence[i] + " ");
		}
	}
}
