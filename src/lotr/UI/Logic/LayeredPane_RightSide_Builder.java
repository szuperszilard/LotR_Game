package lotr.UI.Logic;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import lotr.UI.Frame_MainWindow;
import lotr.UI.Logic.Movement.DealTheCards;
import lotr.UI.Logic.Movement.MoveJLabelXY;
import lotr.UI.inGame.LayeredPane_QotR;
import lotr.UI.inGame.LayeredPane_RightSide;
import lotr.UI.inGame.Panel_CardHolder;

public class LayeredPane_RightSide_Builder {

	public static void build(LayeredPane_RightSide lprs, MoveJLabelXY label) throws IOException {
		
		lprs.setListOfCardHolderPanels(new ArrayList<Panel_CardHolder>());
		lprs.setPreferredSize(new Dimension((int)Math.round(Frame_MainWindow.frameWidth/2),Frame_MainWindow.frameHeight));
		lprs.setLayout(null);
		lprs.setVisible(true);
		lprs.setOpaque(false);
		
		int cardHolderXPosition = (Frame_MainWindow.frameWidth/2 - Panel_CardHolder.cardHolderPanelWidth)/2;
		
		for(int chCounter = 0; chCounter < 7; chCounter++) {
			
			Panel_CardHolder cardHolderPanel = new Panel_CardHolder();
			cardHolderPanel.setBounds(
					cardHolderXPosition, 
					LayeredPane_QotR.height + 20 + (int)Math.round(Panel_CardHolder.cardHolderPanelHeight*chCounter*0.388), 
					Panel_CardHolder.cardHolderPanelWidth, 
					Panel_CardHolder.cardHolderPanelHeight);
			lprs.add(cardHolderPanel, Integer.valueOf(10+chCounter));
			lprs.getListOfCardHolderPanels().add(cardHolderPanel);
		}
		
		
		
		// teszteléshez töltelék
		JButton button = new JButton("deal");
		button.setBounds(500,800,100,100);
		button.setVisible(true);
		
		button.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DealTheCards.startAnimation(1, lprs, label);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		//lprs.add(label, Integer.valueOf(50));
		lprs.add(button, Integer.valueOf(60));
		
	}	
}
