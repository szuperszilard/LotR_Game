package lotr.UI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import lotr.Logic.ICommunication;

public class Panel_Rooms extends JPanel {
	
	private BufferedImage backgroundImage;
	
	
	public Panel_Rooms() throws IOException {
		
		
		backgroundImage = ImageIO.read(new File("D:\\Eclipse\\LotRGame\\data\\roomsContainer_big.png"));	
		setBounds(486,94,1360,820);
		setLayout(null);
		setOpaque(false);
		setVisible(false);
		
	}
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, 1360,820, this);
        }
	}

}
