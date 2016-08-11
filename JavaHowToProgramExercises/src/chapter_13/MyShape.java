// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.31 page 636
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public abstract class MyShape {

	private int x1; // x-coordinate of first endpoint
	private int y1; // y-coordinate of first endpoint
	private int x2; // x-coordinate of second endpoint
	private int y2; // y-coordinate of second endpoint
	private Paint paint; // color of this shape
	private Stroke stroke;

	public MyShape(int x1, int y1, int x2, int y2, Paint paint, Stroke stroke) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.paint = paint;
		this.stroke = stroke;
	}

	public MyShape() {
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke());
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}
	
	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public abstract void draw(Graphics2D g);	

}
