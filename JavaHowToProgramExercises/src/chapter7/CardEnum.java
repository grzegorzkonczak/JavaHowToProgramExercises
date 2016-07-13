// Grzegorz Koñczak, 12.07.2016
// Exercise number 7.34 page 350
// Exercise from Java:How to program 10th edition

package chapter7;

import chapter7.EnumFace.Face;
import chapter7.EnumSuit.Suit;

public class CardEnum {
	private final Face face; // face of card ("Ace", "Deuce", ...)
	private final Suit suit; // suit of card ("Hearts", "Diamonds", ...)

	// two-argument constructor initializes card's face and suit
	public CardEnum(Face face, Suit suit)
	   {
	      this.face = face;
	      this.suit = suit; 
	   }

	// return String representation of Card
	public String toString() {
		return face + " of " + suit;
	}
}
