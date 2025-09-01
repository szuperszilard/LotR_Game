package lotr.UI.inGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.Timer;

import lotr.Logic.cards.CardLogic;
import lotr.UI.Logic.LayeredPane_RightSide_Builder;
import lotr.UI.Logic.CardHolder.CardHolderLogic;

public class LayeredPane_RightSide extends JLayeredPane implements ActionListener{
	
	private ArrayList<Panel_CardHolder> listOfCardHolderPanels;
	
	private int XcurrentCoordinate;
	private int YcurrentCoordinate;
	private Image imageToMove;
	private Timer timer;
	
	public LayeredPane_RightSide() throws IOException {
			
		deal(1);
		timer = new Timer(1000, this);
		
	}
	
	public void deal(int chapter) throws IOException {
		
		LayeredPane_RightSide_Builder.build(this);
		CardHolderLogic.fillCardHolders(CardLogic.stackToUse("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\cards" + chapter + "\\cards" + chapter +".csv"), listOfCardHolderPanels, chapter);
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(imageToMove, XcurrentCoordinate, YcurrentCoordinate, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		
		
		
	}

	public ArrayList<Panel_CardHolder> getListOfCardHolderPanels() {
		return listOfCardHolderPanels;
	}
	public void setListOfCardHolderPanels(ArrayList<Panel_CardHolder> listOfCardHolderPanels) {
		this.listOfCardHolderPanels = listOfCardHolderPanels;
	}
	
	
}
