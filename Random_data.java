package Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class Random_data {
	public static int Random_num() {
		Random random = new Random();
		int ran_num = random.nextInt(100);
		
		return ran_num;
	
       //double randomDouble = random.nextDouble(); 
       //System.out.println("Random double: " + randomDouble);
		
	}
	
	 public static String MobileNumber() {
         Random random = new Random();
         StringBuilder sb = new StringBuilder();
         
         sb.append(random.nextInt(8) + 2);
         for (int i = 1; i < 10; i++) {
             sb.append(random.nextInt(10));
         }
         return sb.toString();
     }
			
	 public static int Random_selection() {
				Random random = new Random();
				int ran_sel = random.nextInt(2);
				
				return ran_sel;
	}		
	
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
	
	public static String Messages() {
		      Random random = new Random();
		      String[] messages = {
			        "Hello!",
			        "How are you?",
			        "Have a nice day!",
			        "Keep smiling!",
			        "Coding is fun!",
			        "Stay positive!"
			    };
		      int index = random.nextInt(messages.length);
		      String ran_Message = messages[index];
			  return ran_Message;
	}
	
	public static String Subject(Random random) {
		  String[] subjects = {"I", "You", "We", "They", "He", "She"};
	      String[] verbs = {"am", "are", "is", "like", "love", "enjoy"};
	      String[] objects = {"reading", "playing", "learning", "writing"};
	      
	      String subject = subjects[random.nextInt(subjects.length)];
          String verb = verbs[random.nextInt(verbs.length)];
          String object = objects[random.nextInt(objects.length)];
	       
	      String subject1 = subject+" "+verb+" "+object+".";
	      return subject1;
	}
	
	public static String Experiance() {
		      Random random = new Random();
		      String[] experiance = {
			        "Fresher",
			        "Intern",
			        "Experiance",
			        "Senior"
			    };
		      int index = random.nextInt(experiance.length);
		      String ran_experiance = experiance[index];
			  return ran_experiance;
	}
	
	public static String Upload() {
		Random random = new Random();
		String[] upload= {
			"file-example_PDF_1MB",
			"KnownDefects_HotelApp",
			"sample",
			"Sample-TestCases_HotelApplication"
		};
		int index = random.nextInt(upload.length);
	    String ran_upload = upload[index];
		return ran_upload;
	}

	
	
	public static void main(String[] args) {
		
		Random random = new Random();
		String name = Ran_string();
		int num = Random_num();
		//String EmailID = name + num + "@gmail.com" ;
		String Path = "D:/Gaurav/Material/" + Upload() +".pdf";
		
		System.setProperty("webdriver.chrome.driver","D:/Gaurav/chromedriver-win64/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://itechforest.com/");
		
		  WebElement Contact= driver.findElement(By.partialLinkText("Contact Us"));
			Contact.click();
			driver.findElement(By.id("FirstName")).sendKeys(name);
 		    driver.findElement(By.id("LastName")).sendKeys(Ran_string());
		    driver.findElement(By.id("Subject")).sendKeys(Subject(random));
		    driver.findElement(By.id("Email")).sendKeys(name + num + "@gmail.com");
		    driver.findElement(By.id("Message")).sendKeys(Messages());
		    driver.findElement(By.id("btnSave")).click();
		    
		   
		    driver.navigate().back();
			WebElement Career = driver.findElement(By.partialLinkText("Career"));
			Career.click();
			
			driver.findElement(By.id("Name")).sendKeys(name);
		    driver.findElement(By.id("Email")).sendKeys(name + num + "@gmail.com");
		    driver.findElement(By.id("MobileNo")).sendKeys(MobileNumber());
		    driver.findElement(By.id("Experience")).sendKeys(Experiance());
		    WebElement Up = driver.findElement(By.id("ResumeFile"));
		    Up.sendKeys(Path);
		    WebElement a = driver.findElement(By.xpath("//*[@id=\"ApplyFor\"]"));
		    a.click();
		    Select s=new Select(a);
		    s.selectByIndex(Random_selection());
		    WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(60));
		    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnCareer"))));
		    driver.findElement(By.id("btnCareer")).click();
	}
}
