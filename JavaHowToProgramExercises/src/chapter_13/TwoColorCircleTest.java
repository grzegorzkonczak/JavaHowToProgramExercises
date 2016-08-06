// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.12 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import javax.swing.JFrame;

public class TwoColorCircleTest {

public static void main(String[] args) {
		
		JFrame frame = new JFrame("Two Color Circle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TwoColorCircle panel = new TwoColorCircle();
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
