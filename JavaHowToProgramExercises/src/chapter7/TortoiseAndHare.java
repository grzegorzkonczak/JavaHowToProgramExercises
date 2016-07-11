// Grzegorz Koñczak, 11.07.2016
// Exercise number 7.28 page 348
// Exercise from Java:How to program 10th edition

package chapter7;

import java.security.SecureRandom;

public class TortoiseAndHare {

	private static final SecureRandom random = new SecureRandom();
	
	public static void main(String[] args) {
		
		String[] track = new String[71];
		int tortoisePosition = 1;
		int harePosition = 1;
		
		boolean gameWon = false;
		boolean conflict = false;
		int secondsCounter = 0;
		
		while(!gameWon){
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.print((secondsCounter++) + " ");
			displayTrack(track, tortoisePosition, harePosition, conflict);
			conflict = false;
			tortoisePosition += advanceTortoise();
			if(tortoisePosition < 1)
				tortoisePosition = 1;
			harePosition += advanceHare();
			if(harePosition < 1)
				harePosition = 1;
			if (tortoisePosition == harePosition){
				conflict = true;
			}
			if(tortoisePosition >= 70 || harePosition >= 70)
				gameWon = true;
			if(tortoisePosition > 70)
				tortoisePosition = 70;
			if(harePosition > 70)
				harePosition = 70;
		}
		System.out.print("  ");
		displayTrack(track, tortoisePosition, harePosition, conflict);
		displayWinner(tortoisePosition, harePosition);
	}

	private static void displayWinner(int tortoisePosition, int harePosition) {
		if (tortoisePosition >= 70)
			System.out.println("Tortoise Wins!");
		else
			System.out.println("Hare wins...");
		
	}

	private static int advanceHare() {
		int move = 1 + random.nextInt(10);
		if (move <= 2)
			return 0;
		else if (move <= 4)
			return 9;
		else if (move <= 5)
			return -10;
		else if (move <= 8)
			return 1;
		else
			return -2;
	}

	private static int advanceTortoise() {
		int move = 1 + random.nextInt(10);
		if (move <= 5)
			return 3;
		else if (move <= 7)
			return -6;
		else
			return 1;
	}

	private static void displayTrack(String[] track, int tortoisePosition, int harePosition, boolean conflict) {
		for (int i = 1; i < track.length; i++){
			if(conflict && (i == tortoisePosition))
				System.out.printf("%2s", "OUCH!!");
			else if(i == tortoisePosition)
				System.out.printf("%2s", "T");
			else if (i == harePosition)
				System.out.printf("%2s", "H");
			else
				System.out.printf("%2s", " ");
		}
		System.out.println();
	}

	
}
