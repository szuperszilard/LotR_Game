package lotr.UI.Logic;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageScaler {
	
	public static ImageIcon imageScaler(String pathToImage, double width, double height) throws IOException {
		
		BufferedImage originalImage = ImageIO.read(new File(pathToImage)); 
		Image scaledImage = originalImage.getScaledInstance(((int)Math.round(width)), ((int)Math.round(height)), Image.SCALE_SMOOTH);
		
		return new ImageIcon(scaledImage);
	}
}
