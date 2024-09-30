package Examples;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Resolution {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver","D:/Gaurav/chromedriver-win64/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://itechforest.com/");
		driver.manage().window().setSize(new Dimension(325,658));
	}
}
