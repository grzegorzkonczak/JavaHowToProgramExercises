// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.15 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;

public class Tetrahedron extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int[] xPoints = { -50, 50, 0, -50, 0, 50, 0, 0};
		int[] yPoints = { 30, 30, -60, 30, 0, 30, -60, 0};
		
		Graphics2D g2d = (Graphics2D) g;
		GeneralPath tetrahedron = new GeneralPath();
		
		
		tetrahedron.moveTo(xPoints[0], yPoints[0]);
		
		for (int i = 0; i < xPoints.length; i++){
			tetrahedron.lineTo(xPoints[i], yPoints[i]);
		}
		tetrahedron.closePath();
		g2d.translate(getWidth()/2, getHeight()/2);

		g2d.draw(tetrahedron);
	}
}
