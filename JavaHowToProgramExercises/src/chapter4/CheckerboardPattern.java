// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.32 page 192
// Exercise from Java:How to program 10th edition

package chapter4;

public class CheckerboardPattern {

	public static void main(String[] args) {

		int rowCounter = 8;

		while (rowCounter >= 0) {
			int columnCounter = 8;
			if(rowCounter % 2 != 0)
				System.out.print(" ");
			while (columnCounter >= 0) {
				System.out.print("* ");
				columnCounter--;
			}
			System.out.println();
			rowCounter--;
		}
	}

}
