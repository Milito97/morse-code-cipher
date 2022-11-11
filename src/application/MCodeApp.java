package application;
import java.util.Scanner;

import model.MorseMessageDecoder;
import model.MorseMessageEncoder;


public class MCodeApp 
{
    /**
     *  Give a brief description of what main does
     */
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        MorseMessageDecoder decoder = new  MorseMessageDecoder();
        MorseMessageEncoder encoder = new  MorseMessageEncoder();
        String message;
        char choice = ' ';

        do
        {
            System.out.print ("Enter E (encode), D (decode) or Q(quit): ");
            try { 
                choice = in.nextLine().toUpperCase().charAt(0);
                switch (choice)
                {
                    case 'D':
                            System.out.println ("Enter the message you'd like to decode from Morse Code");
                            message = in.nextLine();
                            //System.out.println (decoder.decodeMessage(message)); 
                            break;
                    case 'E':
                            System.out.println ("Enter the message you'd like to encode into Morse Code");
                            message = in.nextLine();
                            //System.out.println (encoder.encodeMessage(message));
                    default:   
                }
            }
            catch (StringIndexOutOfBoundsException e )
            {   System.out.println ("Invalid entry - try again");
            }
        } while (choice != 'Q');
    }
}
