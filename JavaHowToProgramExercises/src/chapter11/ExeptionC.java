// Grzegorz Koñczak, 21.07.2016
// Exercise number 11.16 page 514
// Exercise from Java:How to program 10th edition

package chapter11;

public class ExeptionC extends ExeptionB {

	@Override
	public String getMessage() {
		return String.format("Exeption C");
	}
}
