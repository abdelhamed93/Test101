package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass2Waitings {

    @Test
    public void controlTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("adder")).click();

        String stt = driver.findElement(By.id("box0")).getDomProperty("color");
        System.out.println("stt");

        //driver.quit();
    }

    @Test
    public void implicitWaitTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("adder")).click();

        //driver.findElement(By.id("box0")).sendKeys("test");
        driver.findElement(By.id("box0")).isDisplayed();


       // driver.quit();
    }

    @Test
    public void explicitWaitTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("reveal")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//        wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofMillis(500))
//                .ignoring(NotFoundException.class);

        wait.until(d -> {
            d.findElement(By.id("revealed")).sendKeys("test");
            return true;
        });

        driver.quit();
    }

    @Test
    public void customExplicitWaitTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("reveal")).click();

        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofMillis(100))
                        .ignoring(NotFoundException.class)
                        .ignoring(ElementNotInteractableException.class)
                        .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(By.id("revealed")).sendKeys("test");
            return true;
        });

        driver.quit();
    }

    @Test
    public void explicitWaitWithIsDisplayedTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("reveal")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(d -> d.findElement(By.id("revealed")).isDisplayed());

        driver.findElement(By.id("revealed")).sendKeys("test");

        driver.quit();
    }
}
