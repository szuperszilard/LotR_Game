package lotr.UI;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lotr.Logic.network.DB_Handler;


public class Frame_MainWindow extends JFrame{

	private JPanel mmPanel;
	
	public JPanel getmmPanel() {
		return mmPanel;
	}

	public Frame_MainWindow(DB_Handler dbHandler) throws IOException {
		
		ImageIcon iconOfWindow = new ImageIcon("D:\\Eclipse\\LotRGame\\data\\icon.png");
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Rectangle usableScreenArea = ge.getMaximumWindowBounds();
	    
		setTitle("Lord of the Rings: Duel for Middle-Earth");
		setIconImage(iconOfWindow.getImage());
		setBounds(usableScreenArea);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		mmPanel = new JPanel() {
			
            private BufferedImage backgroundImage = ImageIO.read(new File("D:\\Eclipse\\LotRGame\\data\\wp.jpg"));
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, 
                    		(int)usableScreenArea.getWidth(), 
                    		(int) usableScreenArea.getHeight()-30, this);
                }
            }
        };
       
        getContentPane().add(mmPanel);
        mmPanel.setLayout(null);
        mmPanel.setBounds(usableScreenArea);
	}
	
	

}
