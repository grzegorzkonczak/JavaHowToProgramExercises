// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.17 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import javax.swing.JFrame;

public class UserCircleTest {

public static void main(String[] args) {

		JFrame frame = new JFrame("User Circles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UserCircle panel = new UserCircle();
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
