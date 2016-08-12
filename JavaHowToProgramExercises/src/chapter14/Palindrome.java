// Grzegorz Koñczak, 12.08.2016
// Exercise number 14.3 page 678
// Exercise from Java:How to program 10th edition

package chapter14;

public class Palindrome {

	public static void main(String[] args) {
		
		String text = "radar";
		
		StringBuilder textReverse = new StringBuilder(text);
		textReverse.reverse();
		
		String textToMatch = textReverse.toString();
		
		if (text.equals(textToMatch)){
			System.out.println("Palindrome");
		} else {
			System.out.println("Not palindrome");
		}
	}
}
