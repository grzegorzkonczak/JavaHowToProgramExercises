// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.1 page 476
// Exercise from Java:How to program 10th edition

package chapter10;

import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape{
	
	// constructor with input values
	public MyLine(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
	}
	
	// no argument constructor
	public MyLine(){
		this(0, 0, 0, 0, Color.BLACK);
	}

	// Actually draws the line
	@Override
	public void draw(Graphics g) {
		g.setColor(super.getColor());
		g.drawLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
	}
} // end class MyLine