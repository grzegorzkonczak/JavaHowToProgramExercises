// Grzegorz Koñczak, 24.08.2016
// Exercise number 18.16 page 849
// Exercise from Java:How to program 10th edition

package chapter18;

public class SearchArray {

	public static void main(String[] args) {
		
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int result = searchArray(array, 3, 0);
		
		System.out.println(result);
	}

	private static int searchArray(int[] array, int x, int y) {
		if (y < array.length && array[y] == x){
			return y;
		} else if (y == array.length){
			return -1;
		} else {
			return searchArray(array, x, y + 1);
		}
		
	}
}
