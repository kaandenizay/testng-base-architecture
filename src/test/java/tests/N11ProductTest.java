package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.N11MainPage;
import utils.Utils;

public class N11ProductTest extends BaseTest{

    N11MainPage n11MainPage;

    @BeforeClass
    public void goPage(){
        System.out.println("The thread ID for n11MainPage  goPage is "+ Thread.currentThread().getId());
        n11MainPage = new N11MainPage(driver);
        Utils.goPage("https://www.n11.com/");

    }

    @Test(description = "Go To N11 page and reject cookies")
    public void productSearch(){
        System.out.println("The thread ID for n11MainPage  productSearch is "+ Thread.currentThread().getId());
        n11MainPage.blockCookies();
        Assert.fail("Yanlış ürün geldi");
    }

}
