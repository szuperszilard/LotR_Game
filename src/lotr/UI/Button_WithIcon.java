package lotr.UI;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button_WithIcon extends JButton {

	public Button_WithIcon(String buttonPNG, String pressedPNG, String hoverPNG, double ratioHeightWidth, int width, int x, int y) throws IOException {

		setBounds(x,y,width, (int) Math.round(width*ratioHeightWidth));
		ImageIcon icon = imageScaler(buttonPNG, width, (int) Math.round(width*ratioHeightWidth));
		ImageIcon pressedIcon = imageScaler(pressedPNG, width, (int) Math.round(width*ratioHeightWidth));
		ImageIcon hoverIcon = imageScaler(hoverPNG, width, (int) Math.round(width*ratioHeightWidth));
		setRolloverEnabled(true);
		setIcon(icon);
		setRolloverIcon(hoverIcon);
		setPressedIcon(pressedIcon);
		setOpaque(false);
	    setContentAreaFilled(false);
	    setBorderPainted(false);
	    setFocusPainted(false);	
	}

	public ImageIcon imageScaler(String pathToImage, int width, int height) throws IOException {
		
		BufferedImage originalImage = ImageIO.read(new File(pathToImage)); 
		Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		return new ImageIcon(scaledImage);
	}
	
}
