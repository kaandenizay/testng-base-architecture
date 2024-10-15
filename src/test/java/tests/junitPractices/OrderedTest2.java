package tests.junitPractices;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTest2 {

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

    @Order(1)
    @Test
    public void thirdTest(){
        System.out.println("This is the third test method");
    }

    @AfterAll
    public void tearDown(){
        System.out.println("Browser closed  ---- After all");
    }
}
