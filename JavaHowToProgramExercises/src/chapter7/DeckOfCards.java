// Grzegorz Koñczak, 11.07.2016
// Exercise number 7.30 page 349
// Exercise from Java:How to program 10th edition

package chapter7;

import java.security.SecureRandom;

public class DeckOfCards {

	public enum CardCombination {
		NOTHING, PAIR, TWO_PAIR, THREE_OF_KIND, FOUR_OF_KIND, FLUSH, STRAIGHT, FULL_HOUSE
	}; // Possible 5 card hand combinations

	private Card[] deck; // array of Card objects
	private int currentCard; // index of next Card to be dealt (0-51)
	private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
	// random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();

	// constructor fills deck of Cards
	public DeckOfCards() {
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

		deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
		currentCard = 0; // first Card dealt will be deck[0]

		// populate deck with Card objects
		for (int count = 0; count < deck.length; count++)
			deck[count] = new Card(faces[count % 13], suits[count / 13]);
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
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}

	// deal one Card
	public Card dealCard() {
		// determine whether Cards remain to be dealt
		if (currentCard < deck.length)
			return deck[currentCard++]; // return current Card in array
		else
			return null; // return null to indicate that all Cards were dealt
	}

	// Method for checking value of poker hand
	public CardCombination checkHand(Card[] hand) {

		// Check for possible flush
		boolean suitCheck = true;
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		for (int i = 0; i < 4; i++) {
			suitCheck = true;
			for (int j = 0; j < 5; j++) {
				if (hand[j].getSuit() != suits[i])
					suitCheck = false;
			}
			if (suitCheck)
				return CardCombination.FLUSH;
		}

		// Check for four of kind
		boolean isFour = false;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (hand[i].getFace() == hand[j].getFace())
					for (int k = 0; k < 5; k++) {
						if (k != i && k != j && hand[k].getFace() == hand[i].getFace())
							for (int l = 0; l < 5; l++) {
								if (l != i && l != j && l != k && hand[l].getFace() == hand[i].getFace())
									isFour = true;
							}
					}
			}
			if (isFour)
				return CardCombination.FOUR_OF_KIND;
		}

		// Check for straight
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };

		// Sort the hand
		int swapCounter = 0;
		Card[] sortedHand = new Card[5];
		for (int i = 0; i < faces.length; i++) {
			for (int j = 0; j < 5; j++) {
				if (faces[i] == hand[j].getFace()) {
					sortedHand[0 + swapCounter] = hand[j];
					swapCounter++;
				}
			}
		}

		// Check sorted hand for straight
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if (sortedHand[i].getFace() == faces[j]) {
					int count = 0;
					for (int k = 1; k < 5; k++) {
						if (sortedHand[k].getFace() == faces[j + k]) {
							count++;
						}
					}
					if (count == 4 || ((sortedHand[0].getFace() == "Ten") && (sortedHand[4].getFace() == "Ace"))) {
						return CardCombination.STRAIGHT;
					}
				}
			}
		}

		// Check for full house
		boolean isFull = false;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (hand[i].getFace() == hand[j].getFace())
					for (int k = 0; k < 5; k++)
						if (k != i && k != j && hand[k].getFace() == hand[i].getFace())
							for (int l = 0; l < 5; l++)
								for (int m = l + 1; m < 5; m++)
									if (hand[l].getFace() == hand[m].getFace() && (l != i && l != j && l != k)
											&& (m != i && m != j && m != k))
										isFull = true;

			}
			if (isFull)
				return CardCombination.FULL_HOUSE;
		}

		// Check for three of kind
		boolean isThree = false;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (hand[i].getFace() == hand[j].getFace())
					for (int k = 0; k < 5; k++) {
						if (k != i && k != j && hand[k].getFace() == hand[i].getFace())
							isThree = true;
					}
			}
			if (isThree)
				return CardCombination.THREE_OF_KIND;
		}

		// Check for two pair
		boolean isTwoPair = false;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (hand[i].getFace() == hand[j].getFace())
					for (int k = 0; k < 5; k++)
						for (int l = k + 1; l < 5; l++)
							if (hand[k].getFace() == hand[l].getFace() && (k != i && k != j) && (l != i && l != j))
								isTwoPair = true;
			}
			if (isTwoPair)
				return CardCombination.TWO_PAIR;
		}

		// Check for pair
		boolean isPair = false;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (hand[i].getFace() == hand[j].getFace())
					isPair = true;
			}
			if (isPair)
				return CardCombination.PAIR;
		}

		return CardCombination.NOTHING;
	}
} // end class DeckOfCards