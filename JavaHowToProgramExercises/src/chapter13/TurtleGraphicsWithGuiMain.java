// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.23 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import javax.swing.JFrame;

public class TurtleGraphicsWithGuiMain {

public static void main(String[] args) {
		
		JFrame frame = new JFrame("Turtle Graphics");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TurtleGraphicsWithGui panel = new TurtleGraphicsWithGui();
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
