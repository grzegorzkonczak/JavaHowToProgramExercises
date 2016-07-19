// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.1 page 432
// Exercise from Java:How to program 10th edition

package chapter9;

import java.awt.Color;
import java.awt.Graphics;

public class MyLine {
	private int x1; // x-coordinate of first endpoint
	private int y1; // y-coordinate of first endpoint
	private int x2; // x-coordinate of second endpoint
	private int y2; // y-coordinate of second endpoint
	private Color color; // color of this line

	// constructor with input values
	public MyLine(int x1, int y1, int x2, int y2, Color color) {
		setX1(x1);
		setY1(y1);
		setX2(x2);
		setY2(y2);
		setColor(color);
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



	// no argument constructor
	public MyLine(){
		this(0, 0, 0, 0, Color.BLACK);
	}

	// Actually draws the line
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
} // end class MyLine