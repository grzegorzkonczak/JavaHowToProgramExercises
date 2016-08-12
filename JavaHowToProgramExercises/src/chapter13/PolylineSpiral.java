// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.26 page 635
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PolylineSpiral extends JPanel {

	int[] xPoints = {30, 20, 0, -20, -30, -10, 20, 50, 60, 40, 0, -40, -60, -30, 20, 70, 100, 60, -10};
	int[] yPoints = {0, 20, 30, 20, 0, -30, -40, -30, 0, 40, 60, 40, 0, -50, -80, -50, 0, 60, 100};

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.translate(getWidth() / 2, getHeight() / 2);
		g.drawPolyline(xPoints, yPoints, 19);
	}
}
