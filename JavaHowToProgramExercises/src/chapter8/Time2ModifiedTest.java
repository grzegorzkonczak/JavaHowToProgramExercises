// Grzegorz Koñczak, 14.07.2016
// Exercise number 8.5 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

public class Time2ModifiedTest 
{
   public static void main(String[] args)
   {
      Time2Modified t1 = new Time2Modified(); // 00:00:00
      Time2Modified t2 = new Time2Modified(2); // 02:00:00
      Time2Modified t3 = new Time2Modified(21, 34); // 21:34:00
      Time2Modified t4 = new Time2Modified(12, 25, 42); // 12:25:42
      Time2Modified t5 = new Time2Modified(t4); // 12:25:42

      System.out.println("Constructed with:");
      displayTime("t1: all default arguments", t1);
      displayTime("t2: hour specified; default minute and second", t2);
      displayTime("t3: hour and minute specified; default second", t3);
      displayTime("t4: hour, minute and second specified", t4);
      displayTime("t5: Time2 object t4 specified", t5);

      // attempt to initialize t6 with invalid values
      try
      {
         Time2Modified t6 = new Time2Modified(27, 74, 99); // invalid values
      } 
      catch (IllegalArgumentException e)
      {
         System.out.printf("%nException while initializing t6: %s%n",
            e.getMessage());
      } 
   } 

   // displays a Time2 object in 24-hour and 12-hour formats
   private static void displayTime(String header, Time2Modified t)
   {
      System.out.printf("%s%n   %s%n   %s%n",
         header, t.toUniversalString(), t.toString());
   } 
} // end class Time2Test