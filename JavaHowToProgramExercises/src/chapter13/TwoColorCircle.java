// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.12 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class TwoColorCircle extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		BufferedImage buffImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D gg = buffImage.createGraphics();
		gg.setColor(Color.RED);
		gg.fillRect(0, 0, 100, 50);
		gg.setColor(Color.BLUE);
		gg.fillRect(0, 50, 100, 50);
		
		g2d.setPaint(new TexturePaint(buffImage, new Rectangle(100, 100)));
		g2d.fill(new Ellipse2D.Double(0, 0, 100, 100));
	}
}
