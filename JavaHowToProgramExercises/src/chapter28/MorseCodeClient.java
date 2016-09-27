// Grzegorz Koñczak, 27.09.2016
// Exercise number 28.22 page 47 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MorseCodeClient extends JFrame implements Runnable {
	private JTextField messageField; // text field for client input
	private JTextArea displayArea; // text area for to display messages from
									// other client
	private Socket connection; // connection to server
	private Scanner input; // input from server
	private Formatter output; // output to server
	private String host; // host name for host
	private Integer myId; // id number of this client
	// array of English letters
	private String[] englishLetters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	// array of corresponding morse codes
	private String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--.." };

	public MorseCodeClient(String host) {
		this.host = host;
		displayArea = new JTextArea(); // set up JTextArea
		displayArea.setEditable(false);
		displayArea.setLineWrap(true);
		displayArea.setWrapStyleWord(true);
		add(new JScrollPane(displayArea), BorderLayout.CENTER);

		messageField = new JTextField(); // set up text field
		add(messageField, BorderLayout.NORTH);
		messageField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendData(e.getActionCommand());
				messageField.setText("");
			}
		});

		setSize(400, 400); // set size of window
		setVisible(true); // show window

		// start client
		startClient();
	}

	protected void sendData(String messageToEncode) {
		String message = encode(messageToEncode);
		output.format("%d\n", myId);
		output.format(message + "\n");
		output.flush();

	}

	private void displayMessage(String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				displayArea.append(messageToDisplay);
			}
		});
	}

	private void startClient() {
		try {
			// make connection to server
			connection = new Socket(InetAddress.getByName(host), 12345);

			// get streams for input and output
			input = new Scanner(connection.getInputStream());
			output = new Formatter(connection.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create and start worker thread for this client
		ExecutorService worker = Executors.newFixedThreadPool(1);
		worker.execute(this); // execute client

	}

	// control thread that allows continuous update of displayArea
	@Override
	public void run() {
		myId = Integer.parseInt(input.nextLine()); // get player's id

		// receive messages sent to client and output them
		while (true) {
			if (input.hasNextLine()) {
				processMessage(input.nextLine());
			}
		}
	}

	private void processMessage(String messageToDecode) {
		String message = decode(messageToDecode);
		displayMessage(message + "\n");
		displayMessage(messageToDecode + "\n");
	}

	// decode message from morse code to English words
	private String decode(String messageToDecode) {
		StringBuilder builder = new StringBuilder();
		String[] words = messageToDecode.split("   ");
		for (String word : words) {
			String[] lettersToDecode = word.split(" ");
			for (String letterToDecode : lettersToDecode) {
				for (int i = 0; i < morseCodes.length; i++) {
					if (morseCodes[i].equals(letterToDecode)) {
						builder.append(englishLetters[i]);
					}
				}
			}
			builder.append(" ");
		}
		return builder.toString();
	}

	// encode message from English letters to morse code
	private String encode(String messageToEncode) {
		StringBuilder builder = new StringBuilder();
		String[] words = messageToEncode.split(" ");
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				String letterToEncode = word.substring(i, i + 1);
				for (int j = 0; j < englishLetters.length; j++) {
					if (englishLetters[j].equalsIgnoreCase(letterToEncode)) {
						builder.append(morseCodes[j]);
					}
				}
				builder.append(" ");
			}
			builder.append("   ");
		}
		return builder.toString();
	}
}
