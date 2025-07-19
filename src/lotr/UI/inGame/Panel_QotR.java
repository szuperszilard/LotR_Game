package lotr.UI.inGame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import lotr.UI.Panel_Move;
import lotr.UI.Logic.ImageScaler;

public class Panel_QotR extends JLayeredPane{

	private Image img_QotR = new ImageIcon("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\QotR\\QotR2.png").getImage();
		
	private Image scaledImg_QotR;
    private Image scaledImg_FotR;
    private Image scaledImg_Sauron;
	
	private double ratio= (double)img_QotR.getWidth(null)/img_QotR.getHeight(null);
	
	private int height = 210;
	private int width = ((int)Math.round(ratio*height));
	
	private double step = height*0.2822;
	
	private int stepCounterFotR = 0;
	private int stepCounterSauron = 0;
	
	private int x_FotR = 0;
	private int x_Sauron = 0;
	
	private Panel_Move pnlFotR;
	private Panel_Move pnlSauron;
	
	public Panel_QotR() {
		
		try {
			scaledImg_QotR = ImageScaler.imageScaler("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\QotR\\QotR2.png", width, height).getImage();
			scaledImg_FotR = ImageScaler.imageScaler("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\QotR\\FotR.png", width, height).getImage();
			scaledImg_Sauron = ImageScaler.imageScaler("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\QotR\\Sauron.png", width, height).getImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel pnl_QotR = new JPanel() {
			
			protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (img_QotR != null) {                
						g.drawImage(scaledImg_QotR, 0, 0, null);
                }
            }
		};
		pnl_QotR.setBounds(0,0,width, height);
		pnl_QotR.setOpaque(false);
		
		
		pnlFotR = new Panel_Move(scaledImg_FotR, 0);
		pnlFotR.setBounds(0,0,width, height);
		pnlFotR.setOpaque(false);
		
		pnlSauron = new Panel_Move(scaledImg_Sauron, 0);
		pnlSauron.setBounds(0,0,width, height);
		pnlSauron.setOpaque(false);
		
		this.setBounds(0, 0, width, height);
		this.add(pnl_QotR, Integer.valueOf(0));
		this.add(pnlFotR, Integer.valueOf(1));
		this.add(pnlSauron, Integer.valueOf(2));

		setVisible(true);
		setOpaque(false);		
	}
	
	public void stepFotR() {
		stepCounterFotR++;
		stepCounterSauron++;
		x_FotR = ((int)Math.round(stepCounterFotR*step));
		x_Sauron = ((int)Math.round(stepCounterSauron*step));
		pnlFotR.step(x_FotR);
		pnlSauron.step(x_Sauron);
	}
	public void stepSauron() {
		stepCounterSauron++;
		x_Sauron = ((int)Math.round(stepCounterSauron*step));
		pnlSauron.step(x_Sauron);
	}
	
	
}
