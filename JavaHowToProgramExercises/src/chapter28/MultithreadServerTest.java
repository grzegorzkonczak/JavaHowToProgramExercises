// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.15 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import javax.swing.JFrame;

public class MultithreadServerTest {

	public static void main(String[] args) {
		MultithreadServer application = new MultithreadServer();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runServer();
	}
}
