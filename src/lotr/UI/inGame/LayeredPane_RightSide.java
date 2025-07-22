package lotr.UI.inGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class LayeredPane_RightSide extends JLayeredPane implements ActionListener{

	public LayeredPane_RightSide(JFrame frame) {
		
		setPreferredSize(new Dimension((int)Math.round(frame.getWidth()/2),frame.getHeight()));
		setBackground(Color.red);
		setLayout(null);
		setVisible(true);
		setOpaque(true);
		
		Panel_CardHolder sixCards = new Panel_CardHolder(6, frame);
		sixCards.setB(frame);
		Panel_CardHolder fiveCards = new Panel_CardHolder(5, frame);
		fiveCards.setB(frame);
		fiveCards.setBackground(Color.green);
		
		add(sixCards, Integer.valueOf(10));
		add(fiveCards, Integer.valueOf(11));
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
	}
}
