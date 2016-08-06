package chapter12.exercise12_18_second_try;

// Grzegorz Koñczak, 05.08.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

public class Withdrawal extends Transaction {
	private int amount; // amount to withdraw
	private CashDispenser cashDispenser; // reference to cash dispenser
	private int menuSelection; // User selected menu option

	// constant corresponding to menu option to cancel
	private final static int CANCELED = 6;

	// Withdrawal constructor
	public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase,
			CashDispenser atmCashDispenser, int menuSelection) {
		// initialize superclass variables
		super(userAccountNumber, atmScreen, atmBankDatabase);

		// initialize references to keypad and cash dispenser
		cashDispenser = atmCashDispenser;

		this.menuSelection = menuSelection;
	} // end Withdrawal constructor

	// perform transaction
	@Override
	public void execute() {
		boolean cashDispensed = false; // cash was not dispensed yet
		double availableBalance; // amount available for withdrawal

		// get references to bank database and screen
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();

		if (menuSelection == -1) {
			displayMenuOfAmounts();
		} else {

			// array of amounts to correspond to menu numbers
			int[] amounts = { 0, 20, 40, 60, 100, 200, 6 };
			amount = amounts[menuSelection];
			
			// check whether user chose a withdrawal amount or canceled
			if (amount != CANCELED) {
				// get available balance of account involved
				availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

				// check whether the user has enough money in the account
				if (amount <= availableBalance) {
					// check whether the cash dispenser has enough money
					if (cashDispenser.isSufficientCashAvailable(amount)) {
						// update the account involved to reflect the withdrawal
						bankDatabase.debit(getAccountNumber(), amount);

						cashDispenser.dispenseCash(amount); // dispense cash
						cashDispensed = true; // cash was dispensed

						// instruct user to take cash
						screen.displayMessageLine("\nYour cash has been" + " dispensed. Please take your cash now.");
					} // end if
					else // cash dispenser does not have enough cash
						screen.displayMessageLine(
								"\nInsufficient cash available in the ATM." + "\n\nPlease choose a smaller amount.");
				} // end if
				else // not enough money available in user's account
				{
					screen.displayMessageLine(
							"\nInsufficient funds in your account." + "\n\nPlease choose a smaller amount.");
				} // end else
			} // end if
			else // user chose cancel menu option
			{
				screen.displayMessageLine("\nCanceling transaction...");
				return; // return to main menu because user canceled
			} // end else
		}
	} // end method execute

	// display a menu of withdrawal amounts and the option to cancel;
	// return the chosen amount or 0 if the user chooses to cancel
	public void displayMenuOfAmounts() {
		Screen screen = getScreen(); // get screen reference

		// display the menu
		screen.displayMessageLine("\nWithdrawal Menu:");
		screen.appendMessageLine("1 - $20");
		screen.appendMessageLine("2 - $40");
		screen.appendMessageLine("3 - $60");
		screen.appendMessageLine("4 - $100");
		screen.appendMessageLine("5 - $200");
		screen.appendMessageLine("6 - Cancel transaction");
		screen.appendMessage("\nChoose a withdrawal amount: ");

	}
}// end class Withdrawal
