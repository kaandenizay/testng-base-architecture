package utils;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils{

    private static WebDriver getDriver(){
        return DriverManager.getThreadDriver();
    }

    public static void goPage(String url) {
        getDriver().get(url);
    }


    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForVisibility (WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
