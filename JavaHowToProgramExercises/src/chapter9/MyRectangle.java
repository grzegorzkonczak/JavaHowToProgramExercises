// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.1 page 432
// Exercise from Java:How to program 10th edition

package chapter9;

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle {

	private int x1; // x-coordinate of first endpoint
	private int y1; // y-coordinate of first endpoint
	private int x2; // x-coordinate of second endpoint
	private int y2; // y-coordinate of second endpoint
	private Color color; // color of this Rectangle
	private boolean filled; // flag for filling the shape

	public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
		setX1(x1);
		setY1(y1);
		setX2(x2);
		setY2(y2);
		setColor(color);
		setFilled(filled);
	}

	// no argument constructor
	public MyRectangle() {
		this(0, 0, 0, 0, Color.BLACK, false);
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		if (x1 >= 0)
			this.x1 = x1;
		else
			this.x1 = 0;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		if (y1 >= 0)
			this.y1 = y1;
		else
			this.y1 = 0;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		if (x2 >= 0)
			this.x2 = x2;
		else
			this.x2 = 0;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		if (y2 >= 0)
			this.y2 = y2;
		else
			this.y2 = 0;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getUpperLeftX() {
		return Math.min(x1, x1);
	}

	public int getUpperLeftY() {
		return Math.min(y1, y2);
	}

	public int getWidth() {
		return Math.abs(x1 - x2);
	}

	public int getHeight() {
		return Math.abs(y1 - y2);
	}

	// Actually draws the rectangle
	public void draw(Graphics g) {
		g.setColor(color);
		if (filled == true)
			g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}

}
