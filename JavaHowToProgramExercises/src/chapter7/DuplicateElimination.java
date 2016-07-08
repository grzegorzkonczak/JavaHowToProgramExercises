// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.12 page 342
// Exercise from Java:How to program 10th edition

package chapter7;

import java.util.Scanner;

public class DuplicateElimination {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int[] inputs = new int[10];
		
		// setting all elements of array to - 1
		for(int i = 0; i < inputs.length; i++){
			inputs[i] = -1;
		}
		
		// Taking input values from user
		for(int i = 0; i < inputs.length; i++){
			System.out.print("Enter integer number " + (i + 1) + ": ");
			inputs[i] = input.nextInt();
		}
		
		// Removing any duplicates by setting duplicate values to - 1
		for(int i = 0; i < inputs.length - 1; i++){
				if(inputs[i] == inputs[i + 1])
					inputs[i] = -1;
			}
		
		// Displaying array with removed duplicates
		for(int value : inputs){
			if(value != -1)
				System.out.print(value + " ");
		}
	}
}
