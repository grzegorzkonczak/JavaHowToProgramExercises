// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.31 page 636
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class DrawFrame extends JFrame {

	private JButton undo;
	private JButton clear;
	private JComboBox<String> shapeChooser;
	private JCheckBox filledCheck;
	private JLabel statusLabel;
	private JCheckBox gradientChooser;
	private JButton colorChooser1;
	private JButton colorChooser2;
	private JLabel widthLabel;
	private JTextField strokeWidthSetter;
	private JLabel dashLabel;
	private JTextField strokeDashLengthChooser;
	private JCheckBox lineTypeChooser;
	private JPanel upperMenu;
	private JPanel upperBaseMenu;
	private JPanel upperExtendedMenu;

	private final static String[] shapes = { "Line", "Oval", "Rectangle" };
	private Color color1 = Color.BLACK;
	private Color color2 = Color.BLACK;

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

		// Shape chooser changes type of drawn shape
		shapeChooser = new JComboBox<>(shapes);
		shapeChooser.setMaximumRowCount(3);
		shapeChooser.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (shapeChooser.getSelectedIndex() == 0) {
					panel.setShapeType(0);
				} else if (shapeChooser.getSelectedIndex() == 1) {
					panel.setShapeType(1);
				} else if (shapeChooser.getSelectedIndex() == 2) {
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

		gradientChooser = new JCheckBox("Use Gradient");
		gradientChooser.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (gradientChooser.isSelected()) {
					panel.setCurrentPaint(new GradientPaint(0, 0, color1, 50, 50, color2, true));
				} else {
					panel.setCurrentPaint(color1);
				}

			}
		});

		colorChooser1 = new JButton("1st Color...");
		colorChooser1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				color1 = JColorChooser.showDialog(panel, "Choose first color", color1);
				gradientChooser.doClick(1);
				gradientChooser.doClick(1);
			}
		});
		colorChooser2 = new JButton("2nd Color...");
		colorChooser2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				color2 = JColorChooser.showDialog(panel, "Choose second color", color2);
				gradientChooser.doClick(1);
				gradientChooser.doClick(1);
			}
		});

		strokeWidthSetter = new JTextField("10", 2);
		strokeWidthSetter.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				if (!strokeWidthSetter.getText().isEmpty()) {
					lineTypeChooser.doClick(1);
					lineTypeChooser.doClick(1);
				}
			}
		});
		strokeDashLengthChooser = new JTextField("10", 2);
		strokeDashLengthChooser.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				if (!strokeDashLengthChooser.getText().isEmpty()) {
					lineTypeChooser.doClick(1);
					lineTypeChooser.doClick(1);
				}
			}
		});

		lineTypeChooser = new JCheckBox("Dashed");
		lineTypeChooser.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (!lineTypeChooser.isSelected()) {
					panel.setCurrentStroke(new BasicStroke(Integer.parseInt(strokeWidthSetter.getText()),
							BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
				} else {
					float[] dashes = { Float.parseFloat(strokeDashLengthChooser.getText()) };
					panel.setCurrentStroke(new BasicStroke(Integer.parseInt(strokeWidthSetter.getText()),
							BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashes, 0));
				}
			}
		});

		widthLabel = new JLabel("Line Width: ");
		dashLabel = new JLabel("Dash Length: ");

		upperBaseMenu = new JPanel();
		upperExtendedMenu = new JPanel();

		// Adding elements to upper panel
		upperBaseMenu.add(undo);
		upperBaseMenu.add(clear);
		upperBaseMenu.add(shapeChooser);
		upperBaseMenu.add(filledCheck);

		upperExtendedMenu.add(gradientChooser);
		upperExtendedMenu.add(colorChooser1);
		upperExtendedMenu.add(colorChooser2);
		upperExtendedMenu.add(widthLabel);
		upperExtendedMenu.add(strokeWidthSetter);
		upperExtendedMenu.add(dashLabel);
		upperExtendedMenu.add(strokeDashLengthChooser);
		upperExtendedMenu.add(lineTypeChooser);

		LayoutManager layout = new GridLayout(2, 1);
		upperMenu.setLayout(layout);
		upperMenu.add(upperBaseMenu);
		upperMenu.add(upperExtendedMenu);

		// Adding upper panel, drawing panel and status label to frame
		add(upperMenu, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);
	}
}
