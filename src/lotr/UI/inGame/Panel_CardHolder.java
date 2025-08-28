package lotr.UI.inGame;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import lotr.UI.Frame_MainWindow;

public class Panel_CardHolder extends JPanel{
	
	public static final double cardWidth = Frame_MainWindow.frameWidth*0.0669;
	public static final double cardHeight = Frame_MainWindow.frameHeight*0.18;
	public static final int cardHolderPanelWidth = (int)Math.round(6* cardWidth + 40);
	public static final int cardHolderPanelHeight = (int)Math.round(cardHeight);
	
	public Panel_CardHolder() {	
		
		setPreferredSize(new Dimension((int)Math.round(6* cardWidth + 40),(int)Math.round(cardHeight)));
		setVisible(true);
		setOpaque(false);
		setLayout(new GridBagLayout());
		
	}
}
