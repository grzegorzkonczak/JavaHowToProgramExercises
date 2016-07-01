// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.23 page 239
// Exercise from Java:How to program 10th edition

package chapter5;

public class DeMorgan {

	public static void main(String[] args) {
		int x = 6;
		int y = 4;
		int a = 3;
		int b = 3;
		int g = 4;
		int i = 13;
		int j = 2;
		
		System.out.printf("%b ==== %b%n%b ==== %b%n%b ==== %b%n%b ==== %b%n",
				!(x < 5) && !(y >= 7), !((x < 5) || (y >= 7)),
				!(a == b) || !(g != 5), !((a == b) && (g != 5)),
				!((x <= 8) && (y > 4)), !(x <= 8) || !(y > 4),
				!((i > 4) || (j <= 6)), !(i > 4) && !(j <= 6));
	}
}
