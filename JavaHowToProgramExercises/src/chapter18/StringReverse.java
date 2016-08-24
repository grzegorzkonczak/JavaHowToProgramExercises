// Grzegorz Koñczak, 24.08.2016
// Exercise number 18.17 page 849
// Exercise from Java:How to program 10th edition

package chapter18;

public class StringReverse {

	public static void main(String[] args) {
		String test = "zajebiste";
		stringRevers(test.toCharArray(), 0);
	}

	private static void stringRevers(char[] charArray, int y) {
		if (y < charArray.length){
			stringRevers(charArray, y + 1);
			System.out.print(charArray[y]);
		}
	}
}
