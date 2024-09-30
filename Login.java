package Examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
		public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:/Gaurav/chromedriver-win64/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactin.com/HotelApp/index.php");
		driver.findElement(By.id("username")).sendKeys("Gaurav");
		driver.findElement(By.id("password")).sendKeys("Gaurav@123");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("login"))));
		driver.findElement(By.id("login")).click();
		}
}

