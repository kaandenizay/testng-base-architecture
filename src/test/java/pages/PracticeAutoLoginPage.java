package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeAutoLoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "submit")
    private WebElement submitButton;

    public PracticeAutoLoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void fillPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickSubmit(){
        submitButton.click();
    }
}
