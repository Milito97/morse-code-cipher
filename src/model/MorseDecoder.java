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
		int iterations = 0;
		
		tree = new BinaryTree<>(' ');
		
		decodingFile = new File(FILE_PATH);
		
		if (decodingFile.exists()) {
			
			Scanner fileReader = new Scanner(decodingFile);
			
			while (fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine();

				splittedLine = currentLine.split(" ");
				
				int subStringLength = splittedLine[1].length() - 1;
				char letterToAdd = splittedLine[0].charAt(0);
				
				BinaryTree<Character> current = tree;
				
				addTree(current, splittedLine, iterations);
				
//				for (int i = 0; i < splittedLine[1].length(); i++) {
//					
//					if (splittedLine[1].charAt(i) == '.') {
//						
//						if (i == subStringLength) {
//							current.setLeft(new BinaryTree<Character>(letterToAdd));
//						} else {
//							current = current.getLeft();
//						}
//
//					} else if (splittedLine[1].charAt(i) == '-') {
//						
//						if (i == subStringLength) {
//							current.setRight(new BinaryTree<Character>(letterToAdd));
//						} else {
//							current = current.getRight();
//						}
//					}
//					
//				}
				
			}
			
			fileReader.close();
		}
		
		print();
		
	}
	
	public void addTree(BinaryTree<Character> current, String [] splittedLine, int i) {
		
		int subStringLength = splittedLine[1].length() - 1;
		char letterToAdd = splittedLine[0].charAt(0);
		
		if (splittedLine[1].charAt(i) == '.') {
			
			if (i == subStringLength) {
				current.setLeft(new BinaryTree<Character>(letterToAdd));
			} else {
				current = current.getLeft();
				i++;
				addTree(current, splittedLine, i);
			}

		} else if (splittedLine[1].charAt(i) == '-') {
			
			if (i == subStringLength) {
				current.setRight(new BinaryTree<Character>(letterToAdd));
			} else {
				current = current.getRight();
				i++;
				addTree(current, splittedLine, i);
			}
		}
		
	}

	public void print() {
		
		System.out.println(tree.size());
		
		Iterator<Character> it = tree.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	
}	