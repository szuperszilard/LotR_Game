package lotr.UI.inGame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel_GAME extends JPanel{
	
	private int width;
	private int height;
		
	public Panel_GAME(JFrame frame){
		
		width = frame.getWidth();
		height = frame.getHeight();
		setBounds(0,0,width, height);
		setLayout(null);
	
		LayeredPane_QotR lpQotR = new LayeredPane_QotR(frame);			
		LayeredPane_RightSide lpRightSide = new LayeredPane_RightSide(frame);
		
		lpQotR.setBounds(frame.getWidth()-lpQotR.getSizeWidth()-10, 10, lpQotR.getWidth(), lpQotR.getHeight());
		lpRightSide.setBounds((int)Math.round(frame.getWidth()/2),0,(int)lpRightSide.getPreferredSize().getWidth(), (int)lpRightSide.getPreferredSize().getHeight());

		add(lpQotR);
		add(lpRightSide);
			
		setVisible(false);
		setOpaque(false);				
	}
}
