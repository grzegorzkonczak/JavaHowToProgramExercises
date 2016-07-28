// Grzegorz Koñczak, 28.07.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

package chapter12.exercise12_18;

import javax.swing.JFrame;

public class ATM extends JFrame {

	public static enum UserStage {
		ACCOUNT_VERYFICATION, PIN_VERYFICATION, MAIN_MENU, WITHDRAWAL_MENU, WITHDRAWAL_AMOUNT_MENU, DEPOSIT_MENU, DEPOSIT_AMOUNT_MENU
	}

	private boolean accountAuthenticated; // whether user is authenticated
	private boolean pinAuthenticated;
	private int currentAccountNumber; // current user's account number
	private Screen screen; // ATM's screen
	private Keypad keypad; // ATM's keypad
	private CashDispenser cashDispenser; // ATM's cash dispenser
	private DepositSlot depositSlot; // ATM's deposit slot
	private BankDatabase bankDatabase; // account information database
	private UserStage currentStage;
	private StringBuilder input;
	private ATMGUI atmGui;

	// constants corresponding to main menu options
	private static final int BALANCE_INQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;

	// no-argument ATM constructor initializes instance variables
	public ATM() {
		accountAuthenticated = false; // user is not authenticated to start
		pinAuthenticated = false;
		currentAccountNumber = 0; // no current account number to start
		screen = new Screen(); // create screen
		keypad = new Keypad(this); // create keypad
		cashDispenser = new CashDispenser(); // create cash dispenser
		depositSlot = new DepositSlot(); // create deposit slot
		bankDatabase = new BankDatabase(); // create acct info database
		currentStage = UserStage.ACCOUNT_VERYFICATION;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 500);
		atmGui = new ATMGUI(this);
		this.add(atmGui);
	} // end no-argument ATM constructor

	// start ATM
	public void run() {
		buildGUI();
		screen.displayMessageLine("Welcome!\nPlease enter your account number: ");
	} // end method run

	private void buildGUI() {
		ATM atmFrame = new ATM();
		atmFrame.setVisible(true);
	}

	// attempts to authenticate user against database
	public void authenticateAccount(int accountNumber) {
		// set userAuthenticated to boolean value returned by database
		accountAuthenticated = bankDatabase.authenticateAccount(accountNumber);

		// check whether authentication succeeded
		if (accountAuthenticated) {
			currentAccountNumber = accountNumber; // save user's account #
			currentStage = UserStage.PIN_VERYFICATION;
			screen.displayMessageLine("Enter your PIN: ");
		} // end if
		else
			screen.displayMessageLine("Invalid account number. Please try again.");
	} // end method authenticateAccount

	public void authenticatePin(int pinNumber) {
		// set userAuthenticated to boolean value returned by database
		pinAuthenticated = bankDatabase.authenticatePin(pinNumber, currentAccountNumber);

		// check whether authentication succeeded
		if (pinAuthenticated) {
			currentStage = UserStage.MAIN_MENU;
			displayMainMenu();
		} // end if
		else
			screen.displayMessageLine("Invalid pin number. Please try again.");
	} // end method authenticateAccount

	// display the main menu and perform transactions
	public void performTransactions(int mainMenuSelection) {
		// local variable to store transaction currently being processed
		Transaction currentTransaction = null;

		// decide how to proceed based on user's menu selection
		switch (mainMenuSelection) {
		// user chose to perform one of three transaction types
		case BALANCE_INQUIRY:
		case WITHDRAWAL:
		case DEPOSIT:

			// initialize as new object of chosen type
			currentTransaction = createTransaction(mainMenuSelection);

			currentTransaction.execute(); // execute transaction
			break;
		}

	} // end method performTransactions

	// display the main menu and return an input selection
	public void displayMainMenu() {
		screen.appendMessageLine("\nMain menu:");
		screen.appendMessage("\n1 - View my balance");
		screen.appendMessage("\n2 - Withdraw cash");
		screen.appendMessage("\n3 - Deposit funds");
		screen.appendMessage("\n4 - Exit\n");
		screen.appendMessage("\nEnter a choice: ");
	} // end method displayMainMenu

	// return object of specified Transaction subclass
	private Transaction createTransaction(int type) {
		Transaction temp = null; // temporary Transaction variable

		// determine which type of Transaction to create
		switch (type) {
		case BALANCE_INQUIRY: // create new BalanceInquiry transaction
			temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
			break;
		case WITHDRAWAL: // create new Withdrawal transaction
			temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
			break;
		case DEPOSIT: // create new Deposit transaction
			temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
			break;
		} // end switch

		return temp; // return the newly created object
	} // end method createTransaction

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Keypad getKeypad() {
		return keypad;
	}

	public void setKeypad(Keypad keypad) {
		this.keypad = keypad;
	}

	public UserStage getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(UserStage currentStage) {
		this.currentStage = currentStage;
	}

	public StringBuilder getInput() {
		return input;
	}

	public void setInput(StringBuilder input) {
		this.input = input;
	}
} // end class ATM
