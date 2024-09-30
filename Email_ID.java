package Random;

import java.util.Random;

public class Email_ID {
	
	public static String Ran_string() {
		 Random random = new Random();
		 int length = 10; 
		 String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		 StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            sb.append(characters.charAt(index));
	        }
        String ran_string = sb.toString();
		return ran_string;
		
	}
	
	public static int Random_num() {
		Random random = new Random();
		int ran_num = random.nextInt(100);
		
		return ran_num;
	
       //double randomDouble = random.nextDouble(); 
       //System.out.println("Random double: " + randomDouble);
		
	}

	public static void main(String[] args) {
	    	
     System.out.println(Ran_string() + Random_num() + "@gmail.com");
	}

}
