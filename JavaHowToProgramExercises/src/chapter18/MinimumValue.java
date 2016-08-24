// Grzegorz Koñczak, 24.08.2016
// Exercise number 18.18 page 849
// Exercise from Java:How to program 10th edition

package chapter18;

public class MinimumValue {

	public static void main(String[] args) {
		int[] array = {5,6,7,20,9,10,100,17};
		int result = recursiveMinimum(array, array.length - 1);
		System.out.println(result);
	}

	private static int recursiveMinimum(int[] array, int x){
		if (x == 0){
			return array[x];
		} else {
			return Math.min(array[x], recursiveMinimum(array, x - 1));
		}
	}
}
