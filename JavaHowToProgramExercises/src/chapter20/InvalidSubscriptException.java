// Grzegorz Koñczak, 26.08.2016
// Exercise number 20.5 page 909
// Exercise from Java:How to program 10th edition

package chapter20;

public class InvalidSubscriptException extends Exception {

	public InvalidSubscriptException() {
		this("Subscript out of bounds");
	}

	public InvalidSubscriptException(String message) {
		System.err.println(message);
	}
}
