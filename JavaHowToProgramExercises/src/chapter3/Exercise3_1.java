// Grzegorz Koñczak, 28.06.2016
// Exercise number 3.1 page 134
// Exercise from Java:How to program 10th edition

package chapter3;

import javax.swing.JOptionPane;

public class Exercise3_1 {
	
	public static void main(String[] args) {
		
		

		int number1 = Integer.parseInt(JOptionPane.showInputDialog("Enter first integer")); // first number to add
		int number2 = Integer.parseInt(JOptionPane.showInputDialog("Enter second integer"));  // second number to add
		int sum; // sum of number1 and number2

		sum = number1 + number2; // add numbers, then store total in sum
		
		// Create a string message
		String summed = String.format("The result of addition is %d", sum);

		JOptionPane.showMessageDialog(null, summed); // display sum
	} // end method main
}
