package model;


public class MorseMessageDecoder {
	
	MorseDecoder decoder = new MorseDecoder();
	
    public String decodeMessage(String message) {
    	
    	String decodedText = "";
    	
    	String[] words = message.split("       ");
    	
    	for (String word : words) {
    		
    		String[] splitLetters = word.split("   ");
    		
    		decodedText += " ";
    		
    		for (String letter : splitLetters) {
    			
    			decodedText += decoder.decoder(decoder.getTree(), letter);
    			
    		}
    		
    	}
    	
    	return decodedText.trim();
    	
    }
    
}