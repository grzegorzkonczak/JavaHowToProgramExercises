// Grzegorz Koñczak, 26.08.2016
// Exercise number 20.5/6 page 909/910
// Exercise from Java:How to program 10th edition

package chapter20;

public class EnchancedPrintArray {

	public static void main(String[] args) {
		// create arrays of Integer, Double and Character
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };
		String[] stringArray = {"One", "Two", "Three", "Four", "Five", "Six", 
				"Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve"};

		System.out.print("Array integerArray contains:\n");
		printArray(integerArray); // pass an Integer array
		System.out.printf("%nArray doubleArray contains:%n");
		printArray(doubleArray); // pass a Double array
		System.out.printf("%nArray characterArray contains:%n");
		printArray(characterArray); // pass a Character array

		try {
			System.out.print("\nArray integerArray with subscript (proper) contains:\n");
			printArray(integerArray, 1, 3); // pass an Integer array
			System.out.printf("%nArray doubleArray with subscript (proper) contains:%n");
			printArray(doubleArray, 1, 3); // pass a Double array
			System.out.printf("%nArray characterArray with subscript (proper) contains:%n");
			printArray(characterArray, 1, 3); // pass a Character array
		} catch (InvalidSubscriptException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.print("\nArray integerArray with subscript (out of bounds) contains:\n");
		try {
			printArray(integerArray, -1, 3);
		} catch (InvalidSubscriptException e) {
			e.printStackTrace();
		} // pass an Integer array
		
		System.out.printf("\nArray doubleArray with subscript (out of bounds) contains:%n");
		try {
			printArray(doubleArray, 1, 10);
		} catch (InvalidSubscriptException e) {
			e.printStackTrace();
		} // pass a Double array
		
		System.out.printf("\nArray characterArray with subscript (out of bounds) contains:%n");
		try {
			printArray(characterArray, -2, 10);
		} catch (InvalidSubscriptException e) {
			e.printStackTrace();
		} // pass a Character array
		
		System.out.print("Array stringArray contains:\n");
		printArray(stringArray); // pass String array
	}

	// generic method printArray
	public static <T> void printArray(T[] inputArray) {
		// display array elements
		for (T element : inputArray)
			System.out.printf("%s ", element);

		System.out.println();
	}

	public static <T> void printArray(T[] inputArray, int lowSubscript, int highSubscript)
			throws InvalidSubscriptException {
		if (lowSubscript < 0 || highSubscript > inputArray.length - 1) {
			throw new InvalidSubscriptException();
		}

		// display array elements
		for (int i = lowSubscript; i < highSubscript; i++) {
			System.out.printf("%s ", inputArray[i]);
		}

		System.out.println();
	}
	
	public static void printArray(String[] inputArray){
		for (int i = 1; i < inputArray.length + 1; i++) {
			System.out.printf("%-7s ", inputArray[i - 1]);
			if (i % 4 == 0){
				System.out.println();
			}
		}
	}
}
