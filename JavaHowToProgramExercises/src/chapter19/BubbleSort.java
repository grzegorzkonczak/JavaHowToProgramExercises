// Grzegorz Koñczak, 24.08.2016
// Exercise number 19.5/6 page 878
// Exercise from Java:How to program 10th edition

package chapter19;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		new BubbleSort().sortIt();
	}

	private void sortIt() {

		// Shows the unsorted state of array and informs of sorting process
		System.out.println("This is how it looks unsorted:");
		System.out.println(Arrays.toString(toSort));
		System.out.println("Sorting in progress...");

		// Flag. If true there was sorting in actual pass of sorting algorithm
		notSorted = true;

		// Nested loop for checking all elements for n-1 number of times where n
		// is number of elements
		int numberOfComparisons = 0;
		int countUpTo = toSort.length - 1;
		for (int i = 0; i < toSort.length - 1; i++) {
			if (!notSorted)
				break; // Use of flag to break loop when array is sorted
			notSorted = false;
			System.out.println("Number of passes: " + (i + 1));
			for (int j = 0; j < countUpTo; j++) {
				if (toSort[j] > toSort[j + 1]) {
					swap(j);
				}
				numberOfComparisons++;
			}
			// Making sorting more efficient by reducing number of comparisons
			// in each pass by one
			countUpTo--;
			System.out.println("Number of comparisons: " + numberOfComparisons);
			numberOfComparisons = 0;
		}

		// Shows the output of sorting to the user
		System.out.println("And this is how it looks sorted:");
		System.out.println(Arrays.toString(toSort));
	}

	// Method for swapping elements of array using temporary variable
	private void swap(int current) {
		int temp = toSort[current];
		toSort[current] = toSort[current + 1];
		toSort[current + 1] = temp;
		notSorted = true; // Flag set to indicate that there was swapping
	}

	private boolean notSorted;
	private int[] toSort = { 7, 4, 30, 9, 12, 3, 15 };
}
