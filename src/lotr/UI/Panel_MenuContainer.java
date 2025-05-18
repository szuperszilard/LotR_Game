package lotr.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel_MenuContainer extends JPanel{
	
	
	public Panel_MenuContainer(JFrame frame) throws IOException {
		
		setLayout(null);
		setBounds(60,0,350,500);
		setOpaque(false);
		setVisible(true);
		
		Button_WithIcon playButton = new Button_WithIcon(
        		"D:\\Eclipse\\LotRGame\\data\\play1.png",
        		"D:\\Eclipse\\LotRGame\\data\\play3.png", 
        		"D:\\Eclipse\\LotRGame\\data\\play2.png",
        		0.34, 300, 0, 70);
        
        playButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		setVisible(false);
        	}
        });
        
        Button_WithIcon statsButton = new Button_WithIcon(
        		"D:\\Eclipse\\LotRGame\\data\\stats1.png",
        		"D:\\Eclipse\\LotRGame\\data\\stats3.png", 
        		"D:\\Eclipse\\LotRGame\\data\\stats2.png",
        		0.34, 300, 0,200);
        
        statsButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        
        Button_WithIcon exitButton = new Button_WithIcon(
        		"D:\\Eclipse\\LotRGame\\data\\exit1.png",
        		"D:\\Eclipse\\LotRGame\\data\\exit3.png", 
        		"D:\\Eclipse\\LotRGame\\data\\exit2.png",
        		0.34, 300, 0, 330);
        
        exitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        	}
        });
        
        add(playButton);
        add(statsButton);
        add(exitButton);
        playButton.setVisible(true);
        statsButton.setVisible(true);
        exitButton.setVisible(true);
        setVisible(false);
	}
	

}
