import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_Login {


    @Test(dataProvider = "Login")
    public void login(String uName,String psWd)
    {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.findElement(By.name("username")).sendKeys(uName);
        driver.findElement(By.name("password")).sendKeys(psWd);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        driver.quit();

    }


    @DataProvider(name ="Login")
    public Object[][] readData()
    {
         Object[][] obj=new Object[2][2];

         obj[0][0]="Admin";
        obj[0][1]="admin123";
        obj[1][0]="Admin";
        obj[1][1]="test123";

        return obj;
    }
}
