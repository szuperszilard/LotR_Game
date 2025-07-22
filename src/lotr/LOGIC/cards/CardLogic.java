package lotr.Logic.cards;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import lotr.DataConstructs.Card;
import lotr.DataConstructs.Player;
import lotr.Logic.CheckCost;
import lotr.Logic.GameLoop;
import lotr.Logic.Shuffler;

public class CardLogic {
	
	
	public static void takeCard(Player player, Card card, GameLoop gl) throws IllegalAccessException {
				
		if (!chainingUsed(player, card)) {			
			CheckCost.check(card.getSkillCost(), card.getCoinCost(), player, false);				
		}else if(player.getAllianceTokens().contains("ChainingMoney")){
			player.addCoin(3);
		}
		CardLogic.executeCard(player, card, gl);
		gl.somethingHappened("turnOver");
	}
	
	public static boolean chainingUsed(Player player, Card card) {
		
		boolean chainingUsed = false;
		
		if(!card.getUsesThisChainingSymbol().equals("-")) {
			if(player.getChainingSymbols().contains(card.getUsesThisChainingSymbol())) {
				chainingUsed = true;
			}
		}		
		return chainingUsed;
	}
	
	public static void discardCard(Card card, GameLoop gl) {
		
		gl.getGame().addToDiscard(card);
		gl.somethingHappened("turnOver");
		
	}
	
	public static void executeCard(Player player, Card card, GameLoop gl) {
		
		switch(card.getColor()) {
			case "gray" :{
				CLogic_Gray.executeGray(player, card);
				break;
			}
			case "green" :{
				CLogic_Green.executeGreen(player, card);
				break;
			}
			case "yellow" :{
				CLogic_Yellow.executeYellow(player, card, gl);
				break;
			}
			case "blue" :{
				CLogic_Blue.executeBlue(player, card, gl);
				break;
			}
			case "red" :{
				CLogic_Red.executeRed(player, card);
				break;
			}
			case "purple" :{
				CLogic_Purple.executePurple(player, card, gl);
				break;
			}
		}	
	}

	public static ArrayList<Card> stackToUse(String fileName) throws IOException{
		
		ArrayList<Card> stack = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){
			
			while(br.ready()) {
				
				String line = br.readLine();
				String[] splitLine = line.split(",");
				
				String[] stringArrayOfSkills = splitLine[0].split(";");
				int[] intArrayOfSkills = new int[5];
				for(int i = 0; i < 5; i++) {
					intArrayOfSkills[i] = Integer.parseInt(stringArrayOfSkills[i]);
				}
				
				String coverString = "";
				int discardCost = 0;
				if(fileName.contains("cards1")) {
					coverString = "D:\\Eclipse\\LotRGame\\LotRpics\\Done\\Cover\\cover1.png";
					discardCost = 1;
				}else if(fileName.contains("cards2")) {
					coverString = "D:\\Eclipse\\LotRGame\\LotRpics\\Done\\Cover\\cover2.png";
					discardCost = 2;
				}else if(fileName.contains("cards3")) {
					coverString = "D:\\Eclipse\\LotRGame\\LotRpics\\Done\\Cover\\cover3.png";
					discardCost = 3;
				}
				ImageIcon coverImage = new ImageIcon(coverString);
			
				stack.add(new Card(
						coverImage,
						intArrayOfSkills, 
						new ImageIcon(splitLine[1]), 
						splitLine[2], 
						splitLine[3], 
						Integer.parseInt(splitLine[4]), 
						splitLine[5], 
						Integer.parseInt(splitLine[6]), 
						splitLine[7],
						discardCost));				
			}
		} catch (FileNotFoundException e) {
			System.out.println("fileNotFound");
		}
		stack = Shuffler.shuffle(stack);
		return stack;
	}
}
