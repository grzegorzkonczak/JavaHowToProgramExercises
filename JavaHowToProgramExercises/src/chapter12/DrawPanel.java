// Grzegorz Koñczak, 25.07.2016
// Exercise number 12.17 page 594
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	// Initializing members of class
	MyShape[] shapes;
	int shapeCount;
	int shapeType;
	MyShape currentShape;
	Color currentColor;
	boolean filledShape;
	JLabel statusLabel;

	/**
	 * Create the panel.
	 */
	public DrawPanel(JLabel label) {
		statusLabel = label;
		shapes = new MyShape[100];
		shapeCount = 0;
		shapeType = 0;
		currentShape = null;
		currentColor = Color.BLACK;
		setBackground(Color.WHITE);
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}

	// Set methods for drawing
	public void setShapeType(int shapeType) {
		this.shapeType = shapeType;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	public void setFilledShape(boolean filledShape) {
		this.filledShape = filledShape;
	}

	// Clearing methods removing last or all shapes
	public void clearLastShape() {
		if (shapeCount > 0)
			shapeCount--;
		repaint();
	}

	public void clearDrawing() {
		shapeCount = 0;
		repaint();
	}

	// Paint component redraws all shapes that were drawn earlier and current
	// shape
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < shapeCount; i++) {
			shapes[i].draw(g);
		}
		if (currentShape != null) {
			currentShape.draw(g);
		}
	}

	// Mouse handler for drawing shapes
	private class MouseHandler extends MouseAdapter implements MouseMotionListener {

		// Start to draw shape
		@Override
		public void mousePressed(MouseEvent e) {
			if (shapeType == 0) {
				currentShape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(), currentColor);
			} else if (shapeType == 1) {
				currentShape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);
			} else if (shapeType == 2) {
				currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);
			}

		}

		// End drawing shape
		@Override
		public void mouseReleased(MouseEvent e) {
			currentShape.setX2(e.getX());
			currentShape.setY2(e.getY());
			shapes[shapeCount] = currentShape;
			shapeCount++;
			currentShape = null;
			repaint();
		}

		// Update shape as it is being drawn
		@Override
		public void mouseDragged(MouseEvent e) {
			currentShape.setX2(e.getX());
			currentShape.setY2(e.getY());
			repaint();
			statusLabel.setText(String.format("%d: %d:", e.getX(), e.getY()));

		}

		// Update mouse coordinates in label
		@Override
		public void mouseMoved(MouseEvent e) {
			statusLabel.setText(String.format("%d: %d:", e.getX(), e.getY()));

		}

	}
}
