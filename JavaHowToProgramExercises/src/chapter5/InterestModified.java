// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.18 page 239
// Exercise from Java:How to program 10th edition

package chapter5;

public class InterestModified {

	public static void main(String args[])
	   {
	      int principal = 100000; // initial amount before interest
	      int amount = principal; // amount on deposit at end of each year
	      int rate = 105; // interest rate
	      int dollars = 0;
	      int cents = 0;

	      // display headers
	      System.out.printf("%s%20s%n", "Year", "Amount on deposit");

	      // calculate amount on deposit for each of ten years
	      for (int year = 1; year <= 10; year++) 
	      {
	         // calculate new amount for specified year
	         amount = amount / 100 * rate;
	         dollars = amount / 100;
	         cents = amount % 100;
	         // display the year and the amount
	         System.out.printf("%4d%16d,%d%n", year, dollars, cents);
	      } 
	   }
}
