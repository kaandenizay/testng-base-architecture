package tests;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.N11MainPage;
import utils.Utils;

import java.time.Duration;


public class MyFirstTest extends BaseTest
{
    N11MainPage n11MainPage;
    @BeforeClass
    public void goPage(){
        System.out.println("The thread ID for MyFirstTest  goPage is "+ Thread.currentThread().threadId());
        n11MainPage = new N11MainPage(driver);
        driver.get("https://www.google.com");

    }
//    @Parameters({"browser","baseURL"})
 /*   @Test
    public void firstTest(){
        System.out.println("First test executed");
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
//        System.out.println("browser = " + browser);
//        System.out.println("baseUrl = " + baseUrl);
    }*/

    @Test
    public void secondTest(){
        System.out.println("The thread ID for MyFirstTest  secondTest is "+ Thread.currentThread().threadId());

        System.out.println("Second test executed");
        driver.get("https://www.facebook.com");
        Assert.assertTrue(driver.getTitle().contains("Facebook"));
    }


}
