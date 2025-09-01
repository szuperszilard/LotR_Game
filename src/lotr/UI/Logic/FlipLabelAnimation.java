package lotr.UI.Logic;

import java.awt.Image;
import java.io.IOException;

import javax.swing.Timer;

import lotr.UI.inGame.Label_Clickable;
import lotr.UI.inGame.Panel_CardHolder;


public class FlipLabelAnimation{

	private Timer timer;
	private Image displayedImage;
	private int originalWidthOfImage = (int)Math.round(Panel_CardHolder.cardWidth);;
	private int currentWidthOfImage = (int)Math.round(Panel_CardHolder.cardWidth);
	private int directionOfImageAnimation = -1;
	private int flipCounter = 0;
	private String pathToDisplayedImage;

	public void flip(Label_Clickable label) throws IOException {
		pathToDisplayedImage = label.getCardOfLabel().getPathToCover();
		timer = new Timer(15, e -> {
			if(flipCounter<2) {
			updateImage(label);
			label.repaint();
			if (flipCounter >= 2) {
                timer.stop();
            }
			}});
		timer.start();
	}
	public void updateImage(Label_Clickable label) {
		
		if((currentWidthOfImage + directionOfImageAnimation*20) > originalWidthOfImage || (currentWidthOfImage + directionOfImageAnimation*20) <= 0) {		
			directionOfImageAnimation*=-1;
		}
		currentWidthOfImage = currentWidthOfImage + directionOfImageAnimation*20;
		if((currentWidthOfImage + directionOfImageAnimation*20) > originalWidthOfImage || (currentWidthOfImage + directionOfImageAnimation*20) <= 0) {
			if(pathToDisplayedImage == label.getCardOfLabel().getPathToPicture()) {			
				if (flipCounter<1) {
					pathToDisplayedImage = label.getCardOfLabel().getPathToCover();					
				}
				flipCounter++;
			}else{
				if (flipCounter<1) {
					pathToDisplayedImage = label.getCardOfLabel().getPathToPicture();					
				}
				flipCounter++;
			}
		}
		
		try {
			displayedImage = ImageScaler.imageScaler(pathToDisplayedImage, currentWidthOfImage, (int)Math.round(Panel_CardHolder.cardHeight)).getImage();
			label.setCurrentImage(displayedImage);
			label.setWidthOfImageCurrent(currentWidthOfImage);
			
		} catch (IOException e) {
			System.out.println("couldnt scale image for label_clickable");
		}	
	}	
}
