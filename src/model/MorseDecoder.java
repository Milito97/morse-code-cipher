package model;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseDecoder
{
	private final String FILE_PATH = "res/codes.txt";
	private BinaryTree<Character> tree;
	
	public MorseDecoder() {
		
		tree = new BinaryTree<Character>(' ');
        try {
			createTree(FILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	private void createTree(String fileName) throws FileNotFoundException {
		
        Scanner in = new Scanner(new File(fileName));
        String letter;
        String code;

        while (in.hasNextLine()) {
        	
            letter = in.next();
            code = in.next();
            addTree (tree, letter.charAt(0), code);
            
        }
        
        in.close();
        
//        print();  //Used to print the tree and check if its correct//
    }
	
	private void addTree(BinaryTree<Character> tree, char charToPlace, String code) {
		
		char firstCharInCode;
    	
        if (code.equals(".")) {
        	
        	tree.setLeft(new BinaryTree<Character>(charToPlace));
        	
        } else if (code.equals("-")) {
        	
        	tree.setRight(new BinaryTree<Character>(charToPlace));
        	
        } else {
        	
        	firstCharInCode = code.charAt(0);
        	code = code.substring(1);
        	
        	if (firstCharInCode == '.') {
        		
        		addTree(tree.getLeft(), charToPlace, code);
        	
        	} else if (firstCharInCode == '-') {
        		
        		addTree(tree.getRight(), charToPlace, code);
        		
        	}
        }
		
	}
    
    public char decoder(BinaryTree<Character> tree, String code) {
    	
    	char firstCharInCode;
    	char decodedChar = '0';
    	
        if (code.equals("")) {
        	
        	decodedChar = tree.getRootElement();
        	
        } else {
        	
        	firstCharInCode = code.charAt(0);
        	code = code.substring(1);
        	
        	if (firstCharInCode == '.') {
        		
        		decodedChar = decoder(tree.getLeft(), code);
        	
        	} else if (firstCharInCode == '-') {
        		
        		decodedChar = decoder(tree.getRight(), code);
        		
        	} else {
        		throw new RuntimeException("Invalid Morse Code Input. Try Again: ");
        	}
        	
        }
    	
        return decodedChar;
        
    }
    	

	public void print() {
		
		Iterator<Character> it = tree.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

	public BinaryTree<Character> getTree() {
		return tree;
	}
	
}	