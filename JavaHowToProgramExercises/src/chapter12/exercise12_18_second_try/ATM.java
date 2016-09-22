package chapter12.exercise12_18_second_try;

import javax.swing.JFrame;

// Grzegorz Koñczak, 05.08.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

@SuppressWarnings("serial")
public class ATM extends JFrame {
	// Enum for keeping track on what stage of program the user currently is
	public static enum UserStage {
		START, ACCOUNT_VERYFICATION, PIN_VERYFICATION, MAIN_MENU, WITHDRAWAL_MENU, WITHDRAWAL_AMOUNT_MENU, DEPOSIT_MENU, DEPOSIT_AMOUNT_MENU
	}

	private int currentAccountNumber; // current user's account number
	private Screen screen; // ATM's screen
	private Keypad keypad; // ATM's keypad
	private CashDispenser cashDispenser; // ATM's cash dispenser
	private DepositSlot depositSlot; // ATM's deposit slot
	private BankDatabase bankDatabase; // account information database
	private int userInput;
	private ATMGUI atmGui;
	private UserStage currentStage;
	private int menuSelection;
	private int subMenuSelection = -1;

	// constants corresponding to main menu options
	private static final int BALANCE_INQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;

	// no-argument ATM constructor initializes instance variables
	public ATM() {
		currentAccountNumber = 0; // no current account number to start
		screen = new Screen(); // create screen
		keypad = new Keypad(this); // create keypad
		cashDispenser = new CashDispenser(); // create cash dispenser
		depositSlot = new DepositSlot(); // create deposit slot
		bankDatabase = new BankDatabase(); // create acct info database
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 500);
		atmGui = new ATMGUI(this);
		this.add(atmGui);
		currentStage = UserStage.START;
		takeAction();
	} // end no-argument ATM constructor

	// ATM takes action
	// Main logic component of ATM
	public void takeAction() {
		// Welcome message to user - proceeds to Authentication step
		if (currentStage == UserStage.START) {
			screen.appendMessageLine("Welcome!\nPlease enter your account number: ");
			currentStage = UserStage.ACCOUNT_VERYFICATION;
			
		} else if (currentStage == UserStage.WITHDRAWAL_AMOUNT_MENU){
			subMenuSelection = userInput;
			performTransactions();
			userInput = -1; // reset user input
			currentStage = UserStage.MAIN_MENU;
			subMenuSelection = -1; // reset sub menu selection 
			takeAction();
		
		} else if (currentStage == UserStage.DEPOSIT_AMOUNT_MENU){
			subMenuSelection = userInput;
			performTransactions();
			userInput = -1; // reset user input
			currentStage = UserStage.MAIN_MENU;
			subMenuSelection = -1; // reset sub menu selection 
			takeAction();
			
		// Saves user provided account number and asks for user PIN number
		// If  proceeds to main menu, else asks to try again and proceeds to start 
		} else if (currentStage == UserStage.ACCOUNT_VERYFICATION) {
			currentAccountNumber = userInput;
			screen.appendMessageLine("\nEnter your PIN: "); // prompt for PIN
			currentStage = UserStage.PIN_VERYFICATION;
			
			
		} else if (currentStage == UserStage.PIN_VERYFICATION) {
			authenticateUser(currentAccountNumber, userInput);
			
			
		// Processes individual main menu options selected by user
		} else if (currentStage == UserStage.MAIN_MENU && userInput == 1) {
			menuSelection = userInput;
			performTransactions();
			takeAction(); // take action to redisplay main menu
			
			
		} else if (currentStage == UserStage.MAIN_MENU && userInput == 2) {
			menuSelection = userInput;
			performTransactions();
			currentStage = UserStage.WITHDRAWAL_AMOUNT_MENU;
			
			
		} else if (currentStage == UserStage.MAIN_MENU && userInput == 3) {
			menuSelection = userInput;
			performTransactions();
			currentStage = UserStage.DEPOSIT_AMOUNT_MENU;

		} else if (currentStage == UserStage.MAIN_MENU && userInput == 4) {
			screen.displayMessageLine("Goodbye!");
			currentAccountNumber = 0;
			currentStage = UserStage.START;
			takeAction();
			
			
		// Displays main menu on screen
		} else if (currentStage == UserStage.MAIN_MENU) {
			if (userInput != -1)
				displayMainMenu("display");
			else
				displayMainMenu("append");
		}

	} // end method run

	public void buildGUI() {
		ATM atmFrame = new ATM();
		atmFrame.setVisible(true);
	}

	// attempts to authenticate user against database
	private void authenticateUser(int account, int pin) {

		// set userAuthenticated to boolean value returned by database
		boolean userAuthenticated = bankDatabase.authenticateUser(account, pin);

		// check whether authentication succeeded
		if (userAuthenticated) {
			currentStage = UserStage.MAIN_MENU;
			takeAction();
		} // end if
		else {
			screen.displayMessageLine("Invalid account number or PIN. Please try again.");
			currentAccountNumber = 0;
			currentStage = UserStage.START;
			takeAction();
		}

	} // end method authenticateUser

	// display the main menu and perform transactions
	private void performTransactions() {
		// local variable to store transaction currently being processed
		Transaction currentTransaction = null;

		// show main menu and get user selection
		int mainMenuSelection = menuSelection;

		// decide how to proceed based on user's menu selection
		switch (mainMenuSelection) {
		// user chose to perform one of three transaction types
		case BALANCE_INQUIRY:
		case WITHDRAWAL:
		case DEPOSIT:

			// initialize as new object of chosen type
			currentTransaction = createTransaction(mainMenuSelection, subMenuSelection);

			currentTransaction.execute(); // execute transaction

			userInput = -1;

			break;
		default: // user did not enter an integer from 1-4
			screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
			currentStage = UserStage.MAIN_MENU;
			takeAction();
			break;
		} // end while
	} // end method performTransactions

	// display the main menu and return an input selection
	private void displayMainMenu(String option) {
		if (option.equals("display"))
			screen.displayMessageLine("\nMain menu:");
		else
			screen.appendMessageLine("\nMain menu:");
		screen.appendMessageLine("1 - View my balance");
		screen.appendMessageLine("2 - Withdraw cash");
		screen.appendMessageLine("3 - Deposit funds");
		screen.appendMessageLine("4 - Exit\n");
		screen.appendMessage("Enter a choice: ");
	} // end method displayMainMenu

	// return object of specified Transaction subclass
	private Transaction createTransaction(int type, int selection) {
		Transaction temp = null; // temporary Transaction variable

		// determine which type of Transaction to create
		switch (type) {
		case BALANCE_INQUIRY: // create new BalanceInquiry transaction
			temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
			break;
		case WITHDRAWAL: // create new Withdrawal transaction
			temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, cashDispenser, selection);
			break;
		case DEPOSIT: // create new Deposit transaction
			temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot, selection);
			break;
		} // end switch

		return temp; // return the newly created object
	} // end method createTransaction

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}

	public Keypad getKeypad() {
		return keypad;
	}
} // end class ATM
