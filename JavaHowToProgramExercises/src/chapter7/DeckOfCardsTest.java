// Grzegorz Koñczak, 11.07.2016
// Exercise number 7.30 page 349
// Exercise from Java:How to program 10th edition

package chapter7;

import chapter7.DeckOfCards.CardCombination;

public class DeckOfCardsTest {
	// execute application
	public static void main(String[] args) {
		
		
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order
		Card[] hand = new Card[5];
		
		
		// Deal a poker hand
		for (int i = 0; i < 5; i++) {
			
			// deal and display a Card
			hand[i] = myDeckOfCards.dealCard();
			System.out.printf("%-19s", hand[i]);
		}

		CardCombination combination = myDeckOfCards.checkHand(hand);
		System.out.println(combination);
	}
} // end class DeckOfCardsTest
