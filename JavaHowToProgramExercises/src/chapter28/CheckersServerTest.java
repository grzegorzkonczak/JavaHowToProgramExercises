// Grzegorz Koñczak, 23.09.2016
// Exercise number 28.16 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import javax.swing.JFrame;

public class CheckersServerTest {

	public static void main(String[] args) {
		CheckersServer application = new CheckersServer();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.execute();
	}
}
