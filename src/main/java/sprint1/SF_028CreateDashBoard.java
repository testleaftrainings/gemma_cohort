package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SF_028CreateDashBoard extends  BaseClass{

    @Test
    public void tc_028CreateDashBoard() throws InterruptedException {
        String dashBoardName="Madhavan";
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]")).sendKeys("Dashboards");
        driver.findElement(By.xpath("//p/mark[text()='Dashboards']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@title='New Dashboard']")).click();
        switchFrame(By.xpath("//iframe[@title='dashboard']"));
        driver.findElement(By.xpath("//label[@for='dashboardNameInput']//following::div/input[@id='dashboardNameInput']")).sendKeys("Salesforce Automation by "+dashBoardName);
        driver.findElement(By.id("submitBtn")).click();
        driver.switchTo().defaultContent();
        switchFrame(By.xpath("//iframe[@title='dashboard']"));
        String actualText = driver.findElement(By.xpath("//div[@id='main']//span[contains(text(),'Salesforce')]")).getText();
        System.out.println("DashBoardName---> "+actualText);
        if (actualText.toLowerCase().replaceAll("[^A-Za-z0]", " ").contains(dashBoardName.toLowerCase())) {
            System.out.println("Pass");
            Assert.assertTrue(true);
        } else {
            Assert.fail("Account is not created");
        }
    }
}
