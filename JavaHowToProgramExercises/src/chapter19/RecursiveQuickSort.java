// Grzegorz Koñczak, 25.08.2016
// Exercise number 19.10 page 879
// Exercise from Java:How to program 10th edition

package chapter19;

import java.util.Arrays;

public class RecursiveQuickSort {

	public static void main(String[] args) {

		int[] array = { 6, 5, 7, 3, 9999, 20, 110, 2, 30, 500, 3, 17 };
		System.out.println(Arrays.toString(array));
		new RecursiveQuickSort().quickSortHelper(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	private void quickSortHelper(int[] array, int start, int end) {
		if (end - start > 0){
			int divide = swapper(array, start, end);
			quickSortHelper(array, start, divide - 1);
			quickSortHelper(array, divide, end);
		}
		
	}

	private int swapper(int[] array, int left, int right) {
		int pivot = array[left];
		while (left <= right){
			while (array[left] < pivot){
				left++;
			}
			while (array[right] > pivot){
				right--;
			}
			if (left <= right){
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				
				left++;
				right--;
			}
		}
		return left;
	}
}
