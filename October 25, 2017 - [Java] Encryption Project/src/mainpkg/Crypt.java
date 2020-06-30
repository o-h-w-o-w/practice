package mainpkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class Crypt {
	private static BufferedReader br;
	private static FileReader fr;
	public static String current;
	//start
	public static void encrypt(File file) {
		br = null;
		fr = null;
		try {
			fr = new FileReader(file);
			try {	
				fr = new FileReader(file);
				br = new BufferedReader(fr);
            String line = "";
            StringBuffer stringBuffer = new StringBuffer("");
            // keep reading till readLine returns null
            while ((line = br.readLine()) != null) {
            // keep appending last line read to buffer
            stringBuffer.append(line +  "\n") ;
            }
				current = stringBuffer.toString();
				//**NOTE**:: add 3 random characters after each character of the plain text.
				System.out.println(current);		
				Random rand = new Random();				
				String threeRandomChars = "";
				String[] strArray = new String[current.length()];
				for(int k = 0; k < current.length(); k++) {
					strArray[k] = "" + current.charAt(k);
					for(int i = 0; i < 3; i++) {
						char randChar = (char) (rand.nextInt(126 - 33) + 33);
						threeRandomChars += randChar;
					}
					strArray[k] += threeRandomChars;
					threeRandomChars = "";
				}
				current = "";
				for(String a : strArray)
					current += a;
				//**NOTE**:: convert current encryption text to binary 
				System.out.println(current);
				current = "";
				for(int z = 0; z < strArray.length; z++) {
					current += strArray[z];
				}
				char[] charArray = current.toCharArray();
				current = "";
				for(char i : charArray) {
					String binarySet = Integer.toString(i, 2);
					while (binarySet.length() != 8)
						binarySet = "0" + binarySet;
					current += binarySet;
				}
				//**NOTE**: convert current encryption text to hex by 4 digit pairs
				System.out.println("This is the binary : " +current);
				String temp = current;
				current = "";
				for(int i = 0; i < temp.length() - 4; i += 4) {
     				int fourBinaryDigits = Integer.parseInt(temp.substring(i, i + 4), 2);
					String hexStr = Integer.toString(fourBinaryDigits, 16);
					current += hexStr;
				}
               System.out.println("This is the original hex:" + current);
               StringBuilder sb = new StringBuilder();
               for (int i = 0; i < current.length(); i++) { 
              	  char c = current.charAt(i);
                  if (c >= 'a' && c <= 'm') c += 13;//Rotating 13 places
                  else if  (c >= 'A' && c <= 'M') c += 13;
                  else if  (c >= 'n' && c <= 'z') c -= 13;
                  else if  (c >= 'N' && c <= 'Z') c -= 13;
//                else if  (c >= '0' && c <= '4') c += 2; //  add 2 to numbers 1-4, new numbers will be 3,4 and 6. 5 stays the same
//                else if  (c == '9') c -= 2;      
            	  sb.append(c);
           	   // System.out.println(sb);
        		}
        current = sb.toString(); // Change Stringbuilder to a normal string
        System.out.println("This is the rotated hex:" + current);

        StringBuilder first = new StringBuilder() ; // So you can append to string
        StringBuilder second = new StringBuilder(); // First and Second half of binary
        char [] result_c = current.toCharArray();
        int half = result_c.length/2; // Get middle of array
        	for (int f = 0 ; f < half; f ++){
           		first.append(result_c[f]);
            } 
        	for (int b = half ; b < result_c.length ; b ++){
				second.append(result_c[b]); 
			}   
            System.out.println("This is first :" + first);
            System.out.println("This is 2nd :" + second);
            StringBuilder s = new StringBuilder();
            s.append(second);// Put second half of binary first
            s.append(first);
            current = s.toString();       
			//create cipher text file
			System.out.println("This is the final one: " + current);
			PrintWriter writer = new PrintWriter("ciphertext.txt", "UTF-8");
			writer.print(current);
			writer.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if (br != null) {
				br.close();
				}
				if (fr != null) {
				fr.close();
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
}