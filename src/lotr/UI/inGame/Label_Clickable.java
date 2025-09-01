package lotr.UI.inGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JLabel;

import lotr.DataConstructs.Card;
import lotr.UI.Logic.FlipLabelAnimation;
import lotr.UI.Logic.ImageScaler;
import lotr.UI.Logic.Label_Clickable_FlipShouldOccurChecker;
import lotr.UI.Logic.Label_Clickable_OverlapCheck;
import lotr.UI.Logic.CardHolder.CardHolderLogic;

public class Label_Clickable extends JLabel implements MouseListener{

	private int cardIdentifierNumber;
	private Card cardOfLabel;
	private Image displayedImage;
	private int originalWidthOfImage;
	private int currentWidthOfImage;
	private FlipLabelAnimation animation;
		
	public Label_Clickable(Card cardOfLabel, boolean cover, int cardIdentifierNumber) throws IOException {
		setPreferredSize(new Dimension ((int)Math.round(Panel_CardHolder.cardWidth),(int)Math.round(Panel_CardHolder.cardHeight)));
		setVisible(true);
		setOpaque(false);
		String pathToCurrentImage = (!cover)?cardOfLabel.getPathToPicture():cardOfLabel.getPathToCover();
		displayedImage = ImageScaler.imageScaler(pathToCurrentImage, getPreferredSize().getWidth(), getPreferredSize().getHeight()).getImage();		
		this.addMouseListener(this);
		this.cardIdentifierNumber = cardIdentifierNumber;
		this.cardOfLabel = cardOfLabel;	
		originalWidthOfImage = (int)Math.round(Panel_CardHolder.cardWidth);
		currentWidthOfImage = (int)Math.round(Panel_CardHolder.cardWidth);
	}
	
	public void flip() {

		try {
			animation = new FlipLabelAnimation();
			animation.flip(this);
		} catch (IOException e) {
			System.out.println("couldnt flip animation at label_clickable");
		}
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(displayedImage, (originalWidthOfImage-currentWidthOfImage)/2, 0, this);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(Label_Clickable_OverlapCheck.checkIfCardCanBeTaken(this, CardHolderLogic.getListOfCardsAsIntegers())) {
			setVisible(false);
			CardHolderLogic.removeFromListOfCards(cardIdentifierNumber);
			Label_Clickable_FlipShouldOccurChecker.checkFlip(cardIdentifierNumber);
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public int getCardIdentifierNumber() {
		return cardIdentifierNumber;
	}
	public void setCardIdentifierNumber(int cardIdentifierNumber) {
		this.cardIdentifierNumber = cardIdentifierNumber;
	}	
	public void setCurrentImage(Image image) {
		this.displayedImage = image;
	}
	public void setWidthOfImageCurrent(int width) {
		this.currentWidthOfImage = width;
	}
	
	public Card getCardOfLabel() {
		return cardOfLabel;
	}
	
}
