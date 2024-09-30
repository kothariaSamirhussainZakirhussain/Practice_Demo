package Amazon;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipcart {
	public static void main(String[] args) throws IOException, Exception {
		        System.setProperty("webdriver.chrome.driver","D:/Gaurav/chromedriver-win64/chromedriver.exe");
		        ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.flipkart.com/");
				WebElement web = driver.findElement(By.xpath(".//*[text()='Electronics']"));
				Actions a=new Actions(driver);
				a.moveToElement(web).perform();
				Thread.sleep(2000);
				WebElement Mobilecase = driver.findElement(By.className("jBYtJt"));
				a.moveToElement(Mobilecase).click().perform();
				String s = driver.getCurrentUrl();
				if(s.equals("https://www.flipkart.com/mobile-accessories/cases-andcovers/pr?sid=tyy,4mr,q2u&otracker=nmenu_sub_Electronics_0_Mobile%20Cases")){
				System.out.println("u r in mobile case page");
				}else
				{
				System.out.println("u r not in mobile case");
				}
				Thread.sleep(3000);
				TakesScreenshot tk=(TakesScreenshot) driver;
				File f = tk.getScreenshotAs(OutputType.FILE);
				File f1=new File("F:/flipkart mobile case.png");
				FileUtils.copyFile(f,f1 );
	}

}
