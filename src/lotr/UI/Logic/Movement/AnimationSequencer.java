package lotr.UI.Logic.Movement;

import java.awt.Point;
import java.util.ArrayList;


public class AnimationSequencer {
	
	private MoveJLabelXY label;
	private ArrayList<Point> listOfCoordinates;
	private int currentIndex = 0;
	
	public AnimationSequencer(MoveJLabelXY label, ArrayList<Point> listOfCoordinates) {
		
		this.label = label;
		this.listOfCoordinates = listOfCoordinates;
	}
	
	public void startAnimation() {
		nextAnimation();
	}
	
	public void nextAnimation() {
		
		if(currentIndex < listOfCoordinates.size()) {
			
			Point nextDestination = listOfCoordinates.get(currentIndex);
			currentIndex++;
			label.setNextDestination(nextDestination.x, nextDestination.y);
			label.changeLocation(() -> nextAnimation());
			
		}	
		System.out.println("nextanimation");
	}
}
