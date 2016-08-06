// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.16 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;

public class Cube extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int[] xPoints = { 0, 100, 100, 0, 0, 50, 150, 100, 150, 150, 100, 0, 50, 150, 50, 50};
		int[] yPoints = { 0, 0, -100, -100, 0, -50, -50, 0, -50, -150, -100, -100, -150, -150, -150, -50};
		
		Graphics2D g2d = (Graphics2D) g;
		GeneralPath cube = new GeneralPath();
		
		
		cube.moveTo(xPoints[0], yPoints[0]);
		
		for (int i = 0; i < xPoints.length; i++){
			cube.lineTo(xPoints[i], yPoints[i]);
		}
		cube.closePath();
		g2d.translate(getWidth()/2 - 50, getHeight()/2 + 50);

		g2d.draw(cube);
	}
}
