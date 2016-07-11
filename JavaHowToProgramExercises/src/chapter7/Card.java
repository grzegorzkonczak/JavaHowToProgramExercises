// Grzegorz Koñczak, 11.07.2016
// Exercise number 7.30 page 349
// Exercise from Java:How to program 10th edition

package chapter7;

public class Card {
	private final String face; // face of card ("Ace", "Deuce", ...)
	private final String suit; // suit of card ("Hearts", "Diamonds", ...)

	public String getFace() {
		return face;
	}

	public String getSuit() {
		return suit;
	}

	// two-argument constructor initializes card's face and suit
	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}

	// return String representation of Card
	public String toString() {
		return face + " of " + suit;
	}
} // end class Card