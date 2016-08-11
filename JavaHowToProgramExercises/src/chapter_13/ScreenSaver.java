// Grzegorz Koñczak, 07.08.2016
// Exercise number 13.18/19/20/21/22 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.security.SecureRandom;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ScreenSaver extends JPanel implements ActionListener {

	private static final SecureRandom randomNumbers = new SecureRandom();
	private Timer timer;
	private int numberOfLines = 100;

	public ScreenSaver() {
		timer = new Timer(1000, this);
		timer.start();
	}

	public void setNumberOfLines(int numberOfLines) {
		this.numberOfLines = numberOfLines;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i < numberOfLines; i++) {
			int randomShape = randomNumbers.nextInt(2);

			int xPointOne = randomNumbers.nextInt(750);
			int yPointOne = randomNumbers.nextInt(750);
			int xPointTwo = randomNumbers.nextInt(750);
			int yPointTwo = randomNumbers.nextInt(750);

			int xPointOneGradient = randomNumbers.nextInt(750);
			int yPointOneGradient = randomNumbers.nextInt(750);
			int xPointTwoGradient = randomNumbers.nextInt(750);
			int yPointTwoGradient = randomNumbers.nextInt(750);

			int red1 = randomNumbers.nextInt(255);
			int green1 = randomNumbers.nextInt(255);
			int blue1 = randomNumbers.nextInt(255);
			int red2 = randomNumbers.nextInt(255);
			int green2 = randomNumbers.nextInt(255);
			int blue2 = randomNumbers.nextInt(255);

			int cyclicGradientInt = randomNumbers.nextInt(2);
			boolean cyclicGradient;
			if (cyclicGradientInt == 0) {
				cyclicGradient = true;
			} else {
				cyclicGradient = false;
			}

			g2d.setPaint(new GradientPaint(xPointOneGradient, yPointOneGradient, new Color(red1, green1, blue1),
					xPointTwoGradient, yPointTwoGradient, new Color(red2, green2, blue2), cyclicGradient));

			if (randomShape == 0) {
				g2d.fill(new Rectangle2D.Double(Math.min(xPointOne, xPointTwo), Math.min(yPointOne, yPointTwo),
						Math.abs(xPointOne - xPointTwo), Math.abs(yPointOne - yPointTwo)));
			} else if (randomShape == 1) {
				g2d.fill(new Ellipse2D.Double(Math.min(xPointOne, xPointTwo), Math.min(yPointOne, yPointTwo),
						Math.abs(xPointOne - xPointTwo), Math.abs(yPointOne - yPointTwo)));
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

	}
}
