import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test05MultiPageList extends Test00Base {

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Multi-page List")
    @Feature("Valid Tests")
    @Story("Scanning a multi-page list")
    @Description("Accessing guitar string pages")
    @DisplayName("TC16")
    @Severity(SeverityLevel.NORMAL)
    public void testSteppingOnMultiplePages() throws InterruptedException {
            //PAGEFACTORY

        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        GoodsPage goodsPage = (GoodsPage) PageFactory.Create("GSPage",driver);
        
            //TEST

        //Double-click on the web item to access the guitar categories
        tools.buttonClicker(landingPage.guitarCategoryButton,true);
        //Select a sub-category
        tools.buttonClicker(landingPage.guitarStringsButton,false);
        takeScreenShot("Guitar strings first page");
        //You will need to save the initial URL for the test
        String startURL = driver.getCurrentUrl();
        //Create a local integer variable to store the number of available pages
        int totalPagesNumber = tools.getTotalPagesNumberFromStringElement(goodsPage.pageSizeLoc);
        tools.paginizer(totalPagesNumber,goodsPage.goodsStringName,guitarStringList);

            //ASSERT

        //Create the expected endpoint URL
        takeScreenShot("Guitar strings last page");
        String expectURL = startURL + "?page=" + totalPagesNumber;
        Assertions.assertEquals(expectURL,driver.getCurrentUrl());
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Multi-page List")
    @Feature("Valid Tests")
    @Story("Scanning a multi-page list")
    @Description("Accessing headphone pages")
    @DisplayName("TC17")
    @Severity(SeverityLevel.MINOR)
    public void testSteppingOnMultiplePages2() throws InterruptedException {
            //PAGEFACTORY

        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        GoodsPage goodsPage = (GoodsPage) PageFactory.Create("GSPage",driver);

            //TEST

        //Double-click on the web item to access the guitar categories
        tools.buttonClicker(landingPage.studioCategoryButton,true);
        //Select a sub-category
        tools.buttonClicker(landingPage.headphoneButton,false);
        takeScreenShot("Headphones first page");
        //You will need to save the initial URL for the test
        String startURL = driver.getCurrentUrl();
        //Create a local integer variable to store the number of available pages
        int totalPagesNumber = tools.getTotalPagesNumberFromStringElement(goodsPage.pageSizeLoc);
        tools.paginizer(totalPagesNumber,goodsPage.goodsStringName,headPhoneList);

            //ASSERT

        //Create the expected endpoint URL
        takeScreenShot("Headphones last page");
        String expectURL = startURL + "?page=" + totalPagesNumber;
        Assertions.assertEquals(expectURL,driver.getCurrentUrl());
    }
}
