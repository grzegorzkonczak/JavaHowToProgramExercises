// Grzegorz Koñczak, 17.08.2016
// Exercise number 14.27 page 684
// Exercise from Java:How to program 10th edition

package chapter14;

import javax.swing.JFrame;

public class SpamFilterMain {

	public static void main(String[] args) {
		
		SpamFilter panel = new SpamFilter();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
