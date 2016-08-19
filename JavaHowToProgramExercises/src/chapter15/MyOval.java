// Grzegorz Koñczak, 19.08.2016
// Exercise number 15.9 page 725
// Exercise from Java:How to program 10th edition

package chapter15;

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape {

	public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filled) {
		super(x1, y1, x2, y2, color, filled);
	}

	// no argument constructor
	public MyOval() {
		this(0, 0, 0, 0, Color.BLACK, false);
	}

	
	// Actually draws the oval
	@Override
	public void draw(Graphics g) {
		g.setColor(super.getColor());
		if (super.isFilled() == true)
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}

}
