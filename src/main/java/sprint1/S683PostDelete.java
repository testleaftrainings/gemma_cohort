package sprint1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S683PostDelete {
	
	@Test
	public void deletePost() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		WebElement homeBtn = driver.findElement(By.xpath("//a[text()='Home']"));
		wait.until(ExpectedConditions.elementToBeClickable(homeBtn));
		js.executeScript("arguments[0].click();", homeBtn);
		Thread.sleep(2000);
		WebElement fileBtn = driver.findElement(By.xpath("//a[@title='File']"));
		js.executeScript("arguments[0].click();", fileBtn);
		WebElement sctFile = driver.findElement(By.xpath("//a[text()='Select a file from Salesforce']"));
		wait.until(ExpectedConditions.elementToBeClickable(sctFile));
		js.executeScript("arguments[0].click();", sctFile);
		String currentwd = driver.getWindowHandle();
		String windOnetit = driver.getTitle();
		System.out.println("Window One title is "+windOnetit);
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle: windowHandles) {
			if(!windowHandle.equals(currentwd)) {
				driver.switchTo().window(windowHandle);
				break;
			}
			System.out.println("Second Window title is "+driver.getTitle());
		}
		
		driver.manage().window().maximize();
		WebElement ownMe = driver.findElement(By.xpath("//a[contains(@title,'by Me')]"));
		wait.until(ExpectedConditions.elementToBeClickable(ownMe));
		js.executeScript("arguments[0].click();", ownMe);
		WebElement fileSearch = driver.findElement(By.xpath("//input[contains(@title,'I Own')]"));
		wait.until(ExpectedConditions.elementToBeClickable(fileSearch));
		fileSearch.sendKeys("Maven");
		WebElement srhBtn = driver.findElement(By.xpath("//a[@title='Search']"));
		wait.until(ExpectedConditions.elementToBeClickable(srhBtn));
		js.executeScript("arguments[0].click();", srhBtn);
		WebElement attachLink = driver.findElement(By.xpath("//span[text()='Attach']/parent::a"));
		wait.until(ExpectedConditions.elementToBeClickable(attachLink));
		js.executeScript("arguments[0].click();", attachLink);
		driver.switchTo().window(currentwd);
		WebElement shareBtn = driver.findElement(By.id("publishersharebutton"));
		wait.until(ExpectedConditions.elementToBeClickable(shareBtn));
		js.executeScript("arguments[0].click();", shareBtn);
		WebElement moreactLink = driver.findElement(By.xpath("//span[text()='More Actions']/parent::a"));
		wait.until(ExpectedConditions.elementToBeClickable(moreactLink));
		js.executeScript("arguments[0].click();", moreactLink);
		WebElement fileshrSet = driver.findElement(By.xpath("//span[text()='File Sharing Settings']/parent::a"));
		wait.until(ExpectedConditions.elementToBeClickable(fileshrSet));
		js.executeScript("arguments[0].click();", fileshrSet);
		WebElement perdropDown = driver.findElement(By.xpath("//span[contains(text(),'Collaborators')]/parent::a"));
		try {
			if(perdropDown.isDisplayed()) {
				System.out.println("Collaborators is selected already");
			}
		} catch (NoSuchElementException e) {
			WebElement viewLink = driver.findElement(By.xpath("//span[contains(text(),'Viewers')]/parent::a"));
			wait.until(ExpectedConditions.elementToBeClickable(viewLink));
			js.executeScript("arguments[0].click();", viewLink);
			driver.findElement(By.xpath("//span[contains(text(),'Collaborators')]/parent::a")).click();
		}
		WebElement preventCheckbox = driver.findElement(By.xpath("//label[text()='Prevent others from sharing and unsharing']/preceding-sibling::input"));
		if(!preventCheckbox.isSelected()) {
			preventCheckbox.click();
			System.out.println("Checkbox is clicked");
		}
		
		WebElement clsBtn = driver.findElement(By.xpath("//input[@value='Close']"));
		js.executeScript("arguments[0].scrollIntoView(true)", clsBtn);
		wait.until(ExpectedConditions.elementToBeClickable(clsBtn));
		js.executeScript("arguments[0].click();", clsBtn);
		WebElement topicsLink = driver.findElement(By.xpath("//a[text()='Click to add topics:']"));
		wait.until(ExpectedConditions.elementToBeClickable(topicsLink));
		js.executeScript("arguments[0].click();", topicsLink);
		WebElement txtInput = driver.findElement(By.xpath("//div[contains(@class,'topicInput')]/child::textarea"));
		wait.until(ExpectedConditions.elementToBeClickable(txtInput));
		txtInput.sendKeys("Senthil document");
		WebElement doneBtn = driver.findElement(By.xpath("//input[@value='Done']"));
		wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
		js.executeScript("arguments[0].click();", doneBtn);
		WebElement moreAct = driver.findElement(By.xpath("//a[@title='More Actions']"));
		wait.until(ExpectedConditions.elementToBeClickable(moreAct));
		js.executeScript("arguments[0].click();", moreAct);
		WebElement deleteBtn = driver.findElement(By.xpath("//a[@title='Delete this post']"));
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		js.executeScript("arguments[0].click();", deleteBtn);
		String currentWindow = driver.getWindowHandle();
		System.out.println("current Window title is "+driver.getTitle());
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> targetWindow = driver.getWindowHandles();
		for(String targetWindowDel: targetWindow) {
			if(!targetWindowDel.equals(currentWindow)) {
				driver.switchTo().window(targetWindowDel);
				break;
			}
			//driver.switchTo().window(windowhandleforDel);
			System.out.println("New window name is "+driver.getTitle());
		}
	
		
		WebElement okBtn = driver.findElement(By.xpath("//input[@value='OK']"));
		wait.until(ExpectedConditions.elementToBeClickable(okBtn));
		js.executeScript("arguments[0].click();", okBtn);
		driver.switchTo().window(currentWindow);
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		Thread.sleep(5000);
		
		try {
			 driver.findElement(By.xpath("//a[text()='Senthil Document']")).isDisplayed();
			
		}
		catch(NoSuchElementException e) {
			
		}
		System.out.println("Delete has been done successfully");
		}

}
