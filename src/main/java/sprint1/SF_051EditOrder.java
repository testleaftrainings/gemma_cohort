package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SF_051EditOrder extends  BaseClass {

    @Test
    public void tc_051EditOrder() throws InterruptedException {
        String contractName = "00000133";
        String accountName = "Testleaf Software";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]")).sendKeys("Service console");
        waitForElementVisible(By.xpath("//p/mark[text()='Service Console']"));
        driver.findElement(By.xpath("//p/mark[text()='Service Console']")).click();
        driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@title='Orders']")).click();
        WebElement eleDropDown=driver.findElement(By.xpath("(//table[@aria-label='Recently Viewed']//tr/td[8]//a)[1]"));
        js.executeScript("arguments[0].click();", eleDropDown);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@title='Edit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@title='Clear Selection'])[1]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Contract Number')]//following-sibling::div//input")).sendKeys(contractName);
        driver.findElement(By.xpath("(//ul[@role='group']/li)[1]")).click();
        driver.findElement(By.xpath("(//button[@title='Clear Selection'])[2]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).sendKeys(accountName);
        driver.findElement(By.xpath("(//ul[@role='group'])[2]/li")).click();
         Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

    }
}
