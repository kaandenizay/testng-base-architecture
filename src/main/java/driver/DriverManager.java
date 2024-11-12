package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static void setThreadDriver(String browser) {
        if (browser.equals("firefox")) {
            driverPool.set(new FirefoxDriver());
        } else if (browser.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driverPool.set(new ChromeDriver(chromeOptions));
        }
    }

    public static WebDriver getThreadDriver() {
        driverPool.get().manage().window().maximize();
//        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driverPool.get();
    }

    public static void quitDriver() {
        if (driverPool.get() != null) {
            getThreadDriver().quit();
        }
    }

    public static void removeThreadPool() {
        driverPool.remove();
        }
    }
