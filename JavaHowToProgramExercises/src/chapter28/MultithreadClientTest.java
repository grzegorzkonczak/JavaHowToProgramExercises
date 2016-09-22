// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.15 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import javax.swing.JFrame;

public class MultithreadClientTest {

	public static void main(String[] args) {
		MultithreadClient application;
		
		if (args.length == 0){
			application = new MultithreadClient("127.0.0.1");
		} else {
			application = new MultithreadClient(args[0]);
		}
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runClient();
	}
}
