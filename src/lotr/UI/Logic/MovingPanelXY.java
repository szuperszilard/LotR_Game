package lotr.UI.Logic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingPanelXY extends JPanel implements ActionListener{

	private Image topImg;
	private Image coverImg;
	private Timer timer;
	private int currentX = 0;
	private int currentY = 0;
	private int newX;
	private int newY;
	private int xStep = 2;
	private int yStep = 2;
	
	public MovingPanelXY(Image topImg) {
		this.topImg = topImg;
		timer = new Timer(xStep, this);	
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(topImg, currentX, currentY, null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int counter1 = 0;
		int counter2 = 0;
		//yStep = (int)Math.round((Math.abs(currentY-newY)/Math.abs(currentX-newX))*xStep);
		if(Math.abs(currentX - newX) > 0) {
			if(currentX > newX) {
				currentX = currentX - xStep;
				repaint();
			}else {
				currentX = currentX + xStep;
				repaint();
			}
		}else {
			counter1 = 1;
		}
		if(Math.abs(currentY - newY) > 0) {
			if(currentY > newY) {
				currentY = currentY - yStep;
				repaint();
			}else {
				currentY = currentY + yStep;
				repaint();
			}
		}else {
			counter2 = 1;
		}
		if(counter1 == 1 && counter2 == 1) {
			timer.stop();
		}
	}
	public void movePanel(int currentX, int currentY, int newX, int newY) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.newX = newX;
		this.newY = newY;
		timer.start();		
	}
}
