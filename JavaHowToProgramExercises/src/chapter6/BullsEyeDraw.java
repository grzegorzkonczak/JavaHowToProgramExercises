// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.1 page 271
// Exercise from Java:How to program 10th edition

package chapter6;

import javax.swing.JFrame;

public class BullsEyeDraw {

	public static void main(String[] args) {
		
		BullsEye panel = new BullsEye();
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
