package lotr.UI.Logic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.Timer;

import lotr.UI.inGame.Panel_CardHolder;

public class MoveJLabelXY extends JLabel{
	
	private Image scaledImg;
	private Timer timer;
	private int Xdestination;
	private int Ydestination;
	private int Xcurrent;
	private int Ycurrent;
	private int Xdirection;
	private int Ydirection;
	
	
	public MoveJLabelXY(int Xdestination, int Ydestination, int Xcurrent, int Ycurrent, String pathToImage) throws IOException {
		
		setPreferredSize(new Dimension ((int)Math.round(Panel_CardHolder.cardWidth),(int)Math.round(Panel_CardHolder.cardHeight)));
		setVisible(true);
		setOpaque(false);
		scaledImg = ImageScaler.imageScaler(pathToImage, getPreferredSize().getWidth(), getPreferredSize().getHeight()).getImage();
		this.Xcurrent = Xcurrent;
		this.Ycurrent = Ycurrent;
		this.Xdestination = Xdestination;
		this.Ydestination = Ydestination;	
		changeCoords();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(scaledImg, 0, 0, this);
	} 
	
	public void changeCoords() {
		Xdirection = (Xdestination >= Xcurrent)?1:-1;
		Ydirection = (Ydestination >= Ycurrent)?1:-1;
		timer = new Timer(100, e -> {
	        boolean isMoving = false;

	        if (Xcurrent != Xdestination) {
	            Xcurrent += Xdirection;
	            isMoving = true;
	        }
	        if (Ycurrent != Ydestination) {
	            Ycurrent += Ydirection;
	            isMoving = true;
	        }
	        setLocation(Xcurrent, Ycurrent); 

	        if (!isMoving) {
	            timer.stop();
	        }
	    });
	    timer.start();
	}
	
}
