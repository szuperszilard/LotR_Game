package lotr.UI.inGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel_CardHolder extends JPanel{
	
	private int cardCount;
	private int chapter;

	public Panel_CardHolder(int cardCount, int chapter, JFrame frame) {
		
		this.cardCount = cardCount;
		setPreferredSize(new Dimension((int)Math.round(cardCount*frame.getWidth()*0.0669 + (cardCount-1)*8),(int)Math.round(frame.getHeight()*0.173)));
		setBackground(Color.blue);
		setVisible(true);
		setOpaque(true);
		setLayout(new FlowLayout());
	}
	
	public int getCardCount() {
		return cardCount;
	}
	
	public void setB(JFrame frame) {
		
		
		int frameWidth = frame.getWidth();
		int frameHeight = frame.getHeight();
		int totalCardsPlusSpacesWidth = (int)Math.round(frameWidth*(0.5 - cardCount*0.0669) - (cardCount-1)*8);
		int lpQotRHeight = (int)Math.round(frame.getWidth()*0.53*0.117) + 10;
		
		setBounds(
				(int)Math.round(totalCardsPlusSpacesWidth/2),
				lpQotRHeight + 10,
				(int)getPreferredSize().getWidth(),
				(int)getPreferredSize().getHeight()
		);
	}
}
