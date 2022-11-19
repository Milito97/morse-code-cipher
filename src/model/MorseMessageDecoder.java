package model;


public class MorseMessageDecoder {
	
	MorseDecoder decoder = new MorseDecoder();
	
    public char decodeMessage(String message) {
    	
    	return decoder.decoder(decoder.getTree(), message);
    }
    
}