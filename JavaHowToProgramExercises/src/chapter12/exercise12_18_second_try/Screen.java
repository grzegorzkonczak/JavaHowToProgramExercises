package chapter12.exercise12_18_second_try;

// Grzegorz Koñczak, 05.08.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

public class Screen {
	// displays a message without a carriage return
	public void displayMessage(String message) {
		ATMGUI.displayMessage(message);
	} // end method displayMessage

	// appends a message to screen without a carriage return
	public void appendMessage(String message) {
		ATMGUI.appendMessage(message);
	} // end method displayMessage

	// appends a message to screen with a carriage return
	public void appendMessageLine(String message) {
		ATMGUI.appendMessage(message);
		ATMGUI.appendMessage("\n");
	} // end method displayMessage

	// display a message with a carriage return
	public void displayMessageLine(String message) {
		ATMGUI.displayMessage(message + "\n");
	} // end method displayMessageLine

	// append a dollar amount
	public void appendDollarAmount(double amount) {
		ATMGUI.appendMessage(String.format("$%,.2f", amount));
	} // end method displayDollarAmount
} // end class Screen
