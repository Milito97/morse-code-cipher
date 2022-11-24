package model;


public class MorseMessageEncoder
{
	MorseEncoder encoderObject = new MorseEncoder();
	
    public String encodeMessage(String message) {
    	
    	String newMessage = "";
    	
    	String uppered = message.toUpperCase();
    	//System.out.println(uppered.charAt(0));
    	
    	try {
    		
    		for (int k=0; k<uppered.length(); k++) {
        		newMessage+=encoderObject.encode(uppered.charAt(k));
        	}
    		
    	} catch (ArrayIndexOutOfBoundsException e) {
    		
    		return "Invalid Character entered. Only letters and spaces allowed. Try again: ";
    		
    	}
    	
    	return newMessage;
    }
}