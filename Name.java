package Random;

import java.util.Random;

public class Name {

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
	
	public static void main(String[] args) {
		String name = Ran_string();
		System.out.println(name);
	}
}
