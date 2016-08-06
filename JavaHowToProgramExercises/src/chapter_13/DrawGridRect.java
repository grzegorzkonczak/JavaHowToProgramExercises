// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.13 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawGridRect extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				g.drawRect(0 + (i * (getWidth()/10)), 0 + (j * (getHeight()/10)), getWidth()/10, getHeight()/10);
			}
		}
	}
}
