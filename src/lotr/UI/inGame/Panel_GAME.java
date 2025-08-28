package lotr.UI.inGame;

import java.io.IOException;

import javax.swing.JPanel;

import lotr.UI.Frame_MainWindow;

public class Panel_GAME extends JPanel{
	
	private int width;
	private int height;
		
	public Panel_GAME() throws IOException{
		
		width = Frame_MainWindow.frameWidth;
		height = Frame_MainWindow.frameHeight;
		setBounds(0,0,width, height);
		setLayout(null);
	
		LayeredPane_QotR lpQotR = new LayeredPane_QotR();			
		LayeredPane_RightSide lpRightSide = new LayeredPane_RightSide();
		
		lpQotR.setBounds(width-lpQotR.getSizeWidth()-10, 10, lpQotR.getWidth(), lpQotR.getHeight());
		lpRightSide.setBounds((int)Math.round(width/2),0,(int)lpRightSide.getPreferredSize().getWidth(), (int)lpRightSide.getPreferredSize().getHeight());

		add(lpQotR);
		add(lpRightSide);
			
		setVisible(false);
		setOpaque(false);				
	}
}
