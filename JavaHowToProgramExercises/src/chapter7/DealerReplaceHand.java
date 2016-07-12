// Grzegorz Koñczak, 12.07.2016
// Exercise number 7.32 page 350
// Exercise from Java:How to program 10th edition

package chapter7;

import chapter7.DeckOfCards.CardCombination;

public class DealerReplaceHand {

	public static void main(String[] args) {

		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order
		Card[] hand = new Card[5];

		// Deal and print dealers Hand
		System.out.println("Before:");
		for (int i = 0; i < 5; i++) {

			// deal and display a Card
			hand[i] = myDeckOfCards.dealCard();
			System.out.printf("%-19s", hand[i]);
		}
		
		// Check what combination was dealt and print it
		CardCombination combination = myDeckOfCards.checkHand(hand);
		System.out.println(combination);
		
		// Check which cards to replace given the hand and combination that it creates
		int[] cardsToReplace = determineCardsToReplace(combination, hand);

		// Deal appropriate number of new cards and print new hand
		System.out.println("After: ");
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (count < cardsToReplace.length) {
				if (i == cardsToReplace[count]) {
					hand[i] = myDeckOfCards.dealCard();
					count++;
				}
			}
			System.out.printf("%-19s", hand[i]);
		}
		
		// Check for new combination and print it
		combination = myDeckOfCards.checkHand(hand);
		System.out.println(combination);
	}

	// Determines card that should be replaced given current hand
	private static int[] determineCardsToReplace(CardCombination combination, Card[] hand) {
		int numberOfCards = howManyCards(combination); // Calculates how many cards to replace
		int[] cardsToReplace = new int[numberOfCards]; // Array for storing position of cards to replace
		
		// Support array to hold data about cards that can't be replaced
		Card[] afterElimination = new Card[5];
		for (int i = 0; i < 5; i++) {
			afterElimination[i] = hand[i];
		}
		Card blank = new Card("Blank", "Blank");

		// Which cards to replace when dealer has nothing
		if (numberOfCards == 3 && combination == CardCombination.NOTHING) {
			cardsToReplace[0] = 0;
			cardsToReplace[1] = 1;
			cardsToReplace[2] = 2;
			return cardsToReplace;
		}

		// Which cards to replace when dealer has pair
		// First exclude the pair
		if (numberOfCards == 3 && combination == CardCombination.PAIR) {
			for (int i = 0; i < 5; i++) {
				for (int j = i + 1; j < 5; j++) {
					if (hand[i].getFace() == hand[j].getFace()) {
						afterElimination[i] = blank;
						afterElimination[j] = blank;
					}
				}
			}
			
			// Next mark position of cards to replace
			int count = 0;
			for (int i = 0; i < 5; i++) {
				if (afterElimination[i].getFace() != "Blank") {
					cardsToReplace[count] = i;
					count++;
				}
			}
			return cardsToReplace;
		}

		// Which cards to replace when dealer has two pair
		// First exclude the pairs
		if (numberOfCards == 1 && combination == CardCombination.TWO_PAIR) {
			for (int i = 0; i < 5; i++) {
				for (int j = i + 1; j < 5; j++) {
					if (hand[i].getFace() == hand[j].getFace())
						for (int k = 0; k < 5; k++)
							for (int l = k + 1; l < 5; l++)
								if (hand[k].getFace() == hand[l].getFace() && (k != i && k != j)
										&& (l != i && l != j)) {
									afterElimination[i] = blank;
									afterElimination[j] = blank;
									afterElimination[k] = blank;
									afterElimination[l] = blank;
								}

				}
			}
			// Next mark position of card to replace
			for (int i = 0; i < 5; i++) {
				if (afterElimination[i].getFace() != "Blank") {
					cardsToReplace[0] = i;
				}
			}
			return cardsToReplace;
		}

		// Which cards to replace when dealer has three of kind
		// First exclude the three
		if (numberOfCards == 2 && combination == CardCombination.THREE_OF_KIND) {
			for (int i = 0; i < 5; i++) {
				for (int j = i + 1; j < 5; j++) {
					if (hand[i].getFace() == hand[j].getFace())
						for (int k = 0; k < 5; k++) {
							if (k != i && k != j && hand[k].getFace() == hand[i].getFace()) {
								afterElimination[i] = blank;
								afterElimination[j] = blank;
								afterElimination[k] = blank;
							}
						}
				}
			}
			// Next mark position of cards to replace
			int count = 0;
			for (int i = 0; i < 5; i++) {
				if (afterElimination[i].getFace() != "Blank") {
					cardsToReplace[count] = i;
					count++;
				}
			}
			return cardsToReplace;
		}

		return cardsToReplace;
	}

	// Calculate how many cards to replace given current combination of 5 cards
	private static int howManyCards(CardCombination combination) {

		int cardsToReplace = 0;
		if (combination == CardCombination.NOTHING)
			cardsToReplace = 3;
		if (combination == CardCombination.PAIR)
			cardsToReplace = 3;
		if (combination == CardCombination.TWO_PAIR)
			cardsToReplace = 1;
		if (combination == CardCombination.THREE_OF_KIND)
			cardsToReplace = 2;

		return cardsToReplace;
	}
}
