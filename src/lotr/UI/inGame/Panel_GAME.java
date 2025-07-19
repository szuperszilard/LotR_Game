package lotr.UI.inGame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Panel_GAME extends JPanel{
	
	private int width;
	private int height;
	
		
	public Panel_GAME(JFrame frame){
		
		width = frame.getWidth();
		height = frame.getHeight();
	
		JLayeredPane panel1 = new Panel_QotR();
		panel1.setBounds(((int)Math.round((width-panel1.getWidth())/2)), 750, panel1.getWidth(), panel1.getHeight());
		
		JButton btnSauron = new JButton();
		btnSauron.setBounds(200,200,20,50);
		btnSauron.setVisible(true);
		btnSauron.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Panel_QotR)panel1).stepSauron();
				
			}
		});
		JButton btnFotR = new JButton();
		btnFotR.setBounds(400,400,20,50);
		btnFotR.setVisible(true);
		btnFotR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Panel_QotR)panel1).stepFotR();
				
			}
		});
		
		add(panel1);
		add(btnSauron);
		add(btnFotR);
		setBounds(0,0,width, height);
		setLayout(null);
		setVisible(false);
		setOpaque(false);
				
	}
	
	

}
