package lotr.Logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import lotr.DataConstructs.AllianceToken;

public class AllianceTokenLogic {

	public static ArrayList<AllianceToken> readTokens(String fileName) {
		
		ArrayList<AllianceToken> tokens = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){
			
			while(br.ready()) {
				
				String line = br.readLine();
				String[] splitLine = line.split(",");
				tokens.add(new AllianceToken(new ImageIcon(splitLine[0]), splitLine[1], new ImageIcon(splitLine[2])));			
			}	
		} catch (FileNotFoundException e) {
			System.out.println("fileNotFound");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tokens;
	}	
}
