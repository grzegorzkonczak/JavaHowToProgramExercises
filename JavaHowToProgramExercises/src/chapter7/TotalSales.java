// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.20 page 343
// Exercise from Java:How to program 10th edition

package chapter7;

import java.util.Scanner;

public class TotalSales {

	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		double[][] sales = new double[5][4];
		
		System.out.println("To enter sales data press 1, to quit press 0");
		int flag = input.nextInt();
		
		// Gathering data from user
		while(flag != 0){
			
			System.out.println("Enter Sales Pearson number:");
			int salesPerson = input.nextInt();
			System.out.println("Enter product number:");
			int product = input.nextInt();
			System.out.println("Enter total money from selling this product by this sales person:");
			double profit = input.nextDouble();
			sales[product - 1][salesPerson - 1] = profit;
			
			
			System.out.println("To enter sales data press 1, to quit press 0");
			flag = input.nextInt();
		}
		
		
		// Displaying data in tabular format and calculating average profit from product
		System.out.printf("            %15s%15s%15s%15s%15s%n", "Sales Person 1", "Sales Person 2", "Sales Person 3", "Sales Person 4", "Average");
		for(int i = 0; i < sales.length; i++){
			System.out.printf("%10s%2d", "Product", i + 1);
			double totalForProduct = 0;
			for (int j = 0; j < sales[i].length; j++){
				System.out.printf("%15.2f", sales[i][j]);
				totalForProduct += sales[i][j];
			}
			double averageForProduct = totalForProduct / 4;
			System.out.printf("%15.2f%n", averageForProduct);
		}
		
		// Calculating and displaying information about average profit by sales person
		System.out.print("   Average  ");
		for(int i = 0; i < 4; i++){
			double salePersonTotal = 0;
			for (int j = 0; j < 5; j++){
				salePersonTotal += sales[j][i]; 
			}
			double average = salePersonTotal / 5;
			System.out.printf("%15.2f", average);
		}
	}
}
