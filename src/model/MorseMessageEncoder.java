package model;
import java.io.FileNotFoundException;


public class MorseMessageEncoder
{
	MorseEncoder encoderObject = new MorseEncoder();
	
    public String encodeMessage(String message) {
    	
    	String newMessage = "";
    	
    	String uppered = message.toUpperCase();
    	//System.out.println(uppered.charAt(0));
    	
    	for (int k=0; k<uppered.length(); k++) {
    		newMessage+=encoderObject.encode(uppered.charAt(k));
    	}
    	
    	return newMessage;
    }
}