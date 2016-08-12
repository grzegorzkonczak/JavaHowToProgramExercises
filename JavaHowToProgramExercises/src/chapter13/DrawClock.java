// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.8 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawClock extends JPanel{

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawArc(getWidth()/2 - 50, getHeight()/2 - 50 , 100, 100, 0, 360);
		g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight()/2 - 40);
		g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2 + 30, getHeight()/2);
	}
	
}
