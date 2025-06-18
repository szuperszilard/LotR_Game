package lotr.Logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

	public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	private String clientUsername;
	
	public ClientHandler(Socket socket) {
		
		
	}
	
	@Override
	public void run() {
		
		
		
	}
}
