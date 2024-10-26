package sprint1;





	import java.net.URL;
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.Platform;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	public class S660AddOpportunityinProduct {
		
		@Test
		public void addOpprtunityinProduct() throws Exception {
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			DesiredCapabilities dc = new DesiredCapabilities(option);
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.LINUX);
			@SuppressWarnings("deprecation")
			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"),dc);
//			ChromeDriver driver = new ChromeDriver(option);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Actions action = new Actions(driver);
			driver.get("https://login.salesforce.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Leaf@123");
			driver.findElement(By.id("Login")).click();
//			Click on toggle menu button from the left corner
			WebElement menu = driver.findElement(By.xpath("//button[@title='App Launcher']"));
			wait.until(ExpectedConditions.elementToBeClickable(menu));
			js.executeScript("arguments[0].click();", menu);
//			Click view All
			driver.findElement(By.xpath("//button[text()='View All']")).click();
//	  		Click on Content tab 
			WebElement content = driver.findElement(By.xpath("//p[text()='Content']"));
			wait.until(ExpectedConditions.elementToBeClickable(content));
			js.executeScript("arguments[0].click();", content);
//			Click View All Key Deals in Key Deals 		
			WebElement viewKey = driver.findElement(By.xpath("//span[text()='View All Key Deals']/parent::a"));
			wait.until(ExpectedConditions.elementToBeClickable(viewKey));
			js.executeScript("arguments[0].click();", viewKey);
//			Click the dropdown from Opportunities and select All Opportunities
			WebElement selectoppor = driver.findElement(By.xpath("//span[text()='Recently Viewed']/parent::h1"));
			wait.until(ExpectedConditions.elementToBeClickable(selectoppor));
			js.executeScript("arguments[0].click();", selectoppor);
			WebElement allOpr = driver.findElement(By.xpath("//span[text()='All Opportunities']"));
			wait.until(ExpectedConditions.elementToBeClickable(allOpr));
			js.executeScript("arguments[0].click();", allOpr);
			Thread.sleep(3000);
			WebElement oprSearch = driver.findElement(By.xpath("//label[contains(text(),'Search this list')]/following::input"));
			wait.until(ExpectedConditions.elementToBeClickable(oprSearch));
			js.executeScript("arguments[0].click();", oprSearch);
			oprSearch.sendKeys("SRM Steels");
			Thread.sleep(3000);
			oprSearch.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			WebElement oprName = driver.findElement(By.xpath("//span[text()='Opportunity Name']/following::a[text()='SRM Steels']"));
			wait.until(ExpectedConditions.elementToBeClickable(oprName));
			js.executeScript("arguments[0].click();", oprName);
//			Click on dropdown of Products under Related and select Add Products
			WebElement proddrpdw = driver.findElement(By.xpath("//span[text()='Products']/following::a"));
			wait.until(ExpectedConditions.elementToBeClickable(proddrpdw));
			js.executeScript("arguments[0].click();", proddrpdw);
			WebElement addprod = driver.findElement(By.xpath("//div[@title='Add Products']/parent::a"));
			wait.until(ExpectedConditions.elementToBeClickable(addprod));
			js.executeScript("arguments[0].click();", addprod);
//			Click on List Price to sort the result and select the highest priced product
			WebElement price = driver.findElement(By.xpath("//span[@title='List Price']/parent::a"));
			wait.until(ExpectedConditions.elementToBeClickable(price));
			js.executeScript("arguments[0].click();", price);
			Thread.sleep(3000);
			List<WebElement> listprices = driver.findElements(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//td//span[contains(@class,'Currency')]"));
			List<String> eletext = new ArrayList<>();
			for(WebElement ele: listprices) {
				eletext.add(ele.getText());
			}
			System.out.println(eletext);
			List<Integer> intList = new ArrayList<>();
			for(String str: eletext) {
				String replace = str.replaceAll("[₹,]", "").replace(".", "");
				intList.add(Integer.parseInt(replace));
			}
			System.out.println("Integer list is "+intList);
			int max = intList.get(0);
			for(int num: intList) {
				if(num>max) {
					max=num;
				}
			}
			System.out.println("Highest total price is "+max);
			String intstrVal = String.valueOf(max);
			for(WebElement ele: listprices) {
				String text = ele.getText();
				String replace = text.replaceAll("[₹,]", "").replace(".", "");
				if(replace.equals(intstrVal)) {
					action.moveToElement(ele).perform();
					js.executeScript("arguments[0].click();", ele);
					for(int i=0;i<=2;i++) {
						action.sendKeys(Keys.ARROW_LEFT).perform();
						Thread.sleep(3000);
					}
					action.sendKeys(Keys.SPACE).perform();
					Thread.sleep(3000);
					
				}
			}
				WebElement next = driver.findElement(By.xpath("//button[@title='Next']"));
				wait.until(ExpectedConditions.elementToBeClickable(next));
				js.executeScript("arguments[0].click();", next);
				String prodName = driver.findElement(By.xpath("//span[text()='Product']/following::a")).getText();
				WebElement quant = driver.findElement(By.xpath("//button[contains(@title,'Edit Quantity')]"));
				wait.until(ExpectedConditions.elementToBeClickable(quant));
				js.executeScript("arguments[0].click();", quant);
				WebElement quantity = driver.findElement(By.xpath("//label[text()='Quantity']/following::input"));
				wait.until(ExpectedConditions.elementToBeClickable(quantity));
				quantity.sendKeys("1305");
				WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
				wait.until(ExpectedConditions.elementToBeClickable(save));
				js.executeScript("arguments[0].click();", save);
				driver.findElement(By.xpath("//span[text()='1 Opportunity Product record was updated.']")).isDisplayed();
//				Verrify the Sales Price and Product Name Expected result
				WebElement parent = driver.findElement(By.xpath("//span[text()='Products']/parent::a"));
				wait.until(ExpectedConditions.elementToBeClickable(parent));
				js.executeScript("arguments[0].click();", parent);
				WebElement filter = driver.findElement(By.xpath("//button[@title='Show quick filters']"));
				wait.until(ExpectedConditions.elementToBeClickable(filter));
				js.executeScript("arguments[0].click();", filter);
				WebElement minQuan = driver.findElement(By.xpath("//input[contains(@name,'Quantity-min')]"));
				wait.until(ExpectedConditions.elementToBeClickable(minQuan));
				minQuan.sendKeys("1305");
				WebElement maxQuan = driver.findElement(By.xpath("//input[contains(@name,'Quantity-max')]"));
				wait.until(ExpectedConditions.elementToBeClickable(maxQuan));
				maxQuan.sendKeys("1305");
				driver.findElement(By.xpath("//button[@title='Apply']")).click();
				Thread.sleep(3000);
				List<WebElement> elements = driver.findElements(By.xpath("//span[text()='Product']/following::a[@data-refid='recordId']"));
				List<String> prodText = new ArrayList<>();
				for(WebElement txt: elements)
					prodText.add(txt.getText());
				System.out.println(prodText);
				boolean prodnameContains = prodText.contains(prodName);
				if(prodnameContains) {
					System.out.println("Product name matched");
				}
				else
					throw new Exception("Product name does not matched");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@title='Sales Price']/parent::a")).click();
				Thread.sleep(3000);
				List<WebElement> curr = driver.findElements(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//td//span[contains(@class,'Currency')]"));
				List<String> getCurr = new ArrayList<>();
				for(WebElement ele : curr) {
					String replace = ele.getText().replaceAll("[₹,]", "").replace(".", "");
					if(!replace.isEmpty())
					getCurr.add(replace);
				}
				boolean priceContains = getCurr.contains(String.valueOf(max));
				if(priceContains) {
					System.out.println("Price also matched");
				}
				else
					throw new Exception("Price does not matched");
					
				}
					
		}
		
		
			
			





