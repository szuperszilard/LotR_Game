package lotr.UI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel_Move extends JPanel implements ActionListener{

	private Image scaledImg;
	private Timer timer;
	private int currentPosition = 0;
	private int newPosition = 0;
	
	
	public Panel_Move(Image scaledImg, int currentPosition) {	
		this.scaledImg = scaledImg;
		this.currentPosition = currentPosition;
		timer = new Timer(2, this);
	};
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
		g.drawImage(scaledImg, currentPosition, 0, null);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		
			if(currentPosition < newPosition) {
				currentPosition = currentPosition + 1;
				repaint();
			}else {
				timer.stop();
			}
			
		
		
	}	
	public void step(int newPosition) {
		this.newPosition = newPosition;
		timer.start();
	}
	
}
