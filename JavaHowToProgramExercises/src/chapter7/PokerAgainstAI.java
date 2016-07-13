// Grzegorz Koñczak, 12.07.2016
// Exercise number 7.33 page 350
// Exercise from Java:How to program 10th edition

package chapter7;

import chapter7.DeckOfCards.CardCombination;

import java.util.Scanner;

public class PokerAgainstAI {

	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order
		Card[] handPlayer = new Card[5];
		Card[] handComputer = new Card[5];
		
		System.out.println("First Deal:");

		// Deal both hands
		for (int i = 0; i < 5; i++) {

			// deal and display a Card
			handPlayer[i] = myDeckOfCards.dealCard();
			handComputer[i] = myDeckOfCards.dealCard();
		}

		System.out.println("Player:");
		for (int i = 0; i < 5; i++) {

			// display player Card
			System.out.printf("%-19s", handPlayer[i]);
		}

		// Check what combination was dealt to player and print it
		CardCombination combinationPlayer = myDeckOfCards.checkHand(handPlayer);
		System.out.println(combinationPlayer);
		System.out.println();

		System.out.println("Computer");
		for (int i = 0; i < 5; i++) {

			// display computer hidden Card
			System.out.printf("%-19s", "----------");
		}
		
		// Check what combination was dealt to computer and print blank
		CardCombination combinationComputer = myDeckOfCards.checkHand(handComputer);
		System.out.println("----------");

		// Ask player for cards he want to replace and replace them
		System.out.println("Which cards (from 1 to 5) would you like to replace? To end press 0.");
		int flag = input.nextInt();
		while (flag != 0){
			handPlayer[flag - 1] = myDeckOfCards.dealCard();
			flag = input.nextInt();
		}
		
		System.out.println("Second Deal:");
		
		System.out.println("Player:");
		for (int i = 0; i < 5; i++) {

			// display player Card
			System.out.printf("%-19s", handPlayer[i]);
		}

		// Check what combination was dealt to player and print it
		combinationPlayer = myDeckOfCards.checkHand(handPlayer);
		System.out.println(combinationPlayer);
		System.out.println();

		// Check which cards to replace for computer given the hand and combination that it
		// creates
		int[] cardsToReplace = determineCardsToReplace(combinationComputer, handComputer);

		System.out.println("Computer");
		// Deal appropriate number of new cards to computer and print new hand
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (count < cardsToReplace.length) {
				if (i == cardsToReplace[count]) {
					handComputer[i] = myDeckOfCards.dealCard();
					count++;
				}
			}
			System.out.printf("%-19s", handComputer[i]);
		}

		// Check for new combination and print it
		combinationComputer = myDeckOfCards.checkHand(handComputer);
		System.out.println(combinationComputer);

		// Check and display who wins
		int betterPlayer = determineBetterHand(combinationPlayer, combinationComputer);
		displayWinner(betterPlayer);
		input.close();
	}

	// Determines card that should be replaced given current hand
	private static int[] determineCardsToReplace(CardCombination combination, Card[] hand) {
		int numberOfCards = howManyCards(combination); // Calculates how many
														// cards to replace
		int[] cardsToReplace = new int[numberOfCards]; // Array for storing
														// position of cards to
														// replace

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

	private static void displayWinner(int betterPlayer) {
		if (betterPlayer == 0)
			System.out.println("\nIt's a tie!");
		else if (betterPlayer == 1)
			System.out.println("\nPlayer wins!");
		else
			System.out.println("\nComputer wins!");

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