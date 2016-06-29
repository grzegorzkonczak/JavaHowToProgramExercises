// Grzegorz Koñczak, 29.06.2016
// Exercise number 4.24 page 190
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner; // class uses class Scanner

public class Analysis {
	public static void main(String[] args) {
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		// initializing variables in declarations
		int passes = 0;
		int failures = 0;
		int studentCounter = 1;
		int result; // one exam result (obtained from user)
		int validateFlag = 0;

		// process 10 students using counter-controlled loop
		while (studentCounter <= 10) {
			validateFlag = 0;
			// prompt user for input and obtain value from user and validates
			// input
			while (validateFlag == 0) {
				System.out.print("Enter result (1 = pass, 2 = fail): ");
				result = input.nextInt();
				if(result == 1)
					validateFlag = 1;
				if(result == 2)
					validateFlag = 1;
				
				// if...else is nested in the while statement
				if (result == 1)
					passes = passes + 1;
				else if (result == 2)
					failures = failures + 1;
			}


			// increment studentCounter so loop eventually terminates
			studentCounter = studentCounter + 1;
		}

		// termination phase; prepare and display results
		System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);

		// determine whether more than 8 students passed
		if (passes > 8)
			System.out.println("Bonus to instructor!");

		input.close();
	}
} // end class Analysis