// Grzegorz Koñczak, 23.08.2016
// Exercise number 18.13 page 848
// Exercise from Java:How to program 10th edition

package chapter18;

public class MysteryCode4 {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String result = someMethod(array, 0);
		System.out.println(result);
	}

	private static String someMethod(int[] array2, int i) {
		if (i < array2.length){
			return String.format("%s%d ", someMethod(array2, i + 1), array2[i]);
		} else {
			return "";
		}
	}
}
