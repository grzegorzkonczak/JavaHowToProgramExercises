package chapter12.exercise12_18_second_try;

// Grzegorz Koñczak, 05.08.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

public class Deposit extends Transaction {
	private double amount; // amount to deposit
	private Keypad keypad; // reference to keypad
	private DepositSlot depositSlot; // reference to deposit slot
	private final static int CANCELED = 0; // constant for cancel option
	private int menuSelection; // User selected menu option

	// Deposit constructor
	public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad,
			DepositSlot atmDepositSlot, int menuSelection) {
		// initialize superclass variables
		super(userAccountNumber, atmScreen, atmBankDatabase);

		// initialize references to keypad and deposit slot
		keypad = atmKeypad;
		depositSlot = atmDepositSlot;

		this.menuSelection = menuSelection;
	} // end Deposit constructor

	// perform transaction
	@Override
	public void execute() {
		BankDatabase bankDatabase = getBankDatabase(); // get reference
		Screen screen = getScreen(); // get reference

		if (menuSelection == -1) {
			promptForDepositAmount();
		} else {
			amount = menuSelection / 100; // get deposit amount from user

			// check whether user entered a deposit amount or canceled
			if (amount != CANCELED) {
				// request deposit envelope containing specified amount
				screen.displayMessage("\nPlease insert a deposit envelope containing ");
				screen.appendDollarAmount(amount);
				screen.appendMessageLine(".");

				// receive deposit envelope
				boolean envelopeReceived = depositSlot.isEnvelopeReceived();

				// check whether deposit envelope was received
				if (envelopeReceived) {
					screen.appendMessageLine(
							"\nYour envelope has been " + "received.\nNOTE: The money just deposited will not "
									+ "be available until we verify the amount of any "
									+ "enclosed cash and your checks clear.");

					// credit account to reflect the deposit
					bankDatabase.credit(getAccountNumber(), amount);
				} // end if
				else // deposit envelope not received
				{
					screen.appendMessageLine(
							"\nYou did not insert an " + "envelope, so the ATM has canceled your transaction.");
				} // end else
			} // end if
			else // user canceled instead of entering amount
			{
				screen.displayMessageLine("\nCanceling transaction...");
			} // end else
		}
	} // end method execute

	// prompt user to enter a deposit amount in cents
	private void promptForDepositAmount() {
		Screen screen = getScreen(); // get reference to screen

		// display the prompt
		screen.displayMessage("\nPlease enter a deposit amount in " + "CENTS (or 0 to cancel): ");

	} // end method promptForDepositAmount
} // end class Deposit
