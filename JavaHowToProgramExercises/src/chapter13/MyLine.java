// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.31 page 636
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;


public class MyLine extends MyShape{
	
	// constructor with input values
	public MyLine(int x1, int y1, int x2, int y2, Paint paint, Stroke stroke) {
		super(x1, y1, x2, y2, paint, stroke);
	}
	
	// no argument constructor
	public MyLine(){
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke());
	}

	// Actually draws the line
	@Override
	public void draw(Graphics2D g) {
		g.setPaint(super.getPaint());
		g.setStroke(super.getStroke());
		g.drawLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
	}
} // end class MyLine