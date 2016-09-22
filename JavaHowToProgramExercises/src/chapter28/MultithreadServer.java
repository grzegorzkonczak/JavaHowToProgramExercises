// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.15 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MultithreadServer extends JFrame{

	private JTextField enterField;
	private JTextArea displayArea;
	private ServerSocket server;
	private Socket connection;
	private int counter = 1;
	private ExecutorService serverExecutor;
	private ArrayList<ConnectionHandler> connections;
	private ConnectionHandler handler;

	public MultithreadServer() {
		super("Server");
		connections = new ArrayList<>();

		enterField = new JTextField();
		enterField.setEditable(false);
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (ConnectionHandler handler : connections) {
					sendData(e.getActionCommand(), handler.getOutput());
				}
				displayMessage("\nSERVER>>> " + e.getActionCommand());
				enterField.setText("");
			}
		});

		add(enterField, BorderLayout.NORTH);

		displayArea = new JTextArea();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);

		setSize(300, 150);
		setVisible(true);
	}

	public void runServer() {

		serverExecutor = Executors.newCachedThreadPool();

		try {
			server = new ServerSocket(12345, 100);
			try {
				while (true) {
					waitForConnection();
				}
			} catch (EOFException e) {
				displayMessage("\nServer terminated connection");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void waitForConnection() throws IOException {
		displayMessage("Waiting for connection\n");
		connection = server.accept();
		handler = new ConnectionHandler(this, connection, counter);
		connections.add(handler);
		displayMessage("Connection " + counter + " received from " + connection.getInetAddress().getHostName());
		serverExecutor.execute(handler);
		counter++;
	}

	

	public void sendData(String message, ObjectOutputStream output) {
		try {
			output.writeObject("SERVER>>> " + message);
			output.flush();
		} catch (IOException e) {
			displayArea.append("\nError writing object");
		}
	}

	public void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				displayArea.append(messageToDisplay);

			}
		});
	}

	public void setTextFieldEditable(final boolean editable) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				enterField.setEditable(editable);
			}
		});
	}

	public void closeConnection(int connectionToDelete) {
		connections.remove(connectionToDelete);
		if (connections.isEmpty()){
			setTextFieldEditable(false);
		} else {
			for (int i = 0; i < connections.size(); i++) {
				connections.get(i).setCounter(i + 1);
			}
		}
		counter--;
	}

}
