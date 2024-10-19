package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {
    ChromeDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void preSetup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf$321");
        driver.findElement(By.id("Login")).click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeBrowser() {
       driver.quit();
    }


    public void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void switchFrame(By locator) {
        driver.switchTo().frame(driver.findElement(locator));
    }
}
