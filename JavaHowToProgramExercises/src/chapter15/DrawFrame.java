// Grzegorz Koñczak, 19.08.2016
// Exercise number 15.9 page 725
// Exercise from Java:How to program 10th edition

package chapter15;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawFrame extends JFrame {

	private JButton undo;
	private JButton clear;
	private JComboBox<String> colorChooser;
	private JComboBox<String> shapeChooser;
	private JCheckBox filledCheck;
	private JLabel statusLabel;
	private JPanel upperMenu;
	private JButton save;
	private JButton load;

	private final static String[] shapes = { "Line", "Oval", "Rectangle" };
	private final static String[] colorNames = { "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray",
			"Magneta", "Orange", "Pink", "Red", "White", "Yellow" };
	private final static Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
			Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
			Color.YELLOW };

	public DrawFrame() {

		super("Java Drawing");

		// Initialize Draw Panel and lower status label
		statusLabel = new JLabel("0: 0:");
		DrawPanel panel = new DrawPanel(statusLabel);

		// Panel for upper menu
		upperMenu = new JPanel(new FlowLayout());

		// Undo button clears last shape
		undo = new JButton("Undo");
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.clearLastShape();

			}
		});

		// Clear button clears whole drawing
		clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.clearDrawing();

			}
		});

		// Color chooser changes color of drawn shape
		colorChooser = new JComboBox<>(colorNames);
		colorChooser.setMaximumRowCount(3);
		colorChooser.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				panel.setCurrentColor(colors[colorChooser.getSelectedIndex()]);

			}
		});

		// Shape chooser changes type of drawn shape
		shapeChooser = new JComboBox<>(shapes);
		shapeChooser.setMaximumRowCount(3);
		shapeChooser.addItemListener(
				new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						if (shapeChooser.getSelectedIndex() == 0){
							panel.setShapeType(0);
						}else if (shapeChooser.getSelectedIndex() == 1){
							panel.setShapeType(1);
						}else if (shapeChooser.getSelectedIndex() == 2){
							panel.setShapeType(2);
						}
					}
				});

		// Check box for indicating if shape should be filled
		filledCheck = new JCheckBox("Filled");
		filledCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (filledCheck.isSelected()) {
					panel.setFilledShape(true);
				} else
					panel.setFilledShape(false);

			}
		});
		
		save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.saveDrawing();
			}
		});
		
		load = new JButton("Load");
		load.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.loadDrawing();
				panel.repaint();
			}
		});

		// Adding elements to upper panel
		upperMenu.add(undo);
		upperMenu.add(clear);
		upperMenu.add(colorChooser);
		upperMenu.add(shapeChooser);
		upperMenu.add(filledCheck);
		upperMenu.add(save);
		upperMenu.add(load);

		// Adding upper panel, drawing panel and status label to frame
		add(upperMenu, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);
	}
}
