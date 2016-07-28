// Grzegorz Koñczak, 28.07.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

package chapter12.exercise12_18;


public class Screen
{
   // displays a message without a carriage return
   public void displayMessage(String message) 
   {
      System.out.print(message); 
   } // end method displayMessage

   // display a message with a carriage return
   public void displayMessageLine(String message) 
   {
      System.out.println(message);   
   } // end method displayMessageLine

   // display a dollar amount
   public void displayDollarAmount(double amount)
   {
      System.out.printf("$%,.2f", amount);   
   } // end method displayDollarAmount 
} // end class Screen
