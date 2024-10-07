package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected WebElement findByAny(String type, String text){
        WebElement webElement = switch (type) {
            case "id" -> driver.findElement(By.id(text));
            case "name" -> driver.findElement(By.name(text));
            case "className" -> driver.findElement(By.className(text));
            case "xpath" -> driver.findElement(By.xpath(text));
            case "cssSelector" -> driver.findElement(By.cssSelector(text));
            case "linkText" -> driver.findElement(By.linkText(text));
            case "partialLinkText" -> driver.findElement(By.partialLinkText(text));
            default -> driver.findElement(By.xpath(text));
        };
        return webElement;
    }

}
