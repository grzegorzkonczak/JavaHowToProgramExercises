// Grzegorz Koñczak, 23.08.2016
// Exercise number 17.12 page 816
// Exercise from Java:How to program 10th edition

package chapter17;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AverageOddEven {

	private final static SecureRandom randomNumbers = new SecureRandom();

	public static void main(String[] args) {

		List<Integer> randomIntegers = randomNumbers.ints(10, 0, 1001).boxed().collect(Collectors.toList());
		int[] integersArray = new int[randomIntegers.size()];
		for (int j = 0; j < randomIntegers.size(); j++) {
			integersArray[j] = randomIntegers.get(j);
		}
		System.out.println("Number of even integers: " + randomIntegers.stream().filter(i -> i % 2 == 0).count());
		System.out.println("Number of odd integers: " + randomIntegers.stream().filter(i -> i % 2 != 0).count());
		System.out.println("Average of all integers: " + IntStream.of(integersArray).average().getAsDouble());
		System.out.println("Average of even integers: "
				+ IntStream.of(integersArray).filter(i -> i % 2 == 0).average().getAsDouble());
		System.out.println("Average of odd integers: "
				+ IntStream.of(integersArray).filter(i -> i % 2 != 0).average().getAsDouble());
	}
}
