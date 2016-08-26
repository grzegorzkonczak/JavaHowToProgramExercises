// Grzegorz Koñczak, 26.08.2016
// Exercise number 20.4 page 909
// Exercise from Java:How to program 10th edition

package chapter20;

import java.util.Arrays;

public class GenericReverseArray {

	public static void main(String[] args) {
		String[] stringArray = {"One", "Two", "Tree", "Four", "Five"};
		Integer[] integerArray = {1, 2, 3, 4};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
		
		System.out.println(Arrays.toString(stringArray));
		System.out.println(Arrays.toString(integerArray));
		System.out.println(Arrays.toString(doubleArray));
		
		reverseArray(stringArray);
		reverseArray(integerArray);
		reverseArray(doubleArray);
		
		System.out.println(Arrays.toString(stringArray));
		System.out.println(Arrays.toString(integerArray));
		System.out.println(Arrays.toString(doubleArray));
	}
	
	private static <T> void reverseArray (T[] array){
		for (int i = 0; i < array.length / 2; i++) {
			T temp = array[0+i];
			array[0+i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
	}
}
