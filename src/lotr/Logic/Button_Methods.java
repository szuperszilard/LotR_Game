package lotr.Logic;

import java.io.IOException;

import javax.swing.JPanel;

import lotr.UI.Panel_Room;



public class Button_Methods {
	
	public static void btnNewGame(JPanel panel) throws IOException {
		
		panel.setVisible(false);
		Panel_Room roomPanel = new Panel_Room();
		
		roomPanel.setVisible(true);
		
	}

}
