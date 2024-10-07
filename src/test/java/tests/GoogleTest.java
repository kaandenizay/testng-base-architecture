package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.GooglePage;
import utils.Utils;

import static extentReports.ExtentTestManager.getTest;

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
        System.out.println("searchText test executed");
        googlePage.searchByText(searchText);
        // This getTest() method of extentReport, so it should be run within XML totally
        getTest().info(searchText + " searched");
        softAssert.assertEquals("Gogle", "Google");
        /*
        Some extra assertions, combining both soft and actual assertions
         */
        softAssert.assertAll();
    }


}
