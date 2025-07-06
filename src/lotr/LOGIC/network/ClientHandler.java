package lotr.Logic.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

	public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	private String clientUsername;
	
	public ClientHandler(Socket socket) {
		
		try {
			this.socket = socket;
			this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.clientUsername = br.readLine();
			clientHandlers.add(this);
			
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		
		String message;
		
		while(socket.isConnected()) {
			try {
				message = br.readLine();
				sendToAll(message);
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public void sendToAll(String message) {
		
		for(ClientHandler ch : clientHandlers) {
			try {
				ch.bw.write(message);
				ch.bw.newLine();
				ch.bw.flush();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}
