// Grzegorz Koñczak, 12.09.2016
// Exercise number 23.10/11/12 page 1085
// Exercise from Java:How to program 10th edition

package chapter23;

public class BallMover implements Runnable {

	private int X_MOVEMENT = 3;
	private int Y_MOVEMENT = 10;
	private BouncingBall ball;
	private BouncingBallPanel panel;

	
	public BallMover(BouncingBall ball, BouncingBallPanel panel) {
		this.ball = ball;
		this.panel = panel;
	}

	
	@Override
	public void run() {
		while (true) {
			if (ball.getyLocation() >= panel.getHeight() - ball.getSize() ||
					ball.getyLocation() <= 0) {
				Y_MOVEMENT = - Y_MOVEMENT;
			}
			if (ball.getxLocation() >= panel.getWidth() - ball.getSize()||
					ball.getxLocation() <= 0){
				X_MOVEMENT = - X_MOVEMENT;
			}
			ball.setxLocation(ball.getxLocation() + X_MOVEMENT);
			ball.setyLocation(ball.getyLocation() + Y_MOVEMENT);
			ball.setSize(ball.getyLocation() / 20 + 15);
			panel.repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
