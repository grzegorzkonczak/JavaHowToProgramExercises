// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.6 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ConcentricCirclesDrawArc extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < 8; i++){
			g.drawArc(getWidth()/2 - (5 * (i + 1)), getHeight()/2 - (5 * (i + 1)), 10 * (i+1), 10 * (i+1), 0, 360);
		}
	}
}
