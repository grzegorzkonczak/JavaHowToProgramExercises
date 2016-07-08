// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.1 page 335
// Exercise from Java:How to program 10th edition

package chapter7;

import java.awt.Graphics;
import javax.swing.JPanel;

public class SpriralSquare extends JPanel {
	
	public void paintComponent(Graphics g){
		
		int startingX = getWidth() / 2;
		int startingY = getHeight() / 2;
		int startingLength = 10;
		
		for(int i = 1; i < 20; i++){
			int movement = startingLength * (i * 2);
			if(i % 2 != 0){
				g.drawLine(startingX, startingY, startingX, startingY + movement);
				startingY = startingY + movement;
				g.drawLine(startingX, startingY, startingX - movement, startingY);
				startingX = startingX - movement;
			}else{
				g.drawLine(startingX, startingY, startingX, startingY - movement);
				startingY = startingY - movement;
				g.drawLine(startingX, startingY, startingX + movement, startingY);
				startingX = startingX + movement;
			}
		}
	}

}
