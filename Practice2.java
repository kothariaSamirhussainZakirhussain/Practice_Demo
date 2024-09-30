package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Practice2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int count;
        List<String> matchedData = new ArrayList<>();
        
        try {
            driver.get("https://ttstage.addwebprojects.com/login");

            // Locate and enter username
            WebElement usernameField = driver.findElement(By.id("email"));
            usernameField.sendKeys("saurabhdhariwal.com@gmail.com"); // Replace with your username

            // Locate and enter password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("addweb123"); // Replace with your password

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.id("submit-login"));
            loginButton.click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("/html/body/aside/div[2]/div[2]/ul/li[2]/a")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"sideMenuScroll\"]/ul/li[2]/div/a[3]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[3]/div/div/button")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[3]/div/div/div/div[2]/ul/li[1]/a")).click();

            Thread.sleep(2000);
            count = 0;
            String expectedTitle = "22test";
            boolean found = false;

            // Wait for the table to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div[4]/div[2]/table/tbody")));

            // Get all rows of the table (assuming the rows have a similar structure)
            List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"followup-table\"]/tbody/tr"));

            // Iterate through each row and verify the title
            for (WebElement row : rows) {
                WebElement actualTitleElement = row.findElement(By.xpath("td[2]/h5"));
                String actualTitle = actualTitleElement.getText();
                System.out.println("Actual title: " + count++ + " : " + actualTitle);

                // Verify if the actual title matches the expected title
                if (actualTitle.equals(expectedTitle)) {
                    System.out.println("Verification successful");

                    // Extract all data from the matching row and add to the list
                    List<WebElement> columns = row.findElements(By.tagName("td"));
                    StringBuilder rowData = new StringBuilder();
                    for (int i = 0; i < columns.size(); i++) {
                        rowData.append("Column ").append(i + 1).append(": ").append(columns.get(i).getText()).append(" | ");
                    }
                    matchedData.add(rowData.toString());
                    
                    found = true;
                }
            }

            // Print all matched data at the end
            if (found) {
                System.out.println("Matched data:");
                for (String data : matchedData) {
                    System.out.println(data);
                }
            } else {
                System.out.println("Title not found in the table.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
