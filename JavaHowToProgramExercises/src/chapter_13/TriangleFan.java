// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.9 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;

public class TriangleFan extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int[] xPoints = { 0, 0, -50 };
		int[] yPoints = { 0, 100, 100 };

		Graphics2D g2d = (Graphics2D) g;
		GeneralPath fan = new GeneralPath();

		fan.moveTo(xPoints[0], yPoints[0]);

		for (int i = 1; i < xPoints.length; i++) {
			fan.lineTo(xPoints[i], yPoints[i]);
		}
		
		fan.closePath();
		
		g2d.translate(getWidth()/2, getHeight()/2);
		
		for(int i = 0; i < 4; i++){
			g2d.rotate(Math.PI / 2);
			
			g2d.setColor(Color.BLUE);
			
			g2d.fill(fan);
		}
	}
}
