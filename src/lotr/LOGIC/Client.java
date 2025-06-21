package lotr.Logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import lotr.DataConstructs.User;

public class Client {

	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	private String username;
	
	public Client(Socket socket, User user) {
		
		try {
			this.socket = socket;
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.username = user.getUsername();
		}catch(IOException e){
			closeAll(socket, br, bw);
		}
		
	}
	
	public void send(String message) {
		
		try {
			
			bw.write(username);
			bw.newLine();
			bw.flush();
			
			while
		}
		
	}
	
}
