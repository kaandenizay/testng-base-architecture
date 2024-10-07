package tests;

import config.Configuration;
import driver.DriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static config.ConfigurationManager.configuration;

public class BaseTest {

     protected WebDriver driver;
     private final ThreadLocal<SoftAssert> softAssertPool = new ThreadLocal<>();
     protected SoftAssert softAssert;


//    @Parameters({"browser"})
    @BeforeClass
    public void setupBrowser(){
        DriverManager.setThreadDriver(configuration().browser());
        driver = DriverManager.getThreadDriver();
        System.out.println("Browser launched");
    }

    @BeforeMethod
    public void setupMethods(){
        softAssert = new SoftAssert();
        softAssertPool.set(softAssert);
        softAssert = softAssertPool.get();
    }

    // If we apply @afterMethod annotation to collect soft asserts
    // TestNG marks them as success in the report because actual @Test annotation is passed
    // So we need to use assertAll method inside each of test methods
//    @AfterMethod
//    public void terminateMethods(){
//        softAssertPool.get().assertAll();
//    }


    @AfterClass
    public void tearDown(){
        DriverManager.quitDriver();
        System.out.println("Browser closed");
    }

    @AfterTest
    public void terminateTest(){
        DriverManager.removeThreadPool();
        softAssertPool.remove();
    }


}
