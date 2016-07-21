// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.1 page 476
// Exercise from Java:How to program 10th edition

package chapter10;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {

	int numberOfShapes = Integer.parseInt(JOptionPane.showInputDialog("How many shapes to generate?")); // number
																										// of
																										// shapes
																										// to
																										// generate
	private SecureRandom randomNumbers = new SecureRandom();
	private MyShape[] shapes = new MyShape[numberOfShapes];
	// three variables for storing number of given shapes that where generated
	int lines = 0;
	int rectangles = 0;
	int ovals = 0;

	// constructor, creates a panel with random shapes
	public DrawPanel() {
		setBackground(Color.WHITE);

		// create shapes
		for (int count = 0; count < shapes.length; count++) {
			// generate random shape
			int shapeType = randomNumbers.nextInt(3);
			// generate random coordinates
			int x1 = randomNumbers.nextInt(300);
			int y1 = randomNumbers.nextInt(300);
			int x2 = randomNumbers.nextInt(300);
			int y2 = randomNumbers.nextInt(300);

			// generate a random color
			Color color = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));

			// add given shape to shapes array
			if (shapeType == 0) {
				// add the line to the list of shapes to be displayed
				shapes[count] = new MyLine(x1, y1, x2, y2, color);
				lines++;
			} else {
				// generate random fill
				int fill = randomNumbers.nextInt(2);
				boolean isFilled;
				if (fill == 0) {
					isFilled = false;
				} else {
					isFilled = true;
				}
				if (shapeType == 1) {
					// add the rectangle to the list of rectangles to be
					// displayed
					shapes[count] = new MyRectangle(x1, y1, x2, y2, color, isFilled);
					rectangles++;
				} else {
					// add the rectangle to the list of rectangles to be
					// displayed
					shapes[count] = new MyOval(x1, y1, x2, y2, color, isFilled);
					ovals++;
				}
			}

		}
	}

	public String statusText() {
		return String.format("%s: %d  %s: %d  %s: %d", "Lines", lines, "Rectangles", rectangles, "Ovals", ovals);
	}

	// draw the individual shapes from shape array
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw the shape
		for (MyShape shape : shapes)
			shape.draw(g);
	}
} // end class DrawPanel
