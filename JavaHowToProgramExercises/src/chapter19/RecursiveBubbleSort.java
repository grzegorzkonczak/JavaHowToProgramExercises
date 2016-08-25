// Grzegorz Koñczak, 25.08.2016
// Exercise number 19.8 page 879
// Exercise from Java:How to program 10th edition

package chapter19;

import java.util.Arrays;

public class RecursiveBubbleSort {

	public static void main(String[] args) {

		int[] array = { 6, 5, 7, 3, 9999, 20, 110, 2, 30, 500, 3, 17 };
		System.out.println(Arrays.toString(array));
		new RecursiveBubbleSort().recursiveBubbleSort(array, 8);
		System.out.println(Arrays.toString(array));
	}

	private void recursiveBubbleSort(int[] array, int unsortedNum) {
		if (unsortedNum != 0) {
			swap(0, 1, array);
			System.out.println(Arrays.toString(array));
			recursiveBubbleSort(array, unsortedNum - 1);
		}
	}

	// Method for swapping elements of array using temporary variable
	private void swap(int first, int second, int[] toSort) {
		if (second < toSort.length) {
			if (toSort[first] > toSort[second]) {
				int temp = toSort[first];
				toSort[first] = toSort[second];
				toSort[second] = temp;
			}
			swap(first + 1, second + 1, toSort);
		}

	}
}
