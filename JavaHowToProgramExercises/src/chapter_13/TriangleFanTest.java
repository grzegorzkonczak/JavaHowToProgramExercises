// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.9 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.Color;

import javax.swing.JFrame;

public class TriangleFanTest {

public static void main(String[] args) {
		
		JFrame frame = new JFrame("Fan");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TriangleFan panel = new TriangleFan();
		frame.add(panel);
		frame.setBackground(Color.WHITE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
