// Grzegorz Koñczak, 11.07.2016
// Exercise number 7.28 page 348
// Exercise from Java:How to program 10th edition

package chapter7;

import java.security.SecureRandom;

public class TortoiseAndHare {

	public static void main(String[] args) {
		
		String[] track = new String[70];
		int tortoisePosition = 0;
		int harePosition = 0;
		
		boolean gameWon = false;
		
		while(gameWon){
			displayTrack(track, tortoisePosition, harePosition);
			tortoisePosition = advanceTortoise();
			harePosition = advanceHare();
			if (tortoisePosition == harePosition){
				conflict(track, tortoisePosition, harePosition);
			}
		}
	}
}
