package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskSeven {

    @Test
    public void tableTask(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        By cellLocator = By.xpath("//table[@id='customers']//tr[4]/td[3]");
        String ActualText = driver.findElement(cellLocator).getText();
        Assert.assertEquals(ActualText, "Austria");
        driver.quit();

    }





}
