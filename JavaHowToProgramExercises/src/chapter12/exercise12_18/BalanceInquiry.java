// Grzegorz Koñczak, 28.07.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

package chapter12.exercise12_18;


public class BalanceInquiry extends Transaction
{
   // BalanceInquiry constructor
   public BalanceInquiry(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase)
   {
      super(userAccountNumber, atmScreen, atmBankDatabase);
   } // end BalanceInquiry constructor

   // performs the transaction
   @Override
   public void execute()
   {
      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();

      // get the available balance for the account involved
      double availableBalance = 
         bankDatabase.getAvailableBalance(getAccountNumber());

      // get the total balance for the account involved
      double totalBalance = 
         bankDatabase.getTotalBalance(getAccountNumber());
      
      // display the balance information on the screen
      screen.displayMessageLine("\nBalance Information:");
      screen.displayMessage(" - Available balance: "); 
      screen.displayDollarAmount(availableBalance);
      screen.displayMessage("\n - Total balance:     ");
      screen.displayDollarAmount(totalBalance);
      screen.displayMessageLine("");
   } // end method execute
} // end class BalanceInquiry
