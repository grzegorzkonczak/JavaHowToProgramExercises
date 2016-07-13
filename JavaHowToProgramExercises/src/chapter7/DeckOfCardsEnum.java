// Grzegorz Koñczak, 12.07.2016
// Exercise number 7.34 page 350
// Exercise from Java:How to program 10th edition

package chapter7;

import java.security.SecureRandom;

import chapter7.EnumFace.Face;
import chapter7.EnumSuit.Suit;

public class DeckOfCardsEnum {
	private CardEnum[] deck; // array of Card objects
	private int currentCard; // index of next Card to be dealt (0-51)
	private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
	// random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();

	// constructor fills deck of Cards
	public DeckOfCardsEnum()
	   {
	      Face[] faces = {Face.ACE, Face.DEUCE, Face.THREE, Face.FOUR, Face.FIVE, Face.SIX, Face.SEVEN,
	    		  Face.EIGHT, Face.NINE, Face.TEN, Face.JACK, Face.QUEEN, Face.KING};
	      Suit[] suits = {Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES, Suit.CLUBS};

	      deck = new CardEnum[NUMBER_OF_CARDS]; // create array of Card objects
	      currentCard = 0; // first Card dealt will be deck[0]

	      // populate deck with Card objects
	      for (int count = 0; count < deck.length; count++) 
	         deck[count] = 
	            new CardEnum(faces[count % 13], suits[count / 13]);
	   }

	// shuffle deck of Cards with one-pass algorithm
	public void shuffle() {
		// next call to method dealCard should start at deck[0] again
		currentCard = 0;

		// for each Card, pick another random Card (0-51) and swap them
		for (int first = 0; first < deck.length; first++) {
			// select a random number between 0 and 51
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

			// swap current Card with randomly selected Card
			CardEnum temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}

	// deal one Card
	public CardEnum dealCard() {
		// determine whether Cards remain to be dealt
		if (currentCard < deck.length)
			return deck[currentCard++]; // return current Card in array
		else
			return null; // return null to indicate that all Cards were dealt
	}
}
