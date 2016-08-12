// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.24 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import javax.swing.JFrame;

public class KnightsTourGuiMain {

public static void main(String[] args) {
		
		JFrame frame = new JFrame("Knights Tour");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		KnightsTourGui panel = new KnightsTourGui();
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setVisible(true);
		panel.run();
	}
}
