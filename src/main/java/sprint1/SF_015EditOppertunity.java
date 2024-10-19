package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SF_015EditOppertunity extends  BaseClass{

    @Test
    public void tc_015_EditOppertunity() throws InterruptedException {
        String oppertunity="Salesforce Automation by Madhavan";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Opportunities']"));
        js.executeScript("arguments[0].click();", eleAccounts);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(oppertunity);
        driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(Keys.TAB);
        Thread.sleep(4000);
        WebElement dropdownIcon = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']//tr/td[8]//a"));
        js.executeScript("arguments[0].click();", dropdownIcon);
        driver.findElement(By.xpath("//a[@title='Edit']")).click();
        driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
        Thread.sleep(2000);
        WebElement date=driver.findElement(By.xpath("//td[@data-value='"+Utility.getTmrwDate()+"']/span"));
        js.executeScript("arguments[0].click();", date);
        Thread.sleep(2000);
        WebElement dropdownStage= driver.findElement(By.xpath("//button[@aria-label='Stage']/span"));
        js.executeScript("arguments[0].click();", dropdownStage);
        driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
        Thread.sleep(2000);
        WebElement dropdownDelivery= driver.findElement(By.xpath("(//*[contains(text(),'Delivery/Installation Status')]//parent::div//div)[5]/lightning-icon/span"));
        js.executeScript("arguments[0].scrollIntoView(true);", dropdownDelivery);
        js.executeScript("arguments[0].click();", dropdownDelivery);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@title='In progress']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Description')]//following-sibling::div/textarea")).clear();
        driver.findElement(By.xpath("//label[contains(text(),'Description')]//following-sibling::div/textarea")).sendKeys("Salesforce");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText();
        if (actualText.toLowerCase().replaceAll("[^A-Za-z0]", " ").contains(oppertunity.toLowerCase())) {
            System.out.println("Pass");
            Assert.assertTrue(true);
        } else {
            Assert.fail("Expected account not deleted");
        }
    }
}
