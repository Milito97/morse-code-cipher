package application;
import java.util.Scanner;
import model.MorseEncoder;
import model.MorseMessageDecoder;
import model.MorseMessageEncoder;


public class MCodeApp 
{
    /**
     *  Give a brief description of what main does
     * @throws Exception 
     */
    public static void main(String args[]) throws Exception
    {
        Scanner in = new Scanner(System.in);
        MorseMessageDecoder decoder = new  MorseMessageDecoder();
        MorseMessageEncoder encoder = new  MorseMessageEncoder();
        MorseEncoder encoderTest = new MorseEncoder();
        String message;
        char choice = ' ';
        boolean flag;

        do
        {
            System.out.print ("Enter E (encode), D (decode) or Q(quit): ");
            
            try {
            	flag = true;
                choice = in.nextLine().toUpperCase().charAt(0);
                switch (choice)
                {
                    case 'D':
                    	
                    		while (flag == true) {
                    			
                    			flag = false;
                    			System.out.println ("Enter the message you'd like to decode from Morse Code or enter e to return");
                                message = in.nextLine();
                                
                                if (message.equals("e")) {
                                	break;
                                }
                                
                                try {
                                	
                                	System.out.println (decoder.decodeMessage(message));
                                	
                                } catch (RuntimeException e) {
                                	
                                	flag = true;
                                	System.out.println(e.getMessage());
                                	
                                }
                    			
                    		}
                            
                            break;
                    case 'E':
                            System.out.println ("Enter the message you'd like to encode into Morse Code");
                            message = in.nextLine();
                            System.out.println(encoder.encodeMessage(message));
                            break;
                    case 'T':
                    		encoderTest.loadData();
                    		break;
                    default:   
                }
            }
            catch (StringIndexOutOfBoundsException e )
            {   System.out.println ("Invalid entry - try again");
            }
        } while (choice != 'Q');
    }
}
