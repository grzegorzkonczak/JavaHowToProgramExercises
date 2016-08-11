// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.32 page 637
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LowVisionTest {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Low Vision");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LowVision panel = new LowVision();
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(700, 500);
		frame.setVisible(true);
	}
}
