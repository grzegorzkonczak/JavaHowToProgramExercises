// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.15 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import javax.swing.JFrame;

public class TetrahedronTest {

public static void main(String[] args) {
		
		JFrame frame = new JFrame("Tetrahedron");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Tetrahedron panel = new Tetrahedron();
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
