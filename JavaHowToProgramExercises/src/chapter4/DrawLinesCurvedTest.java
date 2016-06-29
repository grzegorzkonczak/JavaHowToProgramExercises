// Grzegorz Koñczak, 29.06.2016
// Exercise number 4.2 page 181
// Exercise from Java:How to program 10th edition

package chapter4;

import javax.swing.JFrame;

public class DrawLinesCurvedTest {

	public static void main(String[] args) {
		
		// create a panel that holds our drawing
		DrawLinesCurved lines  = new DrawLinesCurved();
		
		// create new frame to hold the panel
		JFrame application = new JFrame();
		
		// Setting frame parameters (content, default exit, size and visibility)
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(lines);
		application.setSize(250, 250);
		application.setVisible(true);
	}

}