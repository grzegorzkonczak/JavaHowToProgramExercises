// Grzegorz Koñczak, 06.07.2016
// Exercise number 6.34 page 283
// Exercise from Java:How to program 10th edition

package chapter6;

public class TableDeBiHex {

	public static void main(String[] args) {
		
		System.out.printf("%11s%11s%11s%14s%n", "Decimal", "Binary", "Octal", "Hexadecimal"); // header of table
		
		for(int i = 1; i <= 256; i++){
			System.out.printf("%11d%11s%11s%14s%n", i, Integer.toBinaryString(i), Integer.toOctalString(i), Integer.toHexString(i));
		}
	}
}
