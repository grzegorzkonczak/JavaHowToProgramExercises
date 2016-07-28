// Grzegorz Koñczak, 28.07.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

package chapter12.exercise12_18;



public class CashDispenser 
{
   // the default initial number of bills in the cash dispenser
   private final static int INITIAL_COUNT = 500;
   private int count; // number of $20 bills remaining
   
   // no-argument CashDispenser constructor initializes count to default
   public CashDispenser()
   {
      count = INITIAL_COUNT; // set count attribute to default
   } // end CashDispenser constructor

   // simulates dispensing of specified amount of cash
   public void dispenseCash(int amount)
   {
      int billsRequired = amount / 20; // number of $20 bills required
      count -= billsRequired; // update the count of bills
   } // end method dispenseCash

   // indicates whether cash dispenser can dispense desired amount
   public boolean isSufficientCashAvailable(int amount)
   {
      int billsRequired = amount / 20; // number of $20 bills required

      if (count >= billsRequired )
         return true; // enough bills available
      else 
         return false; // not enough bills available
   } // end method isSufficientCashAvailable
} // end class CashDispenser
