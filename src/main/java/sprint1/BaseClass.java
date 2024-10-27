package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    public static RemoteWebDriver driver;
    WebDriverWait wait;
    String remote = "Yes";  //default value should be Yes
    @BeforeMethod
    public void preSetup() throws InterruptedException, MalformedURLException {
        switch (remote) {
            case "No":
                System.out.println("In Local");
                ChromeOptions chromeoptions = new ChromeOptions();
                chromeoptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeoptions);
                break;
            case "Yes":
                //EdgeOptions edgeOptions = new EdgeOptions();
                //edgeOptions.addArguments("--disable-notifications");
                //DesiredCapabilities dc = new DesiredCapabilities(edgeOptions);
                System.out.println("In Remote");
                ChromeOptions chrome_options = new ChromeOptions();
                chrome_options.addArguments("--disable-notifications");
                DesiredCapabilities dc = new DesiredCapabilities(chrome_options);
                dc.setBrowserName("chrome"); //
                dc.setPlatform(Platform.LINUX);
                driver = new RemoteWebDriver(new
                        URL("http://20.40.48.160:4444/wd/hub"), dc);
                break;
            default:
                System.out.println("Browser is not Configured");
                break;

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@123");
        // driver.get("https://login.salesforce.com/");
        //driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
        //driver.findElement(By.id("password")).sendKeys("Leaf@1234");
        driver.findElement(By.id("Login")).click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeBrowser() {
        //driver.quit();
    }

    public void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void switchFrame(By locator) {
        driver.switchTo().frame(driver.findElement(locator));
    }

    public void windowHandle(RemoteWebDriver driver,int a) {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowList.get(a));
    }

}
