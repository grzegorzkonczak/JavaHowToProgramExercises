// Grzegorz Koñczak, 12.09.2016
// Exercise number 23.10/11/12 page 1085
// Exercise from Java:How to program 10th edition

package chapter23;


import java.awt.BorderLayout;

import javax.swing.JFrame;

public class BouncingBallFrame extends JFrame{

	public static void main(String[] args) {
		
		BouncingBallFrame frame = new BouncingBallFrame();
		BouncingBallPanel panel = new BouncingBallPanel();
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
