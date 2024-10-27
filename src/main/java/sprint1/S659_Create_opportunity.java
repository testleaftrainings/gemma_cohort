package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S659_Create_opportunity {
	
	@Test
	public void createOpportunity() throws InterruptedException, MalformedURLException {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	DesiredCapabilities dc = new DesiredCapabilities(option);
	dc.setBrowserName("chrome");;
	dc.setPlatform(Platform.LINUX);
	@SuppressWarnings("deprecation")
	RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"),dc);
	//ChromeDriver driver = new ChromeDriver(option);
	driver.get("https://login.salesforce.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Leaf@123");
	driver.findElement(By.id("Login")).click();
	WebElement menu = driver.findElement(By.xpath("//button[@title='App Launcher']"));
	wait.until(ExpectedConditions.elementToBeClickable(menu));
	js.executeScript("arguments[0].click();", menu);
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	WebElement content = driver.findElement(By.xpath("//p[text()='Content']"));
	wait.until(ExpectedConditions.elementToBeClickable(content));
	content.click();
	WebElement viewkey = driver.findElement(By.xpath("//span[text()='View All Key Deals']/parent::a"));
	wait.until(ExpectedConditions.elementToBeClickable(viewkey));
	js.executeScript("arguments[0].click();", viewkey);
	WebElement oppdrdw = driver.findElement(By.xpath("//span[text()='Recently Viewed']/parent::h1"));
	wait.until(ExpectedConditions.elementToBeClickable(oppdrdw));
	js.executeScript("arguments[0].click();", oppdrdw);
	WebElement allopp = driver.findElement(By.xpath("//span[text()='All Opportunities']/parent::a"));
	wait.until(ExpectedConditions.elementToBeClickable(allopp));
	js.executeScript("arguments[0].click();", allopp);
	Thread.sleep(3000);
	WebElement newbtn = driver.findElement(By.xpath("//div[text()='New']/ancestor::a"));
	js.executeScript("arguments[0].scrollIntoView(true)", newbtn);
	wait.until(ExpectedConditions.elementToBeClickable(newbtn));
	js.executeScript("arguments[0].click();", newbtn);
	//js.executeScript("document.getElementByXpath('//h2[text()='New Opportunity']/ancestor::records-lwc-detail-panel').style.display='none';");
	WebElement opprname = driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input"));
	wait.until(ExpectedConditions.elementToBeClickable(opprname));
	js.executeScript("arguments[0].click();", opprname);
	opprname.sendKeys("SRM Steels");
	WebElement type = driver.findElement(By.xpath("//label[text()='Type']/following::button"));
	wait.until(ExpectedConditions.elementToBeClickable(type));
	js.executeScript("arguments[0].click();", type);
	WebElement typeopt = driver.findElement(By.xpath("//span[text()='New Customer']/parent::span"));
	wait.until(ExpectedConditions.elementToBeClickable(typeopt));
	js.executeScript("arguments[0].click();", typeopt);
	WebElement leadsrc = driver.findElement(By.xpath("//label[text()='Lead Source']/following::button"));
	wait.until(ExpectedConditions.elementToBeClickable(leadsrc));
	js.executeScript("arguments[0].click();", leadsrc);
	WebElement leadsrcval = driver.findElement(By.xpath("//span[text()='Partner Referral']/parent::span"));
	wait.until(ExpectedConditions.elementToBeClickable(leadsrcval));
	js.executeScript("arguments[0].click();", leadsrcval);
	driver.findElement(By.xpath("//label[text()='Amount']/following::input")).sendKeys("75000");
	WebElement stage = driver.findElement(By.xpath("//label[text()='Stage']/following::button"));
	wait.until(ExpectedConditions.elementToBeClickable(stage));
	js.executeScript("arguments[0].scrollIntoView(true)", stage);
	js.executeScript("arguments[0].click();", stage);
	WebElement stageval = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
	wait.until(ExpectedConditions.elementToBeClickable(stageval));
	js.executeScript("arguments[0].click();", stageval);
	WebElement primCamp = driver.findElement(By.xpath("//label[text()='Primary Campaign Source']/following::input"));
	wait.until(ExpectedConditions.elementToBeClickable(primCamp));
	js.executeScript("arguments[0].click();", primCamp);
	WebElement primcampVal = driver.findElement(By.xpath("//h3[text()='Recent Campaigns']/following::li"));
	wait.until(ExpectedConditions.elementToBeClickable(primcampVal));
	js.executeScript("arguments[0].click();", primcampVal);
	WebElement closedate = driver.findElement(By.xpath("//label[text()='Close Date']/following::input"));
	js.executeScript("arguments[0].click();", closedate);
	LocalDate currentDate = LocalDate.now();
	//Giving month
	Month month = currentDate.getMonth().plus(1);
	String expmonth=""+month;
	//Giving year
	int year = currentDate.getYear()+1;
	String taryear = ""+year;
	//Giving date
	String expdate = "20";
	//selecting year drop down and handling using select class
	WebElement datepcikericon = driver.findElement(By.xpath("//label[text()='Close Date']/following::button[contains(@title,'Close Date')]"));
	wait.until(ExpectedConditions.elementToBeClickable(datepcikericon));
	js.executeScript("arguments[0].click();", datepcikericon);
	//select attribute to select drop down value
	WebElement taryearele = driver.findElement(By.xpath("//div[contains(@class,'datepicker')]/following::select"));
	wait.until(ExpectedConditions.elementToBeClickable(taryearele));
	Select dropdown = new Select(taryearele);
	dropdown.selectByValue(taryear);
	String actmonth = driver.findElement(By.xpath("//div[contains(@class,'month')]//h2")).getText();
	while(true) {
		if(expmonth.equalsIgnoreCase(actmonth))
			break;
		else {
			WebElement datefw = driver.findElement(By.xpath("//button[@title='Next Month']"));
			wait.until(ExpectedConditions.elementToBeClickable(datefw));
			js.executeScript("arguments[0].click();", datefw);
			break;
		}
				
	}
	
	List<WebElement> dateeles = driver.findElements(By.xpath("//table[contains(@class,'datepicker')]//td"));
	for(WebElement ele: dateeles) {
		String dt = ele.getText();
		if(dt.equals(expdate)) {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			break;
		}
	}
	
	
	WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	wait.until(ExpectedConditions.elementToBeClickable(save));
	js.executeScript("arguments[0].click();", save);
	driver.findElement(By.xpath("//span[text()='Opportunity']/ancestor::div[@role='alert']")).isDisplayed();
	
	}

}
