// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.15 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionHandler implements Runnable{
	
	private MultithreadServer server;
	private Socket connection;
	private int counter;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	public ConnectionHandler(MultithreadServer server, Socket connection, int counter){
		this.server = server;
		this.connection = connection;
		this.counter = counter;
	}

	@Override
	public void run() {
		try {
			try {
				getStreams();
				processConnection();
			} catch (EOFException e) {
				server.displayMessage("\nServer terminated connection");
			} finally {
				closeConnection();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public ObjectOutputStream getOutput() {
		return output;
	}

	private void getStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();

		input = new ObjectInputStream(connection.getInputStream());
	}

	private void processConnection() throws IOException {
		String message = "Connection successful";
		server.sendData(message, output);

		server.setTextFieldEditable(true);

		do {
			try {
				message = (String) input.readObject();
			} catch (ClassNotFoundException e) {
				server.displayMessage("\nUnknown object type received");
			}
			server.displayMessage("\n" + message);
		} while (!message.equals("CLIENT>>> TERMINATE"));
	}

	private void closeConnection() {
		server.displayMessage("\nTerminating connection");
		server.closeConnection(counter - 1);
		try {
			output.close();
			input.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
