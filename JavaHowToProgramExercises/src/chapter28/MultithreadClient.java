// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.15 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MultithreadClient extends JFrame{

	private JTextField enterField;
	private JTextArea displayArea;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String chatServer;
	private Socket client;
	
	public MultithreadClient(String host){
		super("Client");
		
		chatServer = host;
		
		enterField = new JTextField();
		enterField.setEditable(false);
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendData(e.getActionCommand());
				enterField.setText("");
			}
		});

		add(enterField, BorderLayout.NORTH);

		displayArea = new JTextArea();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);

		setSize(300, 150);
		setVisible(true);
	}
	
	public void runClient(){
		try {
			connectToServer();
			getStreams();
			processConnection();
		} catch (EOFException e) {
			displayMessage("\nClient terminated connection");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	

	private void closeConnection() {
		displayMessage("\nClosing Connection");
		setTextFieldEditable(false);
		try {
			output.close();
			input.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processConnection() throws IOException {
		setTextFieldEditable(true);
		do{
			try {
				message = (String) input.readObject();
			} catch (ClassNotFoundException e) {
				displayMessage("\nUnknown object type recived");
			}
			displayMessage("\n" + message);
		}while(!message.equals("SERVER>>> TERMINATE"));
	}

	private void getStreams() throws IOException {
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();
		
		input = new ObjectInputStream(client.getInputStream());	
	}

	private void connectToServer() throws IOException {
		displayMessage("Attempting connection\n");
		
		client = new Socket(InetAddress.getByName(chatServer), 12345);
		
		displayMessage("Connected to " + client.getInetAddress().getHostName());
	}

	protected void sendData(String message) {
		try {
			output.writeObject("CLIENT>>> " + message);
			output.flush();
			displayMessage("\nCLIENT>>> " + message);
		} catch (IOException e) {
			displayMessage("\nError writing object");
		}
		
	}

	private void displayMessage(String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				displayArea.append(messageToDisplay);
			}
		});
	}
	
	private void setTextFieldEditable(final boolean editable){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				enterField.setEditable(editable);
			}
		});
	}
}
