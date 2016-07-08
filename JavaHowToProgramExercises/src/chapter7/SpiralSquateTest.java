// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.1 page 335
// Exercise from Java:How to program 10th edition

package chapter7;

import javax.swing.JFrame;

public class SpiralSquateTest {
	
	public static void main(String[] args) {
		
		SpriralSquare panel = new SpriralSquare();
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

}
