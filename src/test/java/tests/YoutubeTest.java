package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YoutubePage;
import utils.Utils;


public class YoutubeTest extends BaseTest
{
    YoutubePage youtubePage;
    @BeforeClass
    public void goPage(){
        System.out.println("The thread ID for YoutubeTest  goPage is "+ Thread.currentThread().threadId());
        youtubePage = new YoutubePage(driver);
        Utils.goPage("https://www.youtube.com/");

    }

    @Test(description = "Go To Youtube page and search a text")
    public void searchVideo(){
        System.out.println("The thread ID for MyFirstTest  searchText is "+ Thread.currentThread().threadId());
        System.out.println("searchText test executed");
        youtubePage.searchByText("Türkiye");
        softAssert.assertEquals("Yotube", "Youtube");
        /*
        Some extra assertions, combining both soft and actual assertions
         */
        softAssert.assertAll();
    }


}
