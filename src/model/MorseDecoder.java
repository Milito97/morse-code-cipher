package model;
import java.util.Scanner;
import java.io.File;

public class MorseDecoder
{
	private final String FILE_PATH = "res/codes.txt";
	public File decodingFile;
	
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
		
		BinaryTree<Character> tree = new BinaryTree<>(' ');
		
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
							//continue;
						}

					} else if (splittedLine[1].charAt(i) == '-') {
						
						if (i == (splittedLine[1].length() - 1)) {
							current.setRight(new BinaryTree<Character>(splittedLine[0].charAt(0)));
						} else {
							current = current.getRight();
							//continue;
						}
					}
					
				}
				
			}
			
			fileReader.close();
		} 

		print(tree);
		
	}
	
	public void print(BinaryTree<Character> tree) {
		
		System.out.println(tree.size());
		
		for (int i = 0; i < tree.size(); i++) {
			System.out.println(tree.iterator().next());
		}
		
	}
	
}	