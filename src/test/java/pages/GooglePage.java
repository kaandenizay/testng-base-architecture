package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import java.util.List;

public class GooglePage extends BasePage{

    @FindBy(name = "q")
    private WebElement queryInput;
    @FindBy(xpath = "//h3[contains(text(),'Türkiye')]")
    private List<WebElement> searchResults;

    public GooglePage(WebDriver driver) {
        super(driver);
    }


    public void searchByText(String text){
        queryInput.click();
        queryInput.sendKeys(text + Keys.ENTER);
        Utils.sleep(5);
//        searchResults.get(0).click();
    }
}
