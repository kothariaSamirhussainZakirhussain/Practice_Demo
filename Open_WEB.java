//package Test_CRM;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Open_WEB {
//
//	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver","D:/Gaurav/chromedriver-win64/chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		
//		// Open Web page 
//		driver.get("https://weekly.flow-ctrl.com:91/Dashboard#");
//		
//		// Login With Username devadmin
//		driver.findElement(By.id("UserName")).sendKeys("devadmin");
//		driver.findElement(By.id("Password")).sendKeys("Dev123456@Vv");
//		driver.findElement(By.id("btnsubmit")).click();
//		
//		//Close Analytics Chart tab
//		WebElement Chart = driver.findElement(By.xpath("//*[@id=\"collapse-btn\"]/a"));
//		Chart.click();
//		
//	    // Move on  Inventory Tab
//		WebElement Inventory = driver.findElement(By.partialLinkText("Inventory"));
//		Inventory.click();
//		
//		// Move on  Manufacturing Tab
//		WebElement Manufacturing = driver.findElement(By.partialLinkText("Manufacturing"));
//	    Manufacturing.click();
//	    
//		// Move on  Inventory Tab
//		WebElement Sales = driver.findElement(By.partialLinkText("Sales"));
//		Sales.click();
//		
//	    // Move on  Inventory Tab
//		WebElement Purchasing = driver.findElement(By.partialLinkText("Purchasing"));
//	    Purchasing.click();
//		
//	    // Move on  Inventory Tab
//		WebElement Inventory = driver.findElement(By.partialLinkText("Inventory"));
//	    Inventory.click();
//	    
//		// Move on  Inventory Tab
//		WebElement Inventory = driver.findElement(By.partialLinkText("Inventory"));
//	    Inventory.click();
//	    
//	}
//}
