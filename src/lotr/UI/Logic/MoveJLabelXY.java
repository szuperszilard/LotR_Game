package lotr.UI.Logic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.Timer;

import lotr.UI.inGame.Panel_CardHolder;

public class MoveJLabelXY extends JLabel {
	
    private Image scaledImg;
    private Timer timer;

    private int Xdestination;
    private int Ydestination;
    private double Xcurrent;
    private double Ycurrent;
    private double Xvector;
    private double Yvector;

    public MoveJLabelXY(int Xdestination, int Ydestination, int Xcurrent, int Ycurrent, String pathToImage) throws IOException {
        setPreferredSize(new Dimension((int) Math.round(Panel_CardHolder.cardWidth),(int) Math.round(Panel_CardHolder.cardHeight)));
        setVisible(true);
        setOpaque(false);

        scaledImg = ImageScaler.imageScaler(pathToImage, getPreferredSize().getWidth(), getPreferredSize().getHeight()).getImage();

        this.Xcurrent = Xcurrent;
        this.Ycurrent = Ycurrent;
        this.Xdestination = Xdestination;
        this.Ydestination = Ydestination;	
        
       changeLocation();
    }
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaledImg, 0, 0, this);
    } 
	
    private void changeLocation() {

        double Xdistance = Xdestination - Xcurrent;
        double Ydistance = Ydestination - Ycurrent;
        double travelDistance = Math.sqrt(Xdistance * Xdistance + Ydistance * Ydistance);
        double speed = 5;

        Xvector = (Xdistance / travelDistance) * speed;
        Yvector = (Ydistance / travelDistance) * speed;

        timer = new Timer(100, e -> { 
            boolean isMoving = false;

            if (Math.abs(Xcurrent - Xdestination) > Math.abs(Xvector) ||
                Math.abs(Ycurrent - Ydestination) > Math.abs(Yvector)) {
                Xcurrent += Xvector;
                Ycurrent += Yvector;
                isMoving = true;
            } else {           
                Xcurrent = Xdestination;
                Ycurrent = Ydestination;
            }
        
            setLocation((int)Math.round(Xcurrent), (int)Math.round(Ycurrent));

            if (!isMoving) {
                timer.stop();
            }
        });
        timer.start();
    }
}