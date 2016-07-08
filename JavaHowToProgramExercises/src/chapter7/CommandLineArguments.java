// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.15 page 342
// Exercise from Java:How to program 10th edition

package chapter7;

public class CommandLineArguments {

	public static void main(String[] args) {
		if(args.length < 3){
			System.out.println("Restart application. Provide minimum three integer arguments.");
		}else{
			int average = calculateMinMaxAverage(args);
			System.out.println("Average of minimum and maximum value is: " + average);
		}
	}

	private static int calculateMinMaxAverage(String[] args) {
		int largest = Integer.parseInt(args[0]);
		int smallest = Integer.parseInt(args[0]);
		for(String number : args){
			if(largest < Integer.parseInt(number))
				largest = Integer.parseInt(number);
			if(smallest > Integer.parseInt(number))
				smallest = Integer.parseInt(number);
		}
		int average = (smallest + largest) / 2;
		return average;
	}
}
