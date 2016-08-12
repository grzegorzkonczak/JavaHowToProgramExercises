// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.31 page 636
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class MyRectangle extends MyBoundedShape {


	public MyRectangle(int x1, int y1, int x2, int y2, Paint paint, Stroke stroke, boolean filled) {
		super(x1, y1, x2, y2, paint, stroke, filled);
	}

	// no argument constructor
	public MyRectangle() {
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke(), false);
	}

	// Actually draws the rectangle
	@Override
	public void draw(Graphics2D g) {
		g.setPaint(super.getPaint());
		g.setStroke(super.getStroke());
		if (super.isFilled() == true)
			g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}

}
