package lotr.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lotr.Logic.ICommunication;

public class Panel_MenuContainer extends JPanel{
	
	private ICommunication comms;
	private Button_WithIcon backButton;
	private Button_WithIcon exitButton;
	private Button_WithIcon statsButton; 
	private Button_WithIcon playButton;
	
	public Panel_MenuContainer(JFrame frame) throws IOException {
		
		setLayout(null);
		setBounds(60,0,350,500);
		setOpaque(false);
		setVisible(true);
		
		playButton = new Button_WithIcon(
        		"D:\\Eclipse\\LotRGame\\data\\play1.png",
        		"D:\\Eclipse\\LotRGame\\data\\play3.png", 
        		"D:\\Eclipse\\LotRGame\\data\\play2.png",
        		0.34, 300, 0, 70);
        
        playButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		    
        		comms.somethingHappened("play");
        		playButton.setVisible(false);
        		exitButton.setVisible(false);
        		statsButton.setVisible(false);
        		backButton.setVisible(true);        		
        	}
        });
        
       statsButton = new Button_WithIcon(
        		"D:\\Eclipse\\LotRGame\\data\\stats1.png",
        		"D:\\Eclipse\\LotRGame\\data\\stats3.png", 
        		"D:\\Eclipse\\LotRGame\\data\\stats2.png",
        		0.34, 300, 0,200);
        
        statsButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        
       exitButton = new Button_WithIcon(
        		"D:\\Eclipse\\LotRGame\\data\\exit1.png",
        		"D:\\Eclipse\\LotRGame\\data\\exit3.png", 
        		"D:\\Eclipse\\LotRGame\\data\\exit2.png",
        		0.34, 300, 0, 330);
        
        exitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        	}
        });
        
        backButton = new Button_WithIcon(
        		"D:\\Eclipse\\LotRGame\\data\\back1.png",
        		"D:\\Eclipse\\LotRGame\\data\\back3.png", 
        		"D:\\Eclipse\\LotRGame\\data\\back2.png",
        		0.34, 300, 0, 330);
        
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		playButton.setVisible(true);
        		exitButton.setVisible(true);
        		statsButton.setVisible(true);
        		backButton.setVisible(false);
        		comms.somethingHappened("back");
        	}
        });
        
        add(playButton);
        add(statsButton);
        add(exitButton);
        add(backButton);
        playButton.setVisible(true);
        statsButton.setVisible(true);
        exitButton.setVisible(true);
        backButton.setVisible(false);
        setVisible(false);
        
	}
	 public void setICommunication(ICommunication comms) {
	    	this.comms = comms;
	    }

}
