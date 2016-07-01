// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.2 page 232
// Exercise from Java:How to program 10th edition

package chapter5;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BarChartGraphicTest {

	public static void main(String[] args) {
		
		String input1 = JOptionPane.showInputDialog("Enter length of bar number 1");
		String input2 = JOptionPane.showInputDialog("Enter length of bar number 2");
		String input3 = JOptionPane.showInputDialog("Enter length of bar number 3");
		String input4 = JOptionPane.showInputDialog("Enter length of bar number 4");
		String input5 = JOptionPane.showInputDialog("Enter length of bar number 5");
		
		int bar1 = Integer.parseInt(input1);
		int bar2 = Integer.parseInt(input2);
		int bar3 = Integer.parseInt(input3);
		int bar4 = Integer.parseInt(input4);
		int bar5 = Integer.parseInt(input5);
		
		BarChartGraphic panel = new BarChartGraphic(bar1, bar2, bar3, bar4, bar5);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(350, 350);
		frame.setVisible(true);

	}
}
