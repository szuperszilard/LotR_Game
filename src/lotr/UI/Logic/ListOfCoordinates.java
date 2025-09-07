package lotr.UI.Logic;

import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import lotr.UI.inGame.Label_Clickable;

public class ListOfCoordinates {
	
	private ArrayList<Point> listOfCoodrinatePoints;
	
	public ListOfCoordinates(ArrayList<Label_Clickable> listOfLabels, Component relativeToThis) {
		listOfCoodrinatePoints = new ArrayList<>();
		for(Label_Clickable label : listOfLabels) {
			
			Point pointRelativeToComponent = SwingUtilities.convertPoint(label.getParent(), label.getLocation(), relativeToThis);
			listOfCoodrinatePoints.add(pointRelativeToComponent);
		}		
	}
	public ArrayList<Point> getListOfCoodrinatePoints() {
		return listOfCoodrinatePoints;
	}
}
