// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.1 page 231
// Exercise from Java:How to program 10th edition

package chapter5;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Circles extends JPanel{
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		// Starting coordinates
		int dimension = 20;
		int coordinateX = (getWidth() / 2) - (dimension / 2);
		int coordinateY = (getHeight() / 2) - (dimension / 2);
		
		for (int i = 0; i < 10; i++){
			g.drawOval(coordinateX - (i * (dimension / 2)), coordinateY - (i * (dimension / 2)),
					dimension + (i * dimension), dimension + (i * dimension));
		}
	}
}
