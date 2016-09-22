// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.16 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.net.Socket;

public class Player implements Runnable {
	
	private boolean suspended = true; // weather tread is suspended

	public Player(Socket accept, int i) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	// set weather or not thread is suspended
	public void setSuspended(boolean status) {
		suspended = status;
	}

}
