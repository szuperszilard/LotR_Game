package lotr.UI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


import lotr.DataConstructs.User;
import lotr.Logic.ICommunication;

public class Panel_Room extends JPanel{
	
	private BufferedImage backgroundImage;
	private User owner;
	private ICommunication comms;
		
	public Panel_Room() throws IOException {
				
		backgroundImage = ImageIO.read(new File("D:\\Eclipse\\LotRGame\\data\\roomsContainer_big.png"));	
		setBounds(486,94,1360,820);
		setLayout(null);
		
		JPanel pnlGameData = new Panel_GameData();		
		add(pnlGameData);
			
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(1041, 717, 89, 23);
		add(btnStart);		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comms.somethingHappened("start");
				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(1201, 717, 89, 23);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				comms.somethingHappened("backToLobby");
			}
		});
		
		setOpaque(false);
		setVisible(false);
	}
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, 1360,820, this);
        }
	}
	
	public void setICommunication(ICommunication comms) {
		this.comms = comms;
	}
}
