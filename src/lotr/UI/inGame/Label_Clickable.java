package lotr.UI.inGame;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JLabel;

import lotr.DataConstructs.Card;
import lotr.UI.Logic.ImageScaler;
import lotr.UI.Logic.Label_Clickable_OverlapCheck;
import lotr.UI.Logic.CardHolder.CardHolderLogic;

public class Label_Clickable extends JLabel implements MouseListener{

	private int cardIdentifierNumber;
	private Card cardOfLabel;
	private double xCoord = getLocationOnScreen().getX();
	private double yCoord = getLocationOnScreen().getY();
	
	public Label_Clickable(Card card, boolean cover, int cardIdentifierNumber) throws IOException {
		setPreferredSize(new Dimension ((int)Math.round(Panel_CardHolder.cardWidth),(int)Math.round(Panel_CardHolder.cardHeight)));
		setVisible(true);
		setOpaque(false);
		if(!cover) {
			setIcon(ImageScaler.imageScaler(card.getPathToPicture(), getPreferredSize().getWidth(), getPreferredSize().getHeight()));
		}else {
			setIcon(ImageScaler.imageScaler(card.getPathToCover(), getPreferredSize().getWidth(), getPreferredSize().getHeight()));
		}	
		this.addMouseListener(this);
		this.cardIdentifierNumber = cardIdentifierNumber;
		cardOfLabel = card;
	}
	public int getCardIdentifierNumber() {
		return cardIdentifierNumber;
	}
	public void setCardIdentifierNumber(int cardIdentifierNumber) {
		this.cardIdentifierNumber = cardIdentifierNumber;
	}
	public double getxCoord() {
		return xCoord;
	}
	public double getyCoord() {
		return yCoord;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(Label_Clickable_OverlapCheck.checkIfCardCanBeTaken(this, CardHolderLogic.getListOfCardsAsIntegers())) {
			setVisible(false);
			CardHolderLogic.removeFromListOfCards(cardIdentifierNumber);
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
}
