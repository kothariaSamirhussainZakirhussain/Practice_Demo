package Random;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Selection {
	
	public static int Random_selection() {
		Random random = new Random();
		int ran_sel = random.nextInt(2);
		
		return ran_sel;
    }		
	public static void main(String[] args) {
		  
		    // WebElement Up = driver.findElement(By.id("ResumeFile"));
		    //Up.sendKeys(Path);
		    //WebElement a = driver.findElement(By.xpath("//*[@id=\"ApplyFor\"]"));
		    //a.click();
		    //Select s=new Select(a);
		    //s.selectByIndex(Random_selection());
		System.out.println(Random_selection());
	}

}
