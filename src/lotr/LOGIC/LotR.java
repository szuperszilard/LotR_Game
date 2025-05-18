package lotr.Logic;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

import lotr.DataConstructs.User;
import lotr.UI.Frame_MainWindow;
import lotr.UI.Panel_Login;
import lotr.UI.Panel_MenuContainer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;


public class LotR {

	private Frame_MainWindow frame;
	private Rectangle baseSizeOfWindow = new Rectangle(1920,1032); 
	private DB_Handler dbHandler = new DB_Handler();

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
	        frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {				
					if(JOptionPane.showOptionDialog(frame, "Sure you wanna exit?", "Exit", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {					
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
	      
	        frame.getmmPanel().add(menuContainerPanel);    
	        frame.getmmPanel().add(loginPanel);
	              
	        loginPanel.setICommunication(new ICommunication() {
				@Override
				public void somethingHappened(String message) {
					
					if(message.equals("login")) {					
						menuContainerPanel.setVisible(true);
					}				
				}
			});	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Failed to connect to server.", "Failed", JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
		}
		
        
        
        
        
        
        
        
        
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
