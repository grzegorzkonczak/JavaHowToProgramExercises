// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.25 page 635
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class TortoiseAndHareGui extends JPanel{

	private static final SecureRandom random = new SecureRandom();
	private boolean conflict;
	private int tortoisePosition;
	private int harePosition;
	private boolean gameWon;

	
	public void run(){
		tortoisePosition = 1;
		harePosition = 1;
		
		gameWon = false;
		conflict = false;
		
		while(!gameWon){
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			repaint();
			conflict = false;
			tortoisePosition += advanceTortoise();
			if(tortoisePosition < 1)
				tortoisePosition = 1;
			harePosition += advanceHare();
			if(harePosition < 1)
				harePosition = 1;
			if (tortoisePosition == harePosition){
				conflict = true;
			}
			if(tortoisePosition >= 300 || harePosition >= 300)
				gameWon = true;
			if(tortoisePosition > 300)
				tortoisePosition = 300;
			if(harePosition > 300)
				harePosition = 300;
		}
		repaint();
	}
	

	private int advanceHare() {
		int move = 1 + random.nextInt(10);
		if (move <= 2)
			return 0;
		else if (move <= 4)
			return 9;
		else if (move <= 5)
			return -10;
		else if (move <= 8)
			return 1;
		else
			return -2;
	}

	private int advanceTortoise() {
		int move = 1 + random.nextInt(10);
		if (move <= 5)
			return 3;
		else if (move <= 7)
			return -6;
		else
			return 1;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int heightTortoise = getHeight() - (int) Math.sqrt(Math.pow(getHeight() / 2, 2) - Math.pow(tortoisePosition - 150, 2));
		int heightHare = getHeight() - (int) Math.sqrt(Math.pow(getHeight() / 2, 2) - Math.pow(harePosition - 150, 2));
		
		
		
		g.setColor(Color.GREEN);
		g.fillArc(20, getHeight() / 2, getWidth() - 40, getHeight(), 0, 180);
		g.setColor(Color.BLACK);
		if(conflict && (harePosition == tortoisePosition)){
			g.drawString("OUCH!!", tortoisePosition, heightTortoise - 50);
			harePosition--;
		}
		
		if (tortoisePosition > 150){
			g.drawString("T", tortoisePosition + 5, heightTortoise);
		} else{
			g.drawString("T", tortoisePosition + 15, heightTortoise);
		}
		if (harePosition > 150){
			g.drawString("H", harePosition + 5, heightHare);
		} else{
			g.drawString("H", harePosition + 15, heightHare);
		}
		
		if (gameWon){
			g.drawString(tortoisePosition >= 300 ? "Tortoise Wins!!!" : "Hare Wins...", getWidth()/ 2 - 30, getHeight() / 2 - 50);
		}
	}
}
