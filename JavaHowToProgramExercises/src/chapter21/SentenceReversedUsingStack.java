// Grzegorz Koñczak, 28.08.2016
// Exercise number 21.10 page 946
// Exercise from Java:How to program 10th edition

package chapter21;

import java.util.Scanner;

import com.deitel.datastructures.Stack;

public class SentenceReversedUsingStack {

	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Stack<String> sentenceStack = new Stack<>();
		System.out.println("Input sentence:");
		String sentence = input.nextLine();
		
		String[] words = sentence.split("\\s+");
		for (String string : words) {
			sentenceStack.push(string);
		}
		for (String string : words) {
			System.out.print(sentenceStack.pop() + " ");
		}
	}
}
