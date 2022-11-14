package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseEncoder
{
	private final String FILE_PATH = "res/codes.txt";
	public File encodingFile;
	int i = 0;
	private String[] encoderList = new String[26];

	
	public void loadData() throws Exception {
		
		encodingFile = new File(FILE_PATH);
		String hoveredLine;
		if (encodingFile.exists()) {
			Scanner fileReader = new Scanner(encodingFile);
			while (fileReader.hasNextLine()) {
				hoveredLine = fileReader.nextLine();
				encoderList[i]=hoveredLine;
				System.out.println(encoderList[i]);
				System.out.println(encoderList[i].charAt(0));
				System.out.println(encoderList[i].substring(2, encoderList[i].length()));
				i++;
			}
		
			fileReader.close();
	} 
		
	
}
	
	public String encode(char letterFromMessage) {
		
		String partOfMessage = null;
		
        boolean b1 = Character.isWhitespace(letterFromMessage);

		for (int j=0; j<encoderList.length; j++) {
			System.out.println("test");

			if (letterFromMessage == encoderList[j].charAt(0)) {
				System.out.println("test2");

				partOfMessage.equals(encoderList[j].substring(2, encoderList[i].length())+"   ");
			}
			
			else if (b1 == true) {
				System.out.println("test3");

				partOfMessage.equals("       ");
			}
			
		}
		
		return partOfMessage;
	}
}