package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static sprint1.Utility.generateRandom;

public class SF_76_Classic_NewAccount extends  BaseClass {
    @Test
    public void SF_S6_76_Classic_NewAccount() throws InterruptedException {
        String accountName="BootCamp Puppeteer "+generateRandom().toLowerCase();
        waitForElementVisible(By.xpath("//li[@id='Account_Tab']/a"));
        driver.findElement(By.xpath("//li[@id='Account_Tab']/a")).click();
        driver.findElement(By.xpath("//input[@name='go']")).click();
        driver.findElement(By.xpath("//input[@name='new']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Account Name')]/parent::td/following-sibling::td[1]//input")).sendKeys(accountName);
        driver.findElement(By.xpath("//label[contains(text(),'Billing Street')]/parent::td/following-sibling::td[1]/textarea")).sendKeys("test street");
        driver.findElement(By.xpath("//label[contains(text(),'Billing City')]/parent::td/following-sibling::td[1]/input")).sendKeys("Urappakkam");
        driver.findElement(By.xpath("//label[contains(text(),'Billing Zip/Postal Code')]/parent::td/following-sibling::td[1]/input")).sendKeys("60310");
        driver.findElement(By.xpath("//label[contains(text(),'Billing State/Province')]/parent::td/following-sibling::td[1]/input")).sendKeys("TamilNadu");
        driver.findElement(By.xpath("//label[contains(text(),'Billing Country')]/parent::td/following-sibling::td[1]/input")).sendKeys("India");
        driver.findElement(By.xpath("//a[contains(text(),'Copy Billing')]")).click();
        String addingPlusTwenty = Utility.addDate(20);
        System.out.println("Date to select--->"+addingPlusTwenty);
        driver.findElement(By.xpath("//label[contains(text(),'Expiration')]//following::input[1]")).sendKeys(addingPlusTwenty);
        driver.findElement(By.xpath("//input[@name='save'][1]")).click();
        driver.findElement(By.xpath("//li[@id='Account_Tab']/a")).click();
        Thread.sleep(3000);
        boolean displayed = driver.findElement(By.xpath("//th/a[contains(text(),'" + accountName + "')]")).isDisplayed();
        Assert.assertTrue(displayed);
    }
}
