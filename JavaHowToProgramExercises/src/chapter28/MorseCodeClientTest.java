// Grzegorz Koñczak, 27.09.2016
// Exercise number 28.22 page 47 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import javax.swing.JFrame;

public class MorseCodeClientTest {

	MorseCodeClient application;

	public static void main(String[] args) {
		MorseCodeClient application;

		// if no command line args
		if (args.length == 0) {
			application = new MorseCodeClient("127.0.0.1"); // localhost
		} else {
			application = new MorseCodeClient(args[0]); // use args
		}

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
