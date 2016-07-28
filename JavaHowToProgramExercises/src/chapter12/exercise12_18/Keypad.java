// Grzegorz Koñczak, 28.07.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

package chapter12.exercise12_18;


import java.util.Scanner; // program uses Scanner to obtain user input

public class Keypad
{
   private Scanner input; // reads data from the command line
                         
   // no-argument constructor initializes the Scanner
   public Keypad()
   {
      input = new Scanner(System.in);    
   } // end no-argument Keypad constructor

   // return an integer value entered by user 
   public int getInput()
   {
      return input.nextInt(); // we assume that user enters an integer  
   } // end method getInput
} // end class Keypad  
