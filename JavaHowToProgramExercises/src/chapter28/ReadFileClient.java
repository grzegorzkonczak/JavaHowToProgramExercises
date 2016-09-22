// Grzegorz Koñczak, 22.09.2016
// Exercise number 28.13 page 46 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ReadFileClient {
	
	private String fileServer;
	private Socket client;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private String message = "";

	public ReadFileClient(String host){
		fileServer = host;
	}
	
	public void runClient(){
		
		try {
			connectToServer();
			getStreams();
			processConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private void closeConnection() {
		System.out.println("Closing connection...");
		try {
			output.close();
			input.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processConnection() throws ClassNotFoundException, IOException {
		output.writeObject("D:\\test.txt");
		output.flush();
		do{
			message = (String) input.readObject();
			System.out.println(message);
		}while (!message.equals("END OF TRANSMISSION"));
	}

	private void getStreams() throws IOException {
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();
		input = new ObjectInputStream(client.getInputStream());
		System.out.println("Got IO streams");
	}

	private void connectToServer() throws IOException {
		System.out.println("Attempting connection...");
		
		client = new Socket(InetAddress.getByName(fileServer), 12345);
		
		System.out.println("Connected to " + client.getInetAddress().getHostName());
	}
}
