package model;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;

public class MorseDecoder
{
	private final String FILE_PATH = "res/codes.txt";
	private File decodingFile;
	private BinaryTree<Character> tree;
	
	public MorseDecoder() {
		try {
			loadData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadData() throws Exception {
		
		String currentLine;
		String [] splittedLine;
		
		tree = new BinaryTree<>(' ');
		
		decodingFile = new File(FILE_PATH);
		
		if (decodingFile.exists()) {
			
			Scanner fileReader = new Scanner(decodingFile);
			
			while (fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine();

				splittedLine = currentLine.split(" ");
				
				BinaryTree<Character> current = tree;
				
				for (int i = 0; i < splittedLine[1].length(); i++) {
					
					if (splittedLine[1].charAt(i) == '.') {
						
						if (i == (splittedLine[1].length() - 1)) {
							current.setLeft(new BinaryTree<Character>(splittedLine[0].charAt(0)));
						} else {
							current = current.getLeft();
						}

					} else if (splittedLine[1].charAt(i) == '-') {
						
						if (i == (splittedLine[1].length() - 1)) {
							current.setRight(new BinaryTree<Character>(splittedLine[0].charAt(0)));
						} else {
							current = current.getRight();
						}
					}
					
				}
				
			}
			
			fileReader.close();
		}
		
		print();
		
	}

	public void print() {
		
		Iterator<Character> it = tree.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	
}	