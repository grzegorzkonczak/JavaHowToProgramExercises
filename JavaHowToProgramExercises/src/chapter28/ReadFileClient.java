// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.13/14 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ReadFileClient extends JFrame {

	private String fileServer;
	private Socket client;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private String message = "";
	private JTextArea textArea;
	private JButton saveButton;
	private JTextField pathArea;
	private JButton getFileButton;
	private JPanel northPanel;

	public ReadFileClient(String host) {
		super("Client");
		fileServer = host;

		textArea = new JTextArea();
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		saveButton = new JButton("Save Changes");
		add(saveButton, BorderLayout.SOUTH);
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String editetText = textArea.getText();
				try {
					output.writeObject(editetText);
					output.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		pathArea = new JTextField(15);
		getFileButton = new JButton("Get File");
		northPanel = new JPanel();
		northPanel.add(pathArea);
		northPanel.add(getFileButton);
		add(northPanel, BorderLayout.NORTH);

		getFileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					output.writeObject(pathArea.getText());
					output.flush();
					processConnection();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		setSize(500, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				closeConnection();
				System.exit(0);
			}
		});
	}

	public void runClient() {

		try {
			connectToServer();
			getStreams();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void closeConnection() {
		try {
			output.close();
			input.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processConnection() throws ClassNotFoundException, IOException {
		clearTextArea();
		while (!message.equals("END OF TRANSMISSION")) {
			message = (String) input.readObject();
			displayMessage(message);
		}
	}

	private void clearTextArea() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				textArea.setText("");
			}
		});

	}

	private void getStreams() throws IOException {
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();
		input = new ObjectInputStream(client.getInputStream());
		displayMessage("Got IO streams");
	}

	private void connectToServer() throws IOException {
		displayMessage("Attempting connection...");

		client = new Socket(InetAddress.getByName(fileServer), 12345);

		displayMessage("Connected to " + client.getInetAddress().getHostName());
	}

	private void displayMessage(String message) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				textArea.append(message + "\n");
			}
		});

	}
}
