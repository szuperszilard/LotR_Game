package lotr.UI.Logic.Movement;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import lotr.UI.Logic.ListOfCoordinates;
import lotr.UI.Logic.CardHolder.CardHolderLogic;
import lotr.UI.inGame.LayeredPane_RightSide;


public class DealTheCards {
	
	public static void startAnimation(int chapter, LayeredPane_RightSide lprs, MoveJLabelXY label) throws IOException {
		
		ListOfCoordinates listOfCoordinates = new ListOfCoordinates(CardHolderLogic.getListOfLabels(), lprs);
		
		ArrayList<Point> pointList = new ArrayList<>();
		for(Point point : listOfCoordinates.getListOfCoodrinatePoints()) {
			pointList.add(point);
			System.out.println(point.x + " " + point.y);
		}
		
		AnimationSequencer sequencer = new AnimationSequencer(label, pointList);
		sequencer.startAnimation();
	}

}
