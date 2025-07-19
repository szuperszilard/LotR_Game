package lotr.UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import lotr.DataConstructs.Room;
import lotr.Logic.Button_Methods;
import lotr.Logic.ICommunication;


import javax.swing.JScrollPane;
import javax.swing.JList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_Lobby extends JPanel {
	
	private BufferedImage backgroundImage;
	private DefaultListModel<Room> listModel;
	private JList lstRooms;
	private ICommunication comms;
	
	
	public Panel_Lobby() throws IOException {
		
		
		backgroundImage = ImageIO.read(new File("D:\\Eclipse\\LotRGame\\data\\roomsContainer_big.png"));	
		setBounds(486,94,1360,820);
		setLayout(null);
		
		JPanel pnlGameData = new Panel_GameData();
		add(pnlGameData);
		
		JButton btnLoadSaved = new JButton("Load Game");
		btnLoadSaved.setBounds(195, 702, 106, 23);
		add(btnLoadSaved);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.setBounds(1041, 717, 89, 23);
		add(btnJoin);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Button_Methods.btnNewGame(Panel_Lobby.this);
					comms.somethingHappened("new game");
				} catch (IOException e1) {
				}
				
			}
		});
		btnNewGame.setBounds(547, 702, 106, 23);
		add(btnNewGame);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(1201, 717, 89, 23);
		add(btnBack);
		
		JPanel pnlListContainer = new JPanel();
		pnlListContainer.setBounds(91, 68, 852, 612);
		add(pnlListContainer);
		pnlListContainer.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 852, 612);
		pnlListContainer.add(scrollPane);
		scrollPane.setOpaque(false);
		
		JList gameList = new JList();
		scrollPane.setViewportView(gameList);
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
