// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.1 page 335
// Exercise from Java:How to program 10th edition

package chapter7;

import java.awt.Graphics;
import javax.swing.JPanel;

public class ArcSpiral extends JPanel{

public void paintComponent(Graphics g){
		
		int startingX = getWidth() / 2;
		int startingY = getHeight() / 2;
		int startingLength = 25;
		
		for(int i = 1; i < 20; i++){
			int movement = startingLength * i;
			if(i % 2 != 0){
				g.drawArc(startingX, startingY, startingLength + movement, startingLength + movement,180, -180);
				startingX = startingX - movement / i;
				startingY = startingY - movement / (i * 2);
			}else{
				g.drawArc(startingX, startingY, startingLength + movement, startingLength + movement, 0, -180);
				startingY = startingY - movement / (i * 2);
			}
		}
	}
}
