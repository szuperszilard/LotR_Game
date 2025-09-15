package lotr.UI.inGame;

import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import lotr.Logic.cards.CardLogic;
import lotr.UI.Frame_MainWindow;
import lotr.UI.Logic.ImageScaler;
import lotr.UI.Logic.LayeredPane_RightSide_Builder;
import lotr.UI.Logic.CardHolder.CardHolderLogic;
import lotr.UI.Logic.Movement.MoveJLabelXY;

public class LayeredPane_RightSide extends JLayeredPane{
	
	private ArrayList<Panel_CardHolder> listOfCardHolderPanels;
	private final MoveJLabelXY label;
	public LayeredPane_RightSide() throws IOException {	
		
		JLabel deckOfCardsToDeal = new JLabel();
		deckOfCardsToDeal.setPreferredSize(new Dimension((int)Math.round(Panel_CardHolder.cardWidth),(int)Math.round(Panel_CardHolder.cardHeight)));
		deckOfCardsToDeal.setVisible(true);
		deckOfCardsToDeal.setIcon(ImageScaler.imageScaler(
				"LotRpics\\Done\\Cover\\cover1.png",
				(int)Math.round(Panel_CardHolder.cardWidth), 
				(int)Math.round(Panel_CardHolder.cardHeight)));
		deckOfCardsToDeal.setBounds(
				(Frame_MainWindow.frameWidth/2 - (int)Math.round(Panel_CardHolder.cardWidth) - 10),
				Frame_MainWindow.frameHeight - (int)Math.round(Panel_CardHolder.cardHeight) - 300, 
				(int)deckOfCardsToDeal.getPreferredSize().getWidth(), 
				(int)deckOfCardsToDeal.getPreferredSize().getHeight());
		add(deckOfCardsToDeal);
		
		Point startingPoint = new Point(
				(Frame_MainWindow.frameWidth/2 - (int)Math.round(Panel_CardHolder.cardWidth) - 10),
				Frame_MainWindow.frameHeight - (int)Math.round(Panel_CardHolder.cardHeight) - 300);
		label = new MoveJLabelXY(500, 500, startingPoint.x, startingPoint.y, "LotRpics\\Done\\Cover\\cover3.png");
		label.setBounds(startingPoint.x, startingPoint.y, (int)label.getPreferredSize().getWidth(), (int)label.getPreferredSize().getHeight());
		add(label, Integer.valueOf(100));
		deal(1);
	}
	
	public void deal(int chapter) throws IOException {
		
		LayeredPane_RightSide_Builder.build(this, label);
		CardHolderLogic.fillCardHolders(CardLogic.stackToUse("LotRpics\\Done\\cards" + chapter + "\\cards" + chapter +".csv"), listOfCardHolderPanels, chapter);
		
	}
	public ArrayList<Panel_CardHolder> getListOfCardHolderPanels() {
		return listOfCardHolderPanels;
	}
	public void setListOfCardHolderPanels(ArrayList<Panel_CardHolder> listOfCardHolderPanels) {
		this.listOfCardHolderPanels = listOfCardHolderPanels;
	}
	
	
	
	
}
