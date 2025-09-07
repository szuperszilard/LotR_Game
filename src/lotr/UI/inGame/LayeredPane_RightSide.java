package lotr.UI.inGame;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import lotr.Logic.cards.CardLogic;
import lotr.UI.Logic.LayeredPane_RightSide_Builder;
import lotr.UI.Logic.CardHolder.CardHolderLogic;

public class LayeredPane_RightSide extends JLayeredPane{
	
	private ArrayList<Panel_CardHolder> listOfCardHolderPanels;

	public LayeredPane_RightSide() throws IOException {
			
		deal(3);
		
		
	}
	
	public void deal(int chapter) throws IOException {
		
		LayeredPane_RightSide_Builder.build(this);
		CardHolderLogic.fillCardHolders(CardLogic.stackToUse("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\cards" + chapter + "\\cards" + chapter +".csv"), listOfCardHolderPanels, chapter);
	}

	
	
	

	public ArrayList<Panel_CardHolder> getListOfCardHolderPanels() {
		return listOfCardHolderPanels;
	}
	public void setListOfCardHolderPanels(ArrayList<Panel_CardHolder> listOfCardHolderPanels) {
		this.listOfCardHolderPanels = listOfCardHolderPanels;
	}
	
	
}
