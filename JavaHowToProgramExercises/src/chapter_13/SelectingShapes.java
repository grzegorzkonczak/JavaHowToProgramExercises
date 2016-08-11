// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.28/29/30 page 635
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class SelectingShapes extends JPanel{

	private static final SecureRandom randomNumbers = new SecureRandom();
	private String shape = "Rectangle";
	
	Color color = Color.CYAN;
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public SelectingShapes(String shapeToDraw) {
		shape = shapeToDraw;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < 20; i++) {
			int randomX = randomNumbers.nextInt(500);
			int randomY = randomNumbers.nextInt(500);
			int randomWidth = randomNumbers.nextInt(250);
			int randomHeight = randomNumbers.nextInt(250);
			
			g.setColor(color);
			if (shape.equals("Rectangle")) {
				g.fillRect(randomX, randomY, randomWidth, randomHeight);
			} else if (shape.equals("Oval")) {
				g.fillOval(randomX, randomY, randomWidth, randomHeight);
			} 
		}
	}
}
