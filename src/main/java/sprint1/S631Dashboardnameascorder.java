package sprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S631Dashboardnameascorder {
	
	
	@Test
	public void dashboardnameascendingOrder() throws Exception {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		//https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		//Click on the toggle menu button from the left corner
		WebElement menu = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		wait.until(ExpectedConditions.elementToBeClickable(menu));
		js.executeScript("arguments[0].click();", menu);
		//Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement dashboard = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		js.executeScript("arguments[0].scrollIntoView(true)", dashboard);
		wait.until(ExpectedConditions.elementToBeClickable(dashboard));
		js.executeScript("arguments[0].click();", dashboard);
		//Click the sort arrow in the Dashboard Name.
		Thread.sleep(3000);
		//Verify dashbaord names BEFORE clicking Dashboard names. 
		String actualRowCount = driver.findElement(By.xpath("//span[contains(@class,'countSorted')]")).getText().toString();
		String[] split = actualRowCount.split(" ");
		//System.out.println("The length of split is "+split.length);
		int rowCountaftRef = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']")).size();
		String rowcountStr=""+rowCountaftRef;
		List<String> listbeforeasc = new ArrayList<>();
		if(split.length > 0 && !rowcountStr.equals(split[0])) {
			for(int i=0;i<rowCountaftRef;i++) {
			List<WebElement> elements = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']"));
			WebElement targetElement = elements.get(elements.size()-1);
			action.moveToElement(targetElement).perform();
			}
		}
		List<WebElement> elements = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']"));
		for(WebElement ele: elements) {
			listbeforeasc.add(ele.getText().toString());
		}
		Collections.sort(listbeforeasc);
		System.out.println(listbeforeasc);
		//Verify dashbaord names AFTER clicking Dashboard names
		WebElement dahshnamebutton = driver.findElement(By.xpath("//span[text()='Dashboard Name']/parent::a"));
		js.executeScript("arguments[0].click();", dahshnamebutton);
		Thread.sleep(3000);
		WebElement dashtab = driver.findElement(By.xpath("//span[text()='Dashboards']/parent::a"));
		wait.until(ExpectedConditions.elementToBeClickable(dashtab));
		js.executeScript("arguments[0].click();", dashtab);
		WebElement dashgrid = driver.findElement(By.xpath("//span[text()='Dashboard Name']/parent::a"));
		wait.until(ExpectedConditions.elementToBeClickable(dashgrid));
		js.executeScript("arguments[0].click();", dashgrid);
		List<String> listaftoreasc = new ArrayList<>();
		for(int j=0;j<rowCountaftRef;j++) {
			List<WebElement> eleaftref = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']"));
			WebElement targetElement1 = eleaftref.get(eleaftref.size()-1);
			action.moveToElement(targetElement1).perform();
			}
		
		List<WebElement> refele = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']"));
		for(WebElement elm: refele) {
			listaftoreasc.add(elm.getText().toString());
		}
		Collections.sort(listaftoreasc);
		System.out.println(listaftoreasc);
		boolean equals = listbeforeasc.equals(listaftoreasc);
		if(!equals) {
			throw new Exception("List does not match");
			
		}
		//driver.quit();
	}

}
