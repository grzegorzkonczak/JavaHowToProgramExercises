// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.31 page 636
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
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
	Paint currentPaint;
	Stroke currentStroke;

	boolean gradientColor;
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
		currentPaint = Color.BLACK;
		currentStroke = new BasicStroke();
		setBackground(Color.WHITE);
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}

	// Set methods for drawing
	public void setShapeType(int shapeType) {
		this.shapeType = shapeType;
	}
	
	public void setGradientColor(boolean gradientColor){
		this.gradientColor = gradientColor;
	}

	public void setCurrentPaint(Paint currentPaint) {
		this.currentPaint = currentPaint;
	}

	public void setFilledShape(boolean filledShape) {
		this.filledShape = filledShape;
	}

	public void setCurrentStroke(Stroke currentStroke) {
		this.currentStroke = currentStroke;
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
		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i < shapeCount; i++) {
			shapes[i].draw(g2d);
		}
		if (currentShape != null) {
			currentShape.draw(g2d);
		}
	}

	// Mouse handler for drawing shapes
	private class MouseHandler extends MouseAdapter implements MouseMotionListener {

		// Start to draw shape
		@Override
		public void mousePressed(MouseEvent e) {
			if (shapeType == 0) {
				currentShape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(), currentPaint, currentStroke);
			} else if (shapeType == 1) {
				currentShape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(), currentPaint, currentStroke,
						filledShape);
			} else if (shapeType == 2) {
				currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentPaint, currentStroke,
						filledShape);
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
