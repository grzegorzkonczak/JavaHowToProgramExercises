// Grzegorz Koñczak, 25.08.2016
// Exercise number 19.7 page 878
// Exercise from Java:How to program 10th edition

package chapter19;

import java.util.Arrays;

public class BucketSort {

	public static void main(String[] args) {
		int[] array = { 6, 5, 7, 3, 9999, 20, 110, 2, 30, 500, 3, 17 };
		System.out.println("Unsorted array: " + Arrays.toString(array));
		new BucketSort().sort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));
	}

	// sort array using bucket sort algorithm
	private void sort(int[] unsorted) {
		// Create buckets for sorting
		int[][] buckets = new int[10][unsorted.length];
		// Check how many digits is in largest number to determine how many
		// passes will be needed
		int maxNumberOfDigits = findMax(unsorted);

		// Start sorting
		for (int i = 0; i < maxNumberOfDigits; i++) {
			// Extract digits for this pass of algorithm
			// (first ones, next tens, hundreds and so on...
			int[] tempArrayOfDigitsFromThisPass = extractDigits(i, unsorted);

			// Assisting array for storing numbers in appropriate place in given
			// bucket
			int[] spotTaken = new int[buckets.length];

			// Output information about extracted digits
			System.out.println(
					"Digits extracted in pass " + (i + 1) + ": " + Arrays.toString(tempArrayOfDigitsFromThisPass));

			// Start sorting number to buckets
			for (int j = 0; j < unsorted.length; j++) {
				// Put value from original array to appropriate place
				// in buckets[][] - first [] represents bucket (from 0 to 9) and
				// corresponds
				// to extracted digit (when checking tens and number is 97 we
				// put value in bucket 9)
				// Second [] in buckets represents spots taken by values and
				// increases when we put
				// value in this bucket (continuing example above - next number
				// is 93, again we need
				// bucket 9 and next spot in it because the first is taken by
				// number 97)
				buckets[tempArrayOfDigitsFromThisPass[j]][spotTaken[tempArrayOfDigitsFromThisPass[j]]++] = unsorted[j];
			}

			int counter = 0;

			// Store values from buckets back to original array by traversing
			// buckets from
			// 0 bucket to 9 bucket. Clear buckets on the way for next use.
			for (int j2 = 0; j2 < buckets.length; j2++) {
				for (int k = 0; k < buckets[0].length; k++) {
					// Store only good values back (positive integers above 0)
					if (buckets[j2][k] > 0) {
						unsorted[counter++] = buckets[j2][k];
						System.out.printf("%-4d ", buckets[j2][k]);
						// Clearing bucket
						buckets[j2][k] = 0;
					} else {
						System.out.printf("%-4s ", "--");
					}
				}
				System.out.println();
			}
			System.out.println("Sorting progress after pass " + (i + 1) + ": " + Arrays.toString(unsorted));
			System.out.println();
		}
	}

	// Return maximum number of digits in one number that array needs to sort
	private int findMax(int[] unsorted) {
		Integer biggestNumber = unsorted[0];
		for (int i = 1; i < unsorted.length; i++) {
			if (biggestNumber < unsorted[i]) {
				biggestNumber = unsorted[i];
			}
		}
		String temp = biggestNumber.toString();
		char[] tempC = temp.toCharArray();
		return tempC.length;
	}

	// Extracts the digit important for given pass of algorithm
	private int[] extractDigits(int pass, int[] unsorted) {
		int[] digits = new int[unsorted.length];
		for (int j = 0; j < digits.length; j++) {
			Integer temp = unsorted[j];
			String tempS = temp.toString();
			char[] tempC = tempS.toCharArray();
			if (pass < tempC.length) { // check if there is digit to extract
				// Extract appropriate number from char array given which pass
				// is in progress
				String s = Character.toString(tempC[tempC.length - 1 - pass]);
				digits[j] = Integer.parseInt(s);
			} else { // if no digit to extract assign 0
				digits[j] = 0;
			}
		}
		return digits;
	}
}
