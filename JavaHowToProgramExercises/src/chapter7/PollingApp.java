// Grzegorz Koñczak, 13.07.2016
// Exercise number 7.40 page 356
// Exercise from Java:How to program 10th edition

package chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class PollingApp {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String[] topics = { "Important topic 1", "Important topic 2", "Important topic 3", "Important topic 4",
				"Important topic 5" };

		System.out.println("Do you want to take survey? (1 - yes, 0 - no)");
		int flag = input.nextInt();
		ArrayList<Integer[][]> respondents = new ArrayList<>();

		while (flag != 0) {

			// Polling one user and storing his responses in array and ArrayList
			Integer[][] responses = new Integer[topics.length][10];

			// Initializing Integer array to zeros
			for (int i = 0; i < topics.length; i++) {
				for (int j = 0; j < 10; j++) {
					responses[i][j] = 0;
				}
			}

			for (int i = 0; i < topics.length; i++) {
				System.out.println("How do you rate " + topics[i] + "?");
				int rate = input.nextInt();
				responses[i][rate - 1]++;
			}
			respondents.add(responses);

			System.out.println("Do you want to take survey? (1 - yes, 0 - no)");
			flag = input.nextInt();
		}

		// Summing all responses from all respondents and calculating issue
		// average
		int[] totalIssueAverage = new int[5];
		int[][] cumulatedResponses = new int[5][10];
		for (Integer[][] respondent : respondents)
			for (int i = 0; i < topics.length; i++) {
				for (int j = 0; j < 10; j++) {
					if (respondent[i][j] != 0) {
						cumulatedResponses[i][j]++;
						totalIssueAverage[i] += j + 1;
					}
				}
			}

		// Calculating maximum and minimum points for topics
		int max = totalIssueAverage[0];
		int min = totalIssueAverage[0];
		int maxIssue = 0;
		int minIssue = 0;
		for (int i = 1; i < topics.length; i++) {
			if (totalIssueAverage[i] > max) {
				max = totalIssueAverage[i];
				maxIssue = i;
			}
			if (totalIssueAverage[i] < min) {
				min = totalIssueAverage[i];
				minIssue = i;
			}
		}

		// Displaying results of poll from all respondents
		System.out.printf("%20s%3s%3s%3s%3s%3s%3s%3s%3s%3s%3s%9s%n", "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "Average");
		for (int i = 0; i < topics.length; i++) {
			System.out.printf("%-20s", topics[i]);
			for (int j = 0; j < 10; j++) {
				System.out.printf("%3d", cumulatedResponses[i][j]);
			}
			System.out.printf("%9.1f", (double) totalIssueAverage[i] / respondents.size());
			System.out.println();
		}
		System.out.println("Topic with maximum points was: " + topics[maxIssue] + " with " + max + " points");
		System.out.println("Topic with minimum points was: " + topics[minIssue] + " with " + min + " points");
	}
}
