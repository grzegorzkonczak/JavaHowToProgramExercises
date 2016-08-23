// Grzegorz Koñczak, 23.08.2016
// Exercise number 18.8 page 847
// Exercise from Java:How to program 10th edition

package chapter18;

public class MysteryCode2 {
	public static void main(String[] args) {
		printInt(19000);
	}

	private static void printInt(int i) {
		if(i != 0){
			printInt(i - 1);
			System.out.println( i);
		}
	}
}
