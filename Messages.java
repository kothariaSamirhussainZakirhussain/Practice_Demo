package Examples;

import java.util.Random;

public class Messages {
	    private static String[] messages = {
	        "Hello!",
	        "How are you?",
	        "Have a nice day!",
	        "Keep smiling!",
	        "Coding is fun!",
	        "Stay positive!"
	    };
	    private static String[] subjects = {"I", "You", "We", "They", "He", "She"};
        private static String[] verbs = {"am", "are", "is", "like", "love", "enjoy"};
        private static String[] objects = {"coding", "reading", "playing", "learning", "writing"};
        
        public static String generateRandomMessage(Random random) {
            String subject = subjects[random.nextInt(subjects.length)];
            String verb = verbs[random.nextInt(verbs.length)];
            String object = objects[random.nextInt(objects.length)];

            return subject + " " + verb + " " + object + ".";
        }
        
        public static String generateRandomMobileNumber() {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            // Ensure the first digit is between 2 and 9 (to avoid leading zero in phone numbers)
            sb.append(random.nextInt(8) + 2);

            // Generate remaining 9 digits
            for (int i = 1; i < 10; i++) {
                sb.append(random.nextInt(9));
            }
            return sb.toString();
        }

	    public static void main(String[] args) {
	        // Generate a random index
	        Random random = new Random();
	        int index = random.nextInt(messages.length);

	        // Retrieve and print the random message
	        String randomMessage = messages[index];
	        System.out.println("Random Message: " + randomMessage);

            String randomMessage1 = generateRandomMessage(random);
            System.out.println("Random Message: " + randomMessage1);
            
            String phoneNumber = generateRandomMobileNumber();
            System.out.println("Random mobile number: " + phoneNumber);
	    }
}



