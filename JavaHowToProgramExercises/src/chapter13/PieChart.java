// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.27 page 635
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.JPanel;

public class PieChart extends JPanel {

	double[] numbers = { 20, 12, 30, 75};
	double[] angles = new double[4];

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		double sum = 0;
		for (double number : numbers) {
			sum += number;
		}

		double startAngle = 0;
		for (int i = 0; i < numbers.length; i++) {
			angles[i] = numbers[i] * ((double)360 / sum);
			Color[] colors = { Color.RED, Color.CYAN, Color.BLACK, Color.BLUE };
			g.setColor(colors[i]);

			g2d.fill(new Arc2D.Double(0, 0, getWidth(), getHeight(), startAngle, angles[i], Arc2D.PIE));
			startAngle += angles[i];
		}
	}
}
