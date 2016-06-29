// Grzegorz Koñczak, 29.06.2016
// Exercise number 4.1 page 180
// Exercise from Java:How to program 10th edition

package chapter4;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawLines extends JPanel{

	// Draws specific pattern of lines coming from single point in top-left corner
	public void paintComponent(Graphics g){
		
		// call paintComponent to ensure panel displays correctly
		super.paintComponent(g);
		
		int width = 0; // starting width
		int height = getHeight(); // total height
		int wstep = getWidth() / 15; // one step of width
		int hstep = height / 15; // one step of height
		
		// Loop drawing specific pattern of lines
		while (height >= 0){
			g.drawLine(0, 0, width, height);
			g.drawLine(getWidth(), 0, getWidth() - width, height);
			g.drawLine(0, getHeight(),getWidth() - width, height);
			g.drawLine(getWidth(), getHeight(), width, height);
			width = width + wstep;
			height = height - hstep;
		}
	}
}
