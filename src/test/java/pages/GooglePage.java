package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

public class GooglePage extends BasePage{

    @FindBy(name = "q")
    private WebElement queryInput;
    @FindAll({
            @FindBy(id="books-wrapper"),
            @FindBy(id="userName-value")
    })
    private WebElement user;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void searchByText(String text){
        queryInput.click();
        queryInput.sendKeys(text + Keys.ENTER);
        Utils.sleep(5);
        findByAny("xpath", "//h3[contains(text(),'Türkiye')]").click();
    }
}
