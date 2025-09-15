package lotr.Logic;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lotr.DataConstructs.User;
import lotr.Logic.network.DB_Handler;
import lotr.UI.Frame_MainWindow;
import lotr.UI.Panel_Fading;
import lotr.UI.Panel_Login;
import lotr.UI.Panel_MenuContainer;
import lotr.UI.Panel_Room;
import lotr.UI.inGame.Panel_GAME;
import lotr.UI.Panel_Lobby;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;


public class LotR {

	private Frame_MainWindow frame;
	private final DB_Handler dbHandler = new DB_Handler();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LotR window = new LotR();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LotR() throws IOException {
		initialize();
	}
	
	private void initialize() throws IOException {
		
		try {
			
			dbHandler.connect();
		
			frame = new Frame_MainWindow(dbHandler);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {				
					if(JOptionPane.showOptionDialog(frame, "Sure you wanna exit?", "Exit", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {					
						try {							
							if(User.getInstance().isOnline()) {
								dbHandler.logout(User.getInstance());
							}
							dbHandler.disconnect();							
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(frame, e1.getMessage(), "Failed", JOptionPane.ERROR_MESSAGE);
						}
						System.exit(0);
					}					
				}
			});
	     
	        Panel_MenuContainer menuContainerPanel = new Panel_MenuContainer(frame);
	        Panel_Login loginPanel = new Panel_Login(frame, this);
	        Panel_Lobby lobbyPanel = new Panel_Lobby();
	        Panel_Room roomPanel = new Panel_Room();
	        Panel_Fading fadingPanel = new Panel_Fading(frame);
	        Panel_GAME gamePanel = new Panel_GAME();
	      
	        frame.getmmPanel().add(menuContainerPanel);    
	        //frame.getmmPanel().add(loginPanel);
	        frame.getmmPanel().add(lobbyPanel);
	        frame.getmmPanel().add(roomPanel);
	        frame.getmmPanel().add(fadingPanel);
	        frame.getmmPanel().add(gamePanel);
	        //TEMPORARY
	        
	        menuContainerPanel.setVisible(true);
	              
	        loginPanel.setICommunication(new ICommunication() {
				@Override
				public void somethingHappened(String message) {				
					if(message.equals("login")) {					
						menuContainerPanel.setVisible(true);
					}				
				}
			});	
	        menuContainerPanel.setICommunication(new ICommunication() {
				@Override
				public void somethingHappened(String message) {				
					if(message.equals("play")) {															
						lobbyPanel.setVisible(true);							
					}else if(message.equals("back")){
						lobbyPanel.setVisible(false);
					}
				}
			});	
	        lobbyPanel.setICommunication(new ICommunication() {				
				@Override
				public void somethingHappened(String message) {					
					if(message.equals("new game")) {
						lobbyPanel.setVisible(false);
						roomPanel.setVisible(true);
					}				
				}
			});
	        roomPanel.setICommunication(new ICommunication() {				
				@Override
				public void somethingHappened(String message) {					
					if(message.equals("backToLobby")) {
						lobbyPanel.setVisible(true);
						roomPanel.setVisible(false);
					}
					if(message.equals("start")) {
						fadingPanel.startFade();
						roomPanel.setVisible(false);
						lobbyPanel.setVisible(false);
						menuContainerPanel.setVisible(false);						
					}					
				}
			});
	        fadingPanel.setICommunication(new ICommunication() {
				@Override
				public void somethingHappened(String message) {					
					if(message.equals("gamePanel")) {
						gamePanel.setVisible(true);
					}					
				}
			});
	        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Failed to connect to server.", "Failed", JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
		}          
	}
}
