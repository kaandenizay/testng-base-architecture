package tests;

import org.testng.annotations.*;
import pages.GooglePage;
import utils.Utils;

public class GoogleTest extends BaseTest
{
    GooglePage googlePage;
    @BeforeClass
    public void goPage(){
        System.out.println("The thread ID for GoogleTest  goPage is "+ Thread.currentThread().threadId());
        googlePage = new GooglePage(driver);
        Utils.goPage("https://www.google.com");
    }

    @Test(description = "Go To Google page and search a text")
    public void searchText(){
        String searchText = "Türkiye";
        System.out.println("The thread ID for GoogleTest  searchText is "+ Thread.currentThread().threadId());
        googlePage.searchByText(searchText);
        softAssert.assertEquals("Gogle", "Google");
        /*
        Some extra assertions, combining both soft and actual assertions
         */
        softAssert.assertAll();
    }


}
