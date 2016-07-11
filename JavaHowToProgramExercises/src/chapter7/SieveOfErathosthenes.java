// Grzegorz Koñczak, 11.07.2016
// Exercise number 7.27 page 348
// Exercise from Java:How to program 10th edition

package chapter7;

public class SieveOfErathosthenes {

	public static void main(String[] args) {
		boolean[] numbers = new boolean[1000];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = true;
		}

		for (int i = 2; i < numbers.length; i++) {
			if (numbers[i]) {
				for (int j = i + 1; j < numbers.length; j++) {
					if (j != i && j % i == 0){
						numbers[j] = false;
					}
				}
			}
		}
		
		for (int i = 2; i < numbers.length; i++){
			if (numbers[i]){
				System.out.println(i);
			}
		}
	}
}
