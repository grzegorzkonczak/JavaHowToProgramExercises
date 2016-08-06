package chapter12.exercise12_18_second_try;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Grzegorz Koñczak, 05.08.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

public class Keypad implements ActionListener {

	private StringBuilder input;
	private ATM atm;

	public Keypad(ATM atm) {
		input = new StringBuilder();
		this.atm = atm;
	}

	// return an integer value entered by user
	private int getInput() {
		String inputAsString = input.toString();
		int inputAsInteger = Integer.parseInt(inputAsString);
		input.delete(0, input.length());
		return inputAsInteger;
	} // end method getInput

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() != "Enter" && e.getActionCommand() != "Remove Cash" && e.getActionCommand() != "Insert Envelope") {
			ATMGUI.appendMessage(e.getActionCommand());
			input.append(e.getActionCommand());
		}else if (e.getActionCommand() == "Enter" && input.length() > 0){
			int input = getInput();
			atm.setUserInput(input);
			atm.takeAction();
		}

	}
} // end class Keypad
