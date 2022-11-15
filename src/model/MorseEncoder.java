package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseEncoder
{
	private final String FILE_PATH = "res/codes.txt";
	public File encodingFile;
	int i = 0;
	private String[] encoderList;

	
	public MorseEncoder() {
		encoderList = new String[26];
		try {
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadData() throws Exception {
		
		encodingFile = new File(FILE_PATH);
		String hoveredLine;
		if (encodingFile.exists()) {
			Scanner fileReader = new Scanner(encodingFile);
			while (fileReader.hasNextLine()) {
				hoveredLine = fileReader.nextLine();
				
				int targetIndex = (hoveredLine.charAt(0)-'A');
				String morseCode = hoveredLine.substring(2);
				encoderList[targetIndex]=morseCode;
				//System.out.println(encoderList[targetIndex]);
				//System.out.println(encoderList[i].substring(2, encoderList[i].length()));
				i++;
			}
		
			fileReader.close();
	} 
		
	
}
	
	public String encode(char letterFromMessage) {
		
		String partOfMessage = "";
		        
		int encoderTargetIndex = (letterFromMessage-'A');
		
		if (letterFromMessage == ' ') {
			
			partOfMessage = "    ";
		}
		
		else {

		partOfMessage = (encoderList[encoderTargetIndex]+"   ");
		
		}
		
		return partOfMessage;
	}
}