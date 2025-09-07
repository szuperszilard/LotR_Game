package lotr.UI.Logic.CardHolder;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import lotr.DataConstructs.Card;
import lotr.UI.Frame_MainWindow;
import lotr.UI.inGame.Label_Clickable;
import lotr.UI.inGame.Panel_CardHolder;

public class FillPanelsWithCardLabels {

	public static void fill(ArrayList<Card> cards, ArrayList<Panel_CardHolder> cardHolderPanels, int chapter, int[] cardCountInRowByChapter) {
		CardHolderLogic.setListOfLabels(new ArrayList<Label_Clickable>());
		boolean cover = false; 	
		int cardIdentifierNumber = 1;
		
		 for (int chCount = 0; chCount < cardHolderPanels.size(); chCount++) {
			 
		        Panel_CardHolder mainPanel = cardHolderPanels.get(chCount);
		        int numCardsInRow = cardCountInRowByChapter[chCount];
		        
		        JPanel labelsContainer = new JPanel();
		        labelsContainer.setOpaque(false);

		        if (chapter == 3 && chCount == 3) {
		            int horizontalGap = (int) Math.round(Frame_MainWindow.frameWidth * 0.0669 + 10);
		            labelsContainer.setLayout(new GridLayout(1, numCardsInRow, horizontalGap, 0));
		        } else {
		            labelsContainer.setLayout(new GridLayout(1, numCardsInRow, 5, 0));
		        }
     
		        for (int cardCount = 0; cardCount < numCardsInRow; cardCount++) {	
		        	Label_Clickable label;
					try {
						label = new Label_Clickable(cards.get(0), cover,cardIdentifierNumber);
						labelsContainer.add(label);
			        	cards.remove(0);	
			            CardHolderLogic.getListOfLabels().add(label);
			            cardIdentifierNumber++;
					} catch (IOException e) {
						System.out.println("IOException at FILL");
					} 	        	
		        }

		        GridBagConstraints gbc = new GridBagConstraints();
		        gbc.anchor = GridBagConstraints.CENTER;
		        mainPanel.add(labelsContainer, gbc);

		        cover = !cover;
		    }
	}	
}
