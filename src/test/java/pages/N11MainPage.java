package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.Utils;

public class N11MainPage extends BasePage{

    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(xpath = "//efilli-layout-dynamic")
    private WebElement shadowFrame;

    public N11MainPage(WebDriver driver) {
        super(driver);
    }

    public void blockCookies(){
        Utils.sleep(5);
        SearchContext shadowRoot = shadowFrame.getShadowRoot();
        // Only CSS Selector is working inside of shadow elements
        WebElement rejectCookies = shadowRoot.findElement(By.cssSelector("div[data-name='Reject Button']"));
        rejectCookies.click();
    }
}
