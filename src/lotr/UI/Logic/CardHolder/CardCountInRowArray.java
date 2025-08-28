package lotr.UI.Logic.CardHolder;

public class CardCountInRowArray {

	public static int[] getCardCountInRowArray(int chapter) {
		
		int[] cardCountInRowByChapter = new int[7]; 
		if(chapter == 1) {
			for(int i = 0; i < 7; i++) {
				if(i < 5) {
					cardCountInRowByChapter[i] = i + 2;
				}else {
					cardCountInRowByChapter[i] = 0;
				}
			}
		}else if(chapter == 2) {
			for(int i = 0; i < 7; i++) {
				if(i < 5) {
					cardCountInRowByChapter[i] = 6 - i;
				}else {
					cardCountInRowByChapter[i] = 0;
				}
			}
		}else if(chapter == 3) {
			cardCountInRowByChapter = new int[]{2,3,4,2,4,3,2};	
		}		
		return cardCountInRowByChapter;
	}	
}
