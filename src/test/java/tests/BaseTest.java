package tests;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import listeners.EventListener;

import static config.ConfigurationManager.configuration;

public class BaseTest {

     protected WebDriver driver;
     private final ThreadLocal<SoftAssert> softAssertPool = new ThreadLocal<>();
     protected SoftAssert softAssert;

    @BeforeClass
    public void setupBrowser(){
        DriverManager.setThreadDriver(configuration().browser());
        driver = DriverManager.getThreadDriver();
        System.out.println("Browser launched");
        WebDriverListener listener = new EventListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

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
