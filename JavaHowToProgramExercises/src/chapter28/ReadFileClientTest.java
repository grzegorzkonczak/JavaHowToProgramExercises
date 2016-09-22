// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.13/14 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import javax.swing.JFrame;

public class ReadFileClientTest {

	public static void main(String[] args) {
		ReadFileClient application;
		
		if (args.length == 0){
			application = new ReadFileClient("localhost");
		} else {
			application = new ReadFileClient(args[0]);
		}
		
		application.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		application.runClient();
	}
}
