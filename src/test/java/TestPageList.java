import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class TestPageList extends Test00Base {

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Scanning a multi-page list")
    @Description("Accessing guitar string pages")
    @DisplayName("TC16")
    @Severity(SeverityLevel.CRITICAL)
    public void SteppingOnMultiplePages() throws InterruptedException {
            //PAGEFACTORY

        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        GoodsPage goodsPage = (GoodsPage) PageFactory.Create("GSPage",driver);
        
            //TEST

        //Double-click on the web item to access the guitar categories
        tools.buttonClicker(landingPage.guitarCategoryButton,true);
        //Select a sub-category
        tools.buttonClicker(landingPage.guitarStringsButton,false);
        //You will need to save the initial URL for the test
        String startURL = driver.getCurrentUrl();
        //Create a local integer variable to store the number of available pages
        int totalPagesNumber = tools.getTotalPagesNumberFromStringElement(goodsPage.pageSizeLoc);

        tools.paginizer(totalPagesNumber,goodsPage.goodsStringName,guitarStringList);
        /*
        //Create a local String variable that will be the URL base of your loop.
        String pageURL = tools.getGoodsURL();
        //Create a for loop that will allow you to add the page number to the URL you just stored, one by one, and extract the data you want to an ArrayList.
        for (int i =2; i<totalPagesNumber+2; i++){
            tools.getTextToArrayList(goodsPage.goodsStringName,guitarStringList);
            if (i<totalPagesNumber+1){
                String newPageURL = pageURL.concat(String.valueOf(i));
                driver.get(newPageURL);}
        }

        */

            //ASSERT

        //Create the expected endpoint URL
        String expectURL = startURL + "?page=" + totalPagesNumber;

        Assertions.assertEquals(expectURL,driver.getCurrentUrl());

    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Scanning a multi-page list")
    @Description("Accessing headphone pages")
    @DisplayName("TC17")
    @Severity(SeverityLevel.NORMAL)
    public void SteppingOnMultiplePages2() throws InterruptedException {
            //PAGEFACTORY

        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        GoodsPage goodsPage = (GoodsPage) PageFactory.Create("GSPage",driver);

            //TEST

        //Double-click on the web item to access the guitar categories
        tools.buttonClicker(landingPage.studioCategoryButton,true);
        //Select a sub-category
        tools.buttonClicker(landingPage.headphoneButton,false);
        //You will need to save the initial URL for the test
        String startURL = driver.getCurrentUrl();
        //Create a local integer variable to store the number of available pages
        int totalPagesNumber = tools.getTotalPagesNumberFromStringElement(goodsPage.pageSizeLoc);

        tools.paginizer(totalPagesNumber,goodsPage.goodsStringName,headPhoneList);

            //ASSERT

        //Create the expected endpoint URL
        String expectURL = startURL + "?page=" + totalPagesNumber;

        Assertions.assertEquals(expectURL,driver.getCurrentUrl());

    }
}
