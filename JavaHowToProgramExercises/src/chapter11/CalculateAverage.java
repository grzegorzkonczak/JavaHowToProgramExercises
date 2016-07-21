// Grzegorz Koñczak, 21.07.2016
// Exercise number 11.20/21 page 514
// Exercise from Java:How to program 10th edition

package chapter11;

public class CalculateAverage {

	public static void main(String[] args) {
		int[] calculateThis = {1, 3, 4, 5, 8};
		try {
			int calculatedAverageAndDivide = average(calculateThis);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Error handled in main...");
		}
		System.out.println("Still running ;)");
	}
	
	private static int average (int[] toCalculate){
		int total = 0;
		
		try {
			for (int i = 0; i < toCalculate.length + 1; i++){
				total += toCalculate[i];
			}
			int average = total / toCalculate.length;
			return average;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Handled in method");
			int example = 4/0;
		}
		return total;
		
	}
}
