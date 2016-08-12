// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.31 page 636
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.BasicStroke;

public abstract class MyBoundedShape extends MyShape {

	private boolean filled; // flag for filling the shape

	public MyBoundedShape(int x1, int y1, int x2, int y2, Paint paint, Stroke stroke, boolean filled) {
		super(x1, y1, x2, y2, paint, stroke);
		setFilled(filled);
	}

	// no argument constructor
	public MyBoundedShape() {
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke(), false);
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public int getUpperLeftX() {
		return Math.min(super.getX1(), super.getX2());
	}

	public int getUpperLeftY() {
		return Math.min(super.getY1(), super.getY2());
	}

	public int getWidth() {
		return Math.abs(super.getX1() - super.getX2());
	}

	public int getHeight() {
		return Math.abs(super.getY1() - super.getY2());
	}

}
