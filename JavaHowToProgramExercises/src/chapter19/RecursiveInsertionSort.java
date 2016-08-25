// Grzegorz Koñczak, 25.08.2016
// Exercise number 19.9 page 879
// Exercise from Java:How to program 10th edition

package chapter19;

import java.util.Arrays;

public class RecursiveInsertionSort {

	public static void main(String[] args) {

		int[] array = { 6, 5, 7, 3, 9999, 20, 110, 2, 30, 500, 3, 17 };
		System.out.println(Arrays.toString(array));
		new RecursiveInsertionSort().recursiveInsertionSort(array, 0);
		System.out.println(Arrays.toString(array));
	}

	private void recursiveInsertionSort(int[] array, int length) {
		if (length != array.length - 1) {
			insert(length, length + 1, array, array[length + 1]);
			System.out.println(Arrays.toString(array));
			recursiveInsertionSort(array, length + 1);
		}
	}

	private void insert(int first, int second, int[] array, int temp) {
		if (second != array.length && first >= 0) {
			if (array[first] > temp) {
				array[second] = array[first];
				array[first] = temp;				
			}
			insert(first - 1, second - 1, array, temp);
		}
	}

}
