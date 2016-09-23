// Grzegorz Koñczak, 22/23.09.2016
// Exercise number 28.16 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import javax.swing.JFrame;

public class CheckersClientTest{

	public static void main(String[] args) {
		CheckersClient application; // declare client application
		
		// if no command line args
		if (args.length == 0){
			application = new CheckersClient("127.0.0.1"); // localhost
		} else {
			application = new CheckersClient(args[0]); // use args
		}
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
