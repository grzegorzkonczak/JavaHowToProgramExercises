// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.1 page 271
// Exercise from Java:How to program 10th edition

package chapter6;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.security.SecureRandom;

public class BullsEye extends JPanel{
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		SecureRandom randomNumbers = new SecureRandom();
		Color color1 = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));
		Color color2 = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));
		
		for (int i = 0; i < 5; i++){
			if (i % 2 == 0){
				g.setColor(color1);
			}else{
				g.setColor(color2);
			}
			g.fillOval((0 + (i * ((getWidth() /  5) / 2))), (0 + (i * ((getWidth() /  5) / 2))),
					getWidth() - (i * (getWidth() /  5)), getHeight() - (i * getHeight() /  5));
		}
	}
}
