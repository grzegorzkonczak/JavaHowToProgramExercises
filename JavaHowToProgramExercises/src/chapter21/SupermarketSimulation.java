// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.15 page 948
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;

import com.deitel.datastructures.Queue;

public class SupermarketSimulation {

	private static final SecureRandom randomNumbers = new SecureRandom();
	private final static int ARRIVAL_TIME = 2;
	private final static int SERVICE_TIME = 2;

	public static void main(String[] args) {

		Queue<Integer> line = new Queue<>();
		int firstArrival = 1 + randomNumbers.nextInt(ARRIVAL_TIME);
		int nextArrival = -1;
		int serviceTime = -1;
		int customerCount = 1;
		int serviceCount = 1;
		int longestLine = 0;
		int difference = 0;
		int largestDifference = 0;

		// Simulation of 720 minutes of supermarket line processing
		for (int i = 1; i < 721; i++) {
			// Check for longest line during service time
			if (longestLine < line.size()){
				longestLine = line.size();
			}
			// First customer arrives
			if (i == firstArrival) {
				System.out.println("First customer arrived");
				customerCount++;
				// Randomly assign service time 
				serviceTime = 1 + randomNumbers.nextInt(SERVICE_TIME);
				// Randomly assign time for next customer to arrive
				nextArrival = i + 1 + randomNumbers.nextInt(ARRIVAL_TIME);
				// Start servicing first customer 
				for (int j = 0; j < serviceTime; j++) {
					// For every minute of service increment overall time
					i++;
					// When next customer arrives
					if (i == nextArrival) {
						System.out.println("Customer " + customerCount + " arrives");
						customerCount++;
						// Add customer to line
						line.enqueue(i);
						// schedule arrival of next customer
						nextArrival = i + 1 + randomNumbers.nextInt(ARRIVAL_TIME);
					}
				}
				// When servicing of first customer is completed
				System.out.println("Service completed for " + serviceCount + " customer");
				serviceCount++;
				// Check if there are any customers in line
				if (!line.isEmpty()) {
					// If there are customer in line dequeue him and assign time to process him
					// Start next loop iteration
					difference = i - line.dequeue();
					if (largestDifference < difference){
						largestDifference = difference;
					}
					serviceTime = 1 + randomNumbers.nextInt(SERVICE_TIME);
				} else {
					// If no customers in line go time when next client arrives
					// schedule service time for that customer
					// and schedule arrival time of next customer
					// Start next loop iteration
					i = nextArrival;
					System.out.println("Customer " + customerCount + " arrives");
					customerCount++;
					serviceTime = 1 + randomNumbers.nextInt(SERVICE_TIME);
					nextArrival = i + 1 + randomNumbers.nextInt(ARRIVAL_TIME);
				}
			// After first iteration of loop ended repeat process
			// without scheduling next arrival and process time in
			// advance.
			} else if (i > firstArrival){
				//System.out.println("Here");
				for (int j = 0; j < serviceTime; j++) {
					//System.out.println("for loop and i is: " + i + " and next arrival: " + nextArrival);
					if (i == nextArrival) {
						System.out.println("Customer " + customerCount + " arrives");
						customerCount++;
						line.enqueue(i);
						nextArrival = i + 1 + randomNumbers.nextInt(ARRIVAL_TIME);
					}
					i++;
				}
				System.out.println("Service completed for " + serviceCount + " customer");
				serviceCount++;
				if (!line.isEmpty()) {
					difference = i - line.dequeue();
					if (largestDifference < difference){
						largestDifference = difference;
					}
					serviceTime = 1 + randomNumbers.nextInt(SERVICE_TIME);
					i--;
				} else {
					i = nextArrival;
					System.out.println("Customer " + customerCount + " arrives");
					customerCount++;
					serviceTime = 1 + randomNumbers.nextInt(SERVICE_TIME);
					nextArrival = i + 1 + randomNumbers.nextInt(ARRIVAL_TIME);
				}
			}
		}
		System.out.println("Longest line: " + longestLine);
		System.out.println("Longest wait time in minutes: " + largestDifference);
	}
}
