// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.28/29/30 page 635
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class SelectingShapesTest {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Selecting Shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SelectingShapes panel = new SelectingShapes("Rectangle");
		String[] shapes = { "Rectangle", "Oval" };
		JComboBox<String> shapeSelector = new JComboBox<>(shapes);
		JButton colorSelector = new JButton("Choose Color");

		frame.add(panel, BorderLayout.CENTER);
		frame.add(shapeSelector, BorderLayout.NORTH);
		frame.add(colorSelector, BorderLayout.SOUTH);
		frame.setSize(500, 500);
		frame.setVisible(true);

		shapeSelector.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				panel.setShape(shapes[shapeSelector.getSelectedIndex()]);
				panel.repaint();
			}
		});
		
		colorSelector.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setColor(JColorChooser.showDialog(frame, "Choose a color", panel.getColor()));
				panel.repaint();
			}
		});
	}

}
