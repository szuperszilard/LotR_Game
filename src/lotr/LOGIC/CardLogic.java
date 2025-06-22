package lotr.Logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import lotr.DataConstructs.Card;
import lotr.DataConstructs.Player;

public class CardLogic {
	
	
	public static boolean checkCost(Player player, Card card) throws IllegalAccessException {
		
		int[] temporarySkills = player.getSkills();
		//black, blue, red, purple, green
		int temporaryCoin = player.getCoin();
		
		boolean canTake = true;
		
		if (!chainingUsed(player, card)) {
			
			player.setCoin(CheckCost.check(card.getSkillCost(), card.getCoinCost(), player, false));			
		}	
		
		return canTake;
	}
	
	public static boolean chainingUsed(Player player, Card card) {
		
		boolean chainingUsed = false;
		
		if(card.chainable()) {
			if(player.getChainingSymbols().contains(card.getUsesThisChainingSymbol())) {
				chainingUsed = true;
			}
		}
		
		return chainingUsed;
	}
	
	public static void executeCard(Player player, Card card) {
		
		switch(card.getColor()) {
			case "gray" :{
				if(card.getAdditionalInfo().equals("-")) {
					EffectLogic.addSkill(player, card.getEffectType(), card.getEffectCount());
				}else if(card.getAdditionalInfo().equals("double")) {
					player.getExtraSkills()[0] = 1;
				}else if(card.getAdditionalInfo().equals("triple")) {
					player.getExtraSkills()[1] = 1;
				}
				break;
			}
			case "green" :{
				EffectLogic.addRace(player, card.getEffectType());
				break;
			}
			case "yellow" :{
				EffectLogic.coins(player, card.getEffectCount());
				break;
			}
			case "blue" :{
				
			}
		}
		
	}

	public static ArrayList<Card> stackToUse(String fileName) throws IOException{
		
		ArrayList<Card> stack = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			while(br.ready()) {
				
				String line = br.readLine();
				String[] splitLine = line.split(";");
				String[] stringArrayOfSkills = splitLine[1].split(",");
				int[] intArrayOfSkills = new int[5];
				for(int i = 0; i < 5; i++) {
					intArrayOfSkills[i] = Integer.parseInt(stringArrayOfSkills[i]);
				}
				
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("fileNotFound");
		}
		stack = Shuffler.shuffle(stack);
		
		return stack;
	}
}
