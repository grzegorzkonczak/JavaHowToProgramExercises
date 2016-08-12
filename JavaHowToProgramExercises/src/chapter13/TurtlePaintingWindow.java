// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.23 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class TurtlePaintingWindow extends JPanel {

	Turtle turtle;
	List<Line> lines = new ArrayList<>();

	public TurtlePaintingWindow(Turtle turtle) {
		this.turtle = turtle;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		// Draw all previous lines
		for (Line line : lines) {
			g2d.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
		}

		// Draw turtle in on current position
		g2d.setColor(Color.GREEN);
		g2d.fill(new Ellipse2D.Double(turtle.getCurrentXPosition(), turtle.getCurrentYPosition(), 10, 10));
		g2d.setColor(Color.BLACK);

		// Draw dot indicating facing
		if (turtle.getFacing() == 0) {
			g2d.fill(new Ellipse2D.Double(turtle.getCurrentXPosition() + 2.5, turtle.getCurrentYPosition() + 5, 5, 5));
		} else if (turtle.getFacing() == 1) {
			g2d.fill(new Ellipse2D.Double(turtle.getCurrentXPosition(), turtle.getCurrentYPosition() + 2.5, 5, 5));
		} else if (turtle.getFacing() == 2) {
			g2d.fill(new Ellipse2D.Double(turtle.getCurrentXPosition() + 2.5, turtle.getCurrentYPosition(), 5, 5));
		} else {
			g2d.fill(new Ellipse2D.Double(turtle.getCurrentXPosition() + 5, turtle.getCurrentYPosition() + 2.5, 5, 5));
		}

		// Draw lines if pen is down
		if (turtle.isDrawing() == true) {
			g2d.drawLine(turtle.getLastXPosition(), turtle.getLastYPosition(), turtle.getCurrentXPosition(),
					turtle.getCurrentYPosition());
			lines.add(new Line(turtle.getLastXPosition(), turtle.getLastYPosition(), turtle.getCurrentXPosition(),
					turtle.getCurrentYPosition()));
		}
	}
}
