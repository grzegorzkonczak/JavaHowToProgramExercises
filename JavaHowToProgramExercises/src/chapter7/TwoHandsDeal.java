// Grzegorz Koñczak, 12.07.2016
// Exercise number 7.31 page 349
// Exercise from Java:How to program 10th edition

package chapter7;

import chapter7.DeckOfCards.CardCombination;

public class TwoHandsDeal {

	// execute application
	public static void main(String[] args) {

		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order
		Card[] hand1 = new Card[5];
		Card[] hand2 = new Card[5];

		System.out.printf("%-19s%-19s%n", "Player 1", "Player 2");
		// Deal a poker hand
		for (int i = 0; i < 5; i++) {

			// deal and display a Card
			hand1[i] = myDeckOfCards.dealCard();
			System.out.printf("%-19s", hand1[i]);
			hand2[i] = myDeckOfCards.dealCard();
			System.out.printf("%-19s%n", hand2[i]);

		}

		CardCombination combination1 = myDeckOfCards.checkHand(hand1);
		CardCombination combination2 = myDeckOfCards.checkHand(hand2);
		System.out.printf("%-19s%-19s", combination1, combination2);
		int betterPlayer = determineBetterHand(combination1, combination2);
		displayWinner(betterPlayer);
		myDeckOfCards.shuffle();
	}

	private static void displayWinner(int betterPlayer) {
		if (betterPlayer == 0)
			System.out.println("\nIt's a tie!");
		else if (betterPlayer == 1)
			System.out.println("\nPlayer 1 wins!");
		else
			System.out.println("\nPlayer 2 wins!");
		
	}

	private static int determineBetterHand(CardCombination combination1, CardCombination combination2) {
		CardCombination[] scores = { CardCombination.NOTHING, CardCombination.PAIR, CardCombination.TWO_PAIR,
				CardCombination.THREE_OF_KIND, CardCombination.STRAIGHT, CardCombination.FLUSH,
				CardCombination.FULL_HOUSE, CardCombination.FOUR_OF_KIND };

		int score1 = 0;
		int score2 = 0;
		for (int i = 0; i < scores.length; i++) {
			if (combination1 == scores[i]) {
				score1 = i;
			}
			if (combination2 == scores[i]) {
				score2 = i;
			}
		}
		if (score1 == score2)
			return 0;
		else if (score1 > score2)
			return 1;
		else
			return 2;
			
	}
}
