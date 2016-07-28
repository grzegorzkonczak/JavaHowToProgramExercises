// Grzegorz Koñczak, 28.07.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

package chapter12.exercise12_18;


public class Screen
{
   // displays a message without a carriage return
   public void displayMessage(String message) 
   {
      ATMGUI.displayMessage(message);
   } // end method displayMessage
   
   // displays a message without a carriage return
   public void appendMessage(String message) 
   {
      ATMGUI.appendMessage(message);
   } // end method displayMessage

   public void appendMessageLine(String message) 
   {
      ATMGUI.appendMessage(message);
      ATMGUI.appendMessage("\n");
   } // end method displayMessage
   
   // display a message with a carriage return
   public void displayMessageLine(String message) 
   {
	   ATMGUI.displayMessage(message);
	   ATMGUI.appendMessage("\n");
   } // end method displayMessageLine

   // display a dollar amount
   public void appendDollarAmount(double amount)
   {
	   ATMGUI.appendMessage(String.format("$%,.2f", amount));   
   } // end method displayDollarAmount 
} // end class Screen
