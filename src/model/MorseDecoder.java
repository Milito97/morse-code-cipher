package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class MorseDecoder
{
	private final String FILE_PATH = "res/codes.txt";
	public File decodingFile;
	
	private void loadData() throws Exception {
		
		decodingFile = new File(FILE_PATH);
		String hoveredLine;
		if (decodingFile.exists()) {
			Scanner fileReader = new Scanner(decodingFile);
			while (fileReader.hasNextLine()) {
				
				
			}
			
			
			fileReader.close();
	} 

}
}