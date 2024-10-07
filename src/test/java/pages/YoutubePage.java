package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

public class YoutubePage extends BasePage{

    @FindBy(xpath = "//input[@id='search']")
    private WebElement queryInput;


    public YoutubePage(WebDriver driver) {
        super(driver);
    }

    public void searchByText(String text){
        queryInput.click();
        queryInput.sendKeys(text + Keys.ENTER);
        Utils.sleep(5);
        findByAny("xpath", "  //h3[contains(@class,'title-and-badge')]/a[contains(@title,'Türkiye')]").click();
        Utils.sleep(5);
    }
}
