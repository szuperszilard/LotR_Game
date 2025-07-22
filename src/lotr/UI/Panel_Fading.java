package lotr.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import lotr.Logic.ICommunication;

public class Panel_Fading extends JPanel{
	
	private int width;
	private int height;
	private int fader;
	private Timer timer;
	private int plusOrMinus;
	private ICommunication comms;
	
	public Panel_Fading(JFrame frame) {
		
		width = frame.getWidth();
		height = frame.getHeight();
		setBounds(0,0,width, height);
		timer = new Timer(2, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fader += 5*plusOrMinus;
				if(fader > 255) {
					fader = 255;
					timer.stop();
					comms.somethingHappened("gamePanel");
					((Frame_MainWindow)frame).changeME("D:\\Eclipse\\LotRGame\\data\\wp2.png");
					startUnfade();
				}
				if(fader < 0) {
					fader = 0;
					timer.stop();
				}
				repaint();
			}
		});		
		setOpaque(false);			
	}	
	public void startFade() {		
		plusOrMinus = 1;
		fader = 0;
		timer.start();		
	}	
	public void startUnfade() {			
		plusOrMinus = -1;
		fader = 255;
		timer.start();
	}	
	protected void paintComponent(Graphics g) {		
		super.paintComponent(g);
		g.setColor(new Color(0,0,0,fader));
		g.fillRect(0, 0, width, height);		
	}
	public void setICommunication(ICommunication comms) {
		this.comms = comms;
	}	
}
