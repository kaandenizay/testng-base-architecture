package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PracticeAutoLoginPage;
import utils.Utils;

public class PracticeAutomationTest extends BaseTest{

    PracticeAutoLoginPage practiceAutoLoginPage;

    @BeforeClass
    public void goPage(){
        practiceAutoLoginPage = new PracticeAutoLoginPage(driver);
//        driver.get("https://practicetestautomation.com/practice-test-login/");
        Utils.goPage("https://practicetestautomation.com/practice-test-login/");
    }

    @Test(description = "Login to practice automation page")
    public void login(){
        practiceAutoLoginPage.fillUsername("Kaan");
        practiceAutoLoginPage.fillPassword("Test1234");
        practiceAutoLoginPage.clickSubmit();
        Assert.fail();
    }

}
