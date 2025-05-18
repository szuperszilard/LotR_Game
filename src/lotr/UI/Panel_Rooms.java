package lotr.UI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel_Rooms extends JPanel {
	
	private Image backgroundImage;
	
	public Panel_Rooms() throws IOException {
		
		
		backgroundImage = ImageIO.read(new File("D:\\Eclipse\\LotRGame\\data\\roomsContainer_big.png"));	
		setBounds(673,374,600,400);
		setLayout(null);
		setOpaque(false);
		
		
	}
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, 600, 400, this);
        }
	}

}
