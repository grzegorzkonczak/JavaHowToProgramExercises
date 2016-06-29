// Grzegorz Koñczak, 29.06.2016
// Exercise number 4.20 page 189
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class TaxCalculator {

	public static void main(String[] args) {
		
		// initializing base variables
		Scanner input = new Scanner(System.in);
		double lowerTax = 0.15;
		double higherTax = 0.20;
		int taxLimit = 30000;
		int counter = 1;
		
		while(counter <= 3){
			// prompting user for data about citizens
			System.out.print("Enter Citizen name: ");
			String citizenName = input.nextLine();
			System.out.print("Enter Citizen earnings: ");
			double citizenEarnings = input.nextDouble();
			input.nextLine();
			
			// calculating tax of citizen
			if(citizenEarnings >= taxLimit){
				double taxAmount = ((citizenEarnings - taxLimit) * higherTax) + (taxLimit * lowerTax);
				// displaying tax for citizen
				System.out.printf("Tax for %s is %.2f%n", citizenName, taxAmount);
			}else{
				double taxAmount = citizenEarnings * lowerTax;
				// displaying tax for citizen
				System.out.printf("Tax for %s is %.2f%n", citizenName, taxAmount);
			}
			counter++;
		}
		
		input.close();
	}

}
