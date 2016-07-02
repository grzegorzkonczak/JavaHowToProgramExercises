// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.28 page 240
// Exercise from Java:How to program 10th edition

package chapter5;

public class ContinueModified {
	
	public static void main(String[] args)
	   {
	      for (int count = 1; count <= 10; count++) // loop 10 times
	      {  
	         if (count != 5)
	        	 System.out.printf("%d ", count);
	      } 

	      System.out.printf("%nNot used continue to skip printing 5%n");
	   }
}
