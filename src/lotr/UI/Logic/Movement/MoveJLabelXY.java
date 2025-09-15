package lotr.UI.Logic.Movement;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.Timer;

import lotr.UI.Logic.ImageScaler;
import lotr.UI.Logic.CardHolder.CardHolderLogic;
import lotr.UI.inGame.Panel_CardHolder;

public class MoveJLabelXY extends JLabel {
	
    private final Image scaledImg;
    private Timer timer;

    private int Xdestination;
    private int Ydestination;
    private double Xcurrent;
    private double Ycurrent;
    private double Xstart;
    private double Ystart;
    private double Xvector;
    private double Yvector;
    private int index = 0;

    public MoveJLabelXY(int Xdestination, int Ydestination, int Xcurrent, int Ycurrent, String pathToImage) throws IOException {
        setPreferredSize(new Dimension((int) Math.round(Panel_CardHolder.cardWidth),(int) Math.round(Panel_CardHolder.cardHeight)));
        setVisible(true);
        setOpaque(false);

        scaledImg = ImageScaler.imageScaler(pathToImage, getPreferredSize().getWidth(), getPreferredSize().getHeight()).getImage();

        this.Xcurrent = Xcurrent;
        this.Ycurrent = Ycurrent;
        this.Xdestination = Xdestination;
        this.Ydestination = Ydestination;	
        Xstart = Xcurrent;
        Ystart = Ycurrent;
    }
    
    public void setNextDestination(int xNext, int yNext) {
        
        this.Xcurrent = Xstart;
        this.Ycurrent = Ystart;
        this.Xdestination = xNext;
        this.Ydestination = yNext;
    }
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaledImg, 0, 0, this);
    } 
	
    public void changeLocation(Runnable onFinished) {

    	
        double Xdistance = Xdestination - Xcurrent;
        double Ydistance = Ydestination - Ycurrent;
        double travelDistance = Math.sqrt(Xdistance * Xdistance + Ydistance * Ydistance);
        double speed = 30;

        Xvector = (Xdistance / travelDistance) * speed;
        Yvector = (Ydistance / travelDistance) * speed;

        timer = new Timer(15, e -> {
            boolean isMoving = false;
            setVisible(true);

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
                if (onFinished != null) {
                    onFinished.run();
                }
                setVisible(false);
                CardHolderLogic.getListOfLabels().get(index).setVisible(true);
                index++;
            }
        });
        timer.start();
    }
}