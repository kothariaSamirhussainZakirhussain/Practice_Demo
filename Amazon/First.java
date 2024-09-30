package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class First {

	   public static void main(String[] args) {
		 
		  WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("https://www.amazon.com/");
	      
	      WebElement n=driver.findElement(By.id("nav-link-accountList"));
	     
	      Actions a = new Actions(driver);
	      a.moveToElement(n).perform();
	      
	      WebElement m=driver.findElement(By.partialLinkText("Account"));
	      a.moveToElement(m).click().perform();
	      driver.findElement(By.id("createAccountSubmit")).click();
	      
	      driver.findElement(By.id("ap_customer_name")).sendKeys("Gaurav");
	      driver.findElement(By.id("ap_email")).sendKeys("Gauravzalavadiya123@gmail.com");
	      WebElement pass = driver.findElement(By.id("ap_password"));
	      pass.sendKeys("Gaurav@123");
	      WebElement repass = driver.findElement(By.id("ap_password_check"));
	      repass.sendKeys("Gaurav@123");
	      
	      if(pass.getText()==repass.getText()) {
	          driver.findElement(By.id("continue")).click();	  
	      }
	      else {
	    	  System.out.println("Password not matched");
	      }
	      driver.close();
	      
	      driver = new ChromeDriver();
	      driver.get("https://www.amazon.com");
	      driver.manage().window().maximize();
	    
	      driver.navigate().to("https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/");
	      WebElement ind = driver.findElement(By.className("a-dropdown-prompt"));
		  ind.click();
	      Select s= new Select(ind);
	      s.selectByValue("India");
	      driver.findElement(By.className("a-button-input")).click();
		     
	      driver.findElement(By.id("twotabsearchtextbox")).sendKeys(" infinix gt 20 pro");
	      driver.findElement(By.id("nav-search-submit-button")).click();
	      driver.findElement(By.id("twotabsearchtextbox")).clear();
	      driver.findElement(By.id("twotabsearchtextbox")).sendKeys(" infinix gt 20 pro bgmi mobile");
	      driver.findElement(By.id("nav-search-submit-button")).click();
	      driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div/img")).click();
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("window.scrollBy(0,500)");
	      js.executeScript("window.scrollBy(0,1500)");
	      
	      driver.findElement(By.xpath("//*[@id=\"a-autoid-10-announce\"]/div"));
	      driver.findElement(By.id("add-to-cart-button")).click();
	        
	      js.executeScript("window.scrollBy(0,-500)");
	      driver.findElement(By.className("nav-cart-count")).click();
	   }
	}