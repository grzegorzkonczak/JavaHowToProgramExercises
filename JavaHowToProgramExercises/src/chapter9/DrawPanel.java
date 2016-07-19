// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.1 page 432
// Exercise from Java:How to program 10th edition

package chapter9;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
	private SecureRandom randomNumbers = new SecureRandom();
	private MyLine[] lines; // array on lines
	private MyRectangle[] rectangles; /// array of rectangles
	private MyOval[] ovals; // array of ovals

	// constructor, creates a panel with random shapes
	public DrawPanel() {
		setBackground(Color.WHITE);

		lines = new MyLine[1 + randomNumbers.nextInt(5)];
		rectangles = new MyRectangle[1 + randomNumbers.nextInt(5)];
		ovals = new MyOval[1 + randomNumbers.nextInt(5)];

		// create lines
		for (int count = 0; count < lines.length; count++) {
			// generate random coordinates
			int x1 = randomNumbers.nextInt(300);
			int y1 = randomNumbers.nextInt(300);
			int x2 = randomNumbers.nextInt(300);
			int y2 = randomNumbers.nextInt(300);

			// generate a random color
			Color color = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));

			// add the line to the list of lines to be displayed
			lines[count] = new MyLine(x1, y1, x2, y2, color);
		}

		// create rectangles
		for (int count = 0; count < rectangles.length; count++) {
			// generate random coordinates
			int x1 = randomNumbers.nextInt(300);
			int y1 = randomNumbers.nextInt(300);
			int x2 = randomNumbers.nextInt(300);
			int y2 = randomNumbers.nextInt(300);

			// generate a random color
			Color color = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));

			// generate random fill
			int fill = randomNumbers.nextInt(2);
			boolean isFilled;
			if (fill == 0) {
				isFilled = false;
			} else {
				isFilled = true;
			}
			// add the rectangle to the list of rectangles to be displayed
			rectangles[count] = new MyRectangle(x1, y1, x2, y2, color, isFilled);
		}

		// create ovals
		for (int count = 0; count < ovals.length; count++) {
			// generate random coordinates
			int x1 = randomNumbers.nextInt(300);
			int y1 = randomNumbers.nextInt(300);
			int x2 = randomNumbers.nextInt(300);
			int y2 = randomNumbers.nextInt(300);

			// generate a random color
			Color color = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));

			// generate random fill
			int fill = randomNumbers.nextInt(2);
			boolean isFilled;
			if (fill == 0) {
				isFilled = false;
			} else {
				isFilled = true;
			}
			// add the rectangle to the list of rectangles to be displayed
			ovals[count] = new MyOval(x1, y1, x2, y2, color, isFilled);
		}
	}
	
	public String statusText(){
		return String.format("%s: %d  %s: %d  %s: %d", "Lines", lines.length, "Rectangles", rectangles.length,
				"Ovals", ovals.length);
	}

	// for each shape array, draw the individual shapes
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw the lines
		for (MyLine line : lines)
			line.draw(g);
		// draw the rectangles
		for (MyRectangle rectangle : rectangles)
			rectangle.draw(g);
		// draw the ovals
		for (MyOval oval : ovals)
			oval.draw(g);
	}
} // end class DrawPanel
