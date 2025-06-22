package lotr.Logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Shuffler {
	
	public <T> ArrayList<T> shuffle(ArrayList<T> toShuffle) {
		
		ArrayList<T> shuffledList = new ArrayList<>();
		Set<T> setOfT = new HashSet<>();
		for(T element : toShuffle) {
			setOfT.add(element);
		}
		for(T element : setOfT) {
			shuffledList.add(element);
		}		
		return shuffledList;
	}

}
