// Grzegorz Koñczak, 02.07.2016
// Exercise number 5.32 page 241
// Exercise from Java:How to program 10th edition

package chapter5;

import java.util.Scanner;

public class Charity {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String groupName;
		double treshold;
		double income;
		double charityPercent = 0;
		
		System.out.println("Group name:");
		groupName = input.nextLine();
		System.out.println("Treshold:");
		treshold = input.nextDouble();
		System.out.println("Income:");
		income = input.nextDouble();
		
		if (income > treshold){
			System.out.println("Charity percent:");
			charityPercent = input.nextDouble() / 100;
			double charity = income * (charityPercent);
			System.out.println("One of group " + groupName + " must pay " + charity + " of his yearly income.");
		}else{
			System.out.println("No charity.");
		}
	}
}
