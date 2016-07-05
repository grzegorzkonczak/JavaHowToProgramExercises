// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.2 page 271
// Exercise from Java:How to program 10th edition

package chapter6;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.security.SecureRandom;

public class RandomShape extends JPanel{

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		SecureRandom randomNumbers = new SecureRandom();
		
		for (int i = 0; i < 10; i++){
			Color color = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));
			g.setColor(color);
			int shape = randomNumbers.nextInt(2);
			
			if (shape == 0){
				g.fillRect(randomNumbers.nextInt(getWidth()), randomNumbers.nextInt(getHeight()),
						randomNumbers.nextInt(getWidth() / 2), randomNumbers.nextInt(getHeight() / 2));
			}else{
				g.fillOval(randomNumbers.nextInt(getWidth()), randomNumbers.nextInt(getHeight()),
						randomNumbers.nextInt(getWidth() / 2), randomNumbers.nextInt(getHeight() / 2));
			}
		}
	}
}
