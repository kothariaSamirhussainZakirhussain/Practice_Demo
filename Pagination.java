package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Pagination {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            driver.get("https://ttstage.addwebprojects.com/login");

            // Login
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            usernameField.sendKeys("saurabhdhariwal.com@gmail.com"); // Replace with your username

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("addweb123"); // Replace with your password

            WebElement loginButton = driver.findElement(By.id("submit-login"));
            loginButton.click();

            // Wait for and click side menu
            WebElement sideMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sideMenuScroll\"]/ul/li[5]")));
            scrollToElement(driver, sideMenu);
            safeClick(driver, sideMenu);
            
            WebElement subMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sideMenuScroll > ul > li.accordionItem.openIt > div > a:nth-child(2)")));
            scrollToElement(driver, subMenu);
            safeClick(driver, subMenu);

            List<String> names = new ArrayList<>();
            boolean hasNextPage = true;

            while (hasNextPage) {
                List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("table tbody tr")));
                System.out.println("Number of rows on this page: " + rows.size());
                for (WebElement row : rows) {
                    try {
                        String name = row.findElement(By.cssSelector("td:nth-child(1)")).getText();
                        names.add(name);
                    } catch (Exception e) {
                        System.out.println("Error extracting name from row: " + e.getMessage());
                    }
                }

                List<WebElement> paginationLinks = driver.findElements(By.cssSelector("ul.pagination > li > a"));
                if (paginationLinks.size() > 1) {
                    WebElement nextPageLink = paginationLinks.get(paginationLinks.size() - 1);
                    if (nextPageLink.getText().equalsIgnoreCase("Next") && nextPageLink.isEnabled()) {
                        scrollToElement(driver, nextPageLink);
                        safeClick(driver, nextPageLink);
                        wait.until(ExpectedConditions.stalenessOf(rows.get(0)));
                    } else {
                        hasNextPage = false;
                    }
                } else {
                    hasNextPage = false;
                }
            }

            for (String name : names) {
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private static void safeClick(WebDriver driver, WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }
}
