// Grzegorz Koñczak, 29.06.2016
// Exercise number 4.22 page 190
// Exercise from Java:How to program 10th edition

package chapter4;

public class TabularOutput {

	public static void main(String[] args) {

		int counter = 1;

		System.out.printf("N     N2    N3    N4%n%n");
		while (counter <= 5) {
			if (counter < 3) {
				System.out.printf("%d     %d     %d     %d%n", counter, counter * counter, counter * counter * counter,
						counter * counter * counter * counter);
				counter++;
			}
			if (counter == 3) {
				System.out.printf("%d     %d     %d    %d%n", counter, counter * counter, counter * counter * counter,
						counter * counter * counter * counter);
				counter++;
			}
			if (counter == 4) {
				System.out.printf("%d     %d    %d    %d%n", counter, counter * counter, counter * counter * counter,
						counter * counter * counter * counter);
				counter++;
			}
			if (counter == 5) {
				System.out.printf("%d     %d    %d   %d%n", counter, counter * counter, counter * counter * counter,
						counter * counter * counter * counter);
				counter++;
			}
		}
	}

}
