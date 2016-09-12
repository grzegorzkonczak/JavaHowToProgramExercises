// Grzegorz Koñczak, 12.09.2016
// Exercise number 23.10/11/12 page 1085
// Exercise from Java:How to program 10th edition


package chapter23;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;

public class BouncingBallPanel extends JPanel{

	private final static SecureRandom generator = new SecureRandom();
	
	private BouncingBall[] balls = new BouncingBall[20];
	int counter = 0;
	
	public BouncingBallPanel(){
		this.setSize(400, 350);
		ExecutorService executor = Executors.newCachedThreadPool(); 
		this.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e) {
		    	if (counter < 20) {
					balls[counter] = new BouncingBall(10 + generator.nextInt(200), 10 + generator.nextInt(150),
							new Color(generator.nextInt(255), generator.nextInt(255), generator.nextInt(255)));
					executor.execute(new BallMover(balls[counter], BouncingBallPanel.this));
					counter++;
				}
		    }
		});
	}

	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (BouncingBall bouncingBall : balls) {
			if (bouncingBall != null){
				g.setColor(bouncingBall.getColor());
				g.fillOval(bouncingBall.getxLocation(), bouncingBall.getyLocation(), bouncingBall.getSize(), bouncingBall.getSize());
				g.setColor(Color.BLACK);
				g.fillOval(bouncingBall.getxLocation() + 5 , getHeight() - 10, 
						(bouncingBall.getyLocation() / bouncingBall.getSize()) * 2, 
						(bouncingBall.getyLocation() / bouncingBall.getSize()));
			}
		}
	}



	
	
}

