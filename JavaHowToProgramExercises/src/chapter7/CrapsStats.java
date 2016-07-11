// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.18 page 343
// Exercise from Java:How to program 10th edition

package chapter7;

import java.util.ArrayList;

public class CrapsStats {

	public static void main(String[] args) {

		// Create game instance
		CrapsGame game = new CrapsGame();
		
		// Initialize ArrayList of summaries of games simulated
		ArrayList<PlaySummary> summaries = new ArrayList<>();

		// Play games in loop and store summary of each game in AraayList
		for (int i = 0; i < 10000; i++) {
			summaries.add(game.play());
		}

		// Main method for calculating statistics about played games
		calculateStats(summaries);
	}

	private static void calculateStats(ArrayList<PlaySummary> summaries) {
		// Control variables for number of played games
		int totalGames = 0;
		for (PlaySummary summary : summaries) {
			totalGames++;
		}
		
		// Initial information about number of played games
		System.out.println("On total " + totalGames + " games played: ");

		// Methods for generating additional statistics
		int wonGames = calculateWonGames(summaries); // How many games was won in how many rolls
		calculateLostGames(summaries); // How many games was lost in how many rolls
		calculateChanceOfWinning(summaries.size(), wonGames); // average chance of winning game
		calculateAverageLengthOfGame(summaries);
		calculateDoesChanceImproveWithLength(summaries); // displays chance to win based on how many rolls was taken
	}

	private static void calculateDoesChanceImproveWithLength(ArrayList<PlaySummary> summaries) {
		for (int i = 1; i <= 20; i++) {
			int gamesWon = 0;
			int gamesPlayed = 0;
			// Outer loop controls the number of rolls that chance of winning is calculated
			for (PlaySummary summary : summaries) {
				if (i < 20) {
					if (summary.getRolls() == i && summary.isGameWon())
						gamesWon++;
					if (summary.getRolls() == i)
						gamesPlayed++;
				}
				// Number of rolls 20 or higher is aggregated
				if (summary.isGameWon() && summary.getRolls() >= 20)
					gamesWon++;
				if (summary.getRolls() >= 20)
					gamesPlayed++;
			}
			// Calculating chance of winning on rolls number equal to i
			double chanceOfWin = (gamesWon / (double) gamesPlayed) * 100;
			if (i < 20)
				System.out.printf("%nChance to win with %d rolls is %.2f%%", i, chanceOfWin);
			else
				System.out.printf("%nChance to win with %d rolls or more is %.2f%%", i, chanceOfWin);
		}
	}

	// Totals all rolls and all games, then calculates the average number of rolls per game
	private static void calculateAverageLengthOfGame(ArrayList<PlaySummary> summaries) {
		int totalRolls = 0;
		for (PlaySummary summary : summaries) {
			totalRolls += summary.getRolls();
		}
		int averageRolls = totalRolls / summaries.size();
		System.out.println("\nAverage length of game is: " + averageRolls + " rolls");
	}

	// Calculates average winning chance based on all games and won games
	private static void calculateChanceOfWinning(int size, int wonGames) {
		double chanceOfWinning = (wonGames / (double) size) * 100;
		System.out.printf("%nChance of winning in craps are: %.2f%%", chanceOfWinning);

	}

	private static void calculateLostGames(ArrayList<PlaySummary> summaries) {
		// Array for counting the number of lost games based on number of rolls
		int[] frequency = new int[21];
		int gamesLost = 0;
		for (PlaySummary summary : summaries) {
			if (!(summary.isGameWon())) {
				if (summary.getRolls() < 20) {
					++frequency[summary.getRolls()];
					gamesLost++;
				// Rolls higher then 19 are aggregated
				} else {
					++frequency[20];
					gamesLost++;
				}
			}
		}
		System.out.println("\nGames lost: " + gamesLost);
		for (int i = 1; i < frequency.length; i++) {
			if (i < 20)
				System.out.println("Lost with " + i + " rolls - " + frequency[i] + " games.");
			else
				System.out.println("Lost with " + i + " rolls or more - " + frequency[i] + " games.");
		}
	}

	private static int calculateWonGames(ArrayList<PlaySummary> summaries) {
		// Array for counting the number of won games based on number of rolls
		int[] frequency = new int[21];
		int gamesWon = 0;
		for (PlaySummary summary : summaries) {
			if (summary.isGameWon()) {
				if (summary.getRolls() < 20) {
					++frequency[summary.getRolls()];
					gamesWon++;
				// Rolls higher then 19 are aggregated
				} else {
					++frequency[20];
					gamesWon++;
				}
			}
		}
		System.out.println("\nGames won: " + gamesWon);
		for (int i = 1; i < frequency.length; i++) {
			if (i < 20)
				System.out.println("Won with " + i + " rolls - " + frequency[i] + " games.");
			else
				System.out.println("Won with " + i + " rolls or more - " + frequency[i] + " games.");
		}
		return gamesWon;
	}
}
