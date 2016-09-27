// Grzegorz Koñczak, 27.09.2016
// Exercise number 28.22 page 47 (online chapter)
// Exercise from Java:How to program 10th edition

package chapter28;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MorseCodeServer {
	
	private ServerSocket server;
	private ExecutorService executor;
	private ClientManager[] clients;
	
	public MorseCodeServer(){
		try {
			server = new ServerSocket(12345, 2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		clients = new ClientManager[2];
		
		executor = Executors.newFixedThreadPool(2);
	}

	public void execute() {
		
		for (int i = 0; i < 2; i++) {
			try {
				clients[i] = new ClientManager(server.accept(), i);
				executor.execute(clients[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void sendMessageToOtherClient(Integer clientId, String message) {
		if (clientId == 0){
			clients[1].messageToSend(message);
		} else {
			clients[0].messageToSend(message);
		}
	}
	
	private class ClientManager implements Runnable{
		private Socket connection; // connection to client
		private Scanner input; // input from client
		private Formatter output; // output to client
		private Integer id; // client id number
		private boolean connectionLost = false;
		
		public ClientManager(Socket socket, Integer id){
			connection = socket;
			this.id = id;
			
			try { // obtain streams from Socket
				input = new Scanner(connection.getInputStream());
				output = new Formatter(connection.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
		}

		public void messageToSend(String message) {
			output.format("%s\n", message);
			output.flush();
		}

		@Override
		public void run() {
			output.format("%d\n", id); // send client it's id
			output.flush(); // flush output
			
			Integer clientId = 0;
			String message = "";
			try {
				while (!connectionLost){
					if (input.hasNext()){
						clientId = Integer.parseInt(input.nextLine());
						message = input.nextLine();
					}
					sendMessageToOtherClient(clientId, message);
				}
			} finally {
				try {
					connection.close(); // close connection to client
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
			
		}
		
	}

}
