// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.1 page 231
// Exercise from Java:How to program 10th edition

package chapter5;

import javax.swing.JFrame;

public class CirclesTest {

	public static void main (String[] args){
		
		Circles panel = new Circles();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(250, 250);
		frame.setVisible(true);
	}
}
