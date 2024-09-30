package Random;

import java.util.Random;

public class Mobileno {
	
	 public static String MobileNumber() {
        
         Random random = new Random();
         StringBuilder sb = new StringBuilder();
    
         sb.append(random.nextInt(8) + 2);
         for (int i = 1; i < 10; i++) {
        	 sb.append(random.nextInt(10));
         }
         
         return sb.toString();
}

	public static void main(String[] args) {
         System.out.println(MobileNumber());
	}

}
