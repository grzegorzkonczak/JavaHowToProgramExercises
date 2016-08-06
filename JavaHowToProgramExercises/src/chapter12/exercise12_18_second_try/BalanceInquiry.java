package chapter12.exercise12_18_second_try;

// Grzegorz Koñczak, 05.08.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

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
      screen.appendMessage(" - Available balance: "); 
      screen.appendDollarAmount(availableBalance);
      screen.appendMessage("\n - Total balance:     ");
      screen.appendDollarAmount(totalBalance);
      screen.appendMessageLine("");
   } // end method execute
} // end class BalanceInquiry
