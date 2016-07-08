// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.14 page 342
// Exercise from Java:How to program 10th edition

package chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class VariableLengthArgumentList {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter integers to calculate the average. When done enter end of line.");
		ArrayList<Integer> arguments = new ArrayList<>();
		
		while(input.hasNext()){
			arguments.add(input.nextInt());
		}
		
		int[] array = new int[arguments.size()];
		for(int i = 0; i < array.length; i++){
			array[i] = arguments.get(i);
		}
		
		
		System.out.println("Average is: " + calculateAverage(array));
	}
	
	private static double calculateAverage(int... numbers){
		int total = 0;
		int average = 0;
		for(int number : numbers){
			total += number;
		}
		
		if(numbers.length != 0){
			average = total / numbers.length;
		}
		return average;
	}
}
