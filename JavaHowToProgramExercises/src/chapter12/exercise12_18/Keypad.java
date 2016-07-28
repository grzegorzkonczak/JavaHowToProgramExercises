// Grzegorz Koñczak, 28.07.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

package chapter12.exercise12_18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Keypad implements ActionListener{
	
	private ATM atm;
	private StringBuilder input;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() != "Enter"){
			ATMGUI.appendMessage(e.getActionCommand());
			input.append(e.getActionCommand());
		}else if (atm.getCurrentStage() == ATM.UserStage.ACCOUNT_VERYFICATION){
			String inputString = input.toString();
			int intInput = Integer.parseInt(inputString);
			atm.authenticateAccount(intInput);
			input.delete(0, input.length());
		}else if (atm.getCurrentStage() == ATM.UserStage.PIN_VERYFICATION){
			String inputString = input.toString();
			int intInput = Integer.parseInt(inputString);
			atm.authenticatePin(intInput);
			input.delete(0, input.length());
		}else if(atm.getCurrentStage() == ATM.UserStage.MAIN_MENU && Integer.parseInt(input.toString()) == 4){
			ATMGUI.displayMessage("Goodgbye!");
			ATMGUI.appendMessage("\n\nWelcome!\nPlease enter your account number: ");
			atm.setCurrentStage(ATM.UserStage.ACCOUNT_VERYFICATION);
			input.delete(0, input.length());
		}else if(atm.getCurrentStage() == ATM.UserStage.MAIN_MENU && Integer.parseInt(input.toString()) == 1){
			atm.performTransactions(Integer.parseInt(input.toString()));
			atm.displayMainMenu();
			input.delete(0, input.length());
		}else if(atm.getCurrentStage() == ATM.UserStage.MAIN_MENU && Integer.parseInt(input.toString()) == 2){
			atm.performTransactions(Integer.parseInt(input.toString()));
			input.delete(0, input.length());
			atm.setCurrentStage(ATM.UserStage.WITHDRAWAL_AMOUNT_MENU);
		}
		
	}

	
	// no-argument constructor initializes the Scanner
	public Keypad(ATM atm) {
		this.atm = atm;
		input = new StringBuilder();
	} // end no-argument Keypad constructor

} // end class Keypad
