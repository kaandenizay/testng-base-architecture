package tests.junitPractices;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import static config.ConfigurationManager.configuration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTest {

    protected static WebDriver driver;
    @BeforeAll
    public void beforeAll(){
        System.out.println("Browser launched");
    }

    @Tag("sanity")
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

    @Tag("acceptance")
    @Test
    public void thirdTest(){
        System.out.println("This is the third test method");

    }

    @Tag("acceptance")
    @ParameterizedTest(name = "Run: {index} -   value: {arguments}")
    @ValueSource(ints = {1, 3, 5})
    public void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }
}
