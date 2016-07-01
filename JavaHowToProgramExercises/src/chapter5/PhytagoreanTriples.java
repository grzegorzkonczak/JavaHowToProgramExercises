// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.21 page 239
// Exercise from Java:How to program 10th edition

package chapter5;

public class PhytagoreanTriples {

	
	public static void main(String[] args) {
		
		System.out.println("All Phytagorean triples up to 500 lenght of side:");
		for (int i = 1; i < 501; i++) {
			for (int j = 1; j < 501; j++) {
				for (int k = 1; k < 501; k++) {
					int iPow = i * i;
					int jPow = j * j;
					int kPow = k * k;
					if((iPow + jPow == kPow) || (kPow + jPow == iPow) || (iPow + kPow == jPow))
						System.out.printf("%4d%4d%4d%n", i, j, k);
				}
			}
		}
	}
}
