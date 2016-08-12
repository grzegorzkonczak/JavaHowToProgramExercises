// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.7 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class ConcentricCirclesEllipse2D extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		for (int i = 0; i < 8; i++){
			g2d.draw(new Ellipse2D.Double(getWidth()/2 - (5 * (i + 1)), getHeight()/2 - (5 * (i + 1)), 10 * (i+1), 10 * (i+1)));
		}
				
	}
}
