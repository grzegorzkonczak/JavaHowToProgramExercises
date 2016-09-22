// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.13 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFileServer {

	private ServerSocket server;
	private Socket connection;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Scanner fileScanner;
	
	public void runServer(){
		
		try {
			server = new ServerSocket(12345, 2);
			
			while(true){
				waitForConnection();
				getStreams();
				try {
					processConection();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					closeConnection();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
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
		fileScanner = new Scanner(Paths.get(path));
		while (fileScanner.hasNext()){
			output.writeObject(fileScanner.nextLine());
			output.flush();
		}
		output.writeObject("END OF TRANSMISSION");
		output.flush();
	}

	private void getStreams() throws IOException{
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
