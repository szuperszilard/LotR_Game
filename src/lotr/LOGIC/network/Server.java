package lotr.Logic.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;
	
	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	public void startServer() {
		
		try {
			
			while(!serverSocket.isClosed()) {
					
				Socket socket = serverSocket.accept();
				ClientHandler clientHandler = new ClientHandler(socket);
				
				Thread thread = new Thread(clientHandler);
				thread.start();
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void closeServerSocket() {
		
		try {
			if(serverSocket != null) {
				serverSocket.close();
			}
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
