// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.13/14 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class ReadFileServer {

	private ServerSocket server;
	private Socket connection;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Scanner fileScanner;
	private Formatter outFormatter;

	public void runServer() {

		try {
			server = new ServerSocket(12345, 1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		while (true) {
			try {
				waitForConnection();
				getStreams();
				processConection();
			} catch (EOFException eofe){
				System.out.println("Client terminated connection...");
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
	}

	private void closeConnection() {
		System.out.println("Terminating connection...");
		try {
			output.close();
			input.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void processConection() throws ClassNotFoundException, IOException {
		String path = (String) input.readObject();
		try {
			fileScanner = new Scanner(Paths.get(path));
			while (fileScanner.hasNext()) {
				output.writeObject(fileScanner.nextLine());
				output.flush();
			}
			output.writeObject("END OF TRANSMISSION");
			output.flush();
			fileScanner.close();
			String newText = (String) input.readObject();
			outFormatter = new Formatter(path);
			outFormatter.format(newText);
			outFormatter.close();
		} catch (NoSuchFileException e) {
			output.writeObject("FILE NOT FOUND");
			output.flush();
			output.writeObject("END OF TRANSMISSION");
			output.flush();
		}
	}

	private void getStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		System.out.println("Got IO streams");
	}

	private void waitForConnection() throws IOException {
		System.out.println("Waiting for connection...");
		connection = server.accept();
		System.out.println("Connection received from " + connection.getInetAddress().getHostName());
	}
}
