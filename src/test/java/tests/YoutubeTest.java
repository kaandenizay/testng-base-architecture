package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YoutubePage;
import utils.Utils;


public class YoutubeTest extends BaseTest
{
    YoutubePage youtubePage;
    @BeforeClass
    public void goPage(){
        System.out.println("The thread ID for YoutubeTest  goPage is "+ Thread.currentThread().getId());
        youtubePage = new YoutubePage(driver);
        Utils.goPage("https://www.youtube.com/");

    }

    @Test(description = "Go To Youtube page and search a text")
    public void searchVideo(){
        System.out.println("The thread ID for MyFirstTest  searchText is "+ Thread.currentThread().getId());
        youtubePage.searchByText("Türkiye");
        softAssert.assertEquals("Yotube", "Youtube");
        softAssert.assertAll();
    }


}
