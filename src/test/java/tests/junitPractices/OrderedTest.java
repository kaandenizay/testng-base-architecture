package tests.junitPractices;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static config.ConfigurationManager.configuration;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTest {

    protected static WebDriver driver;
    @BeforeAll
    public void beforeAll(){
        System.out.println("Browser launched");
    }

    @Test
    public void firstTest(){
        System.out.println("This is the first test method");
    }


    @DisplayName("Second Test inside Junit ")
    @Test
    public void secondTest(){
        System.out.println("This is the second test method");
    }

    @AfterAll
    public void tearDown(){
        System.out.println("Browser closed  ---- After all");
    }
}
