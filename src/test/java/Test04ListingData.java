import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test04ListingData extends Test00Base {

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Listing")
    @Feature("Valid Tests")
    @Story("Listing Of Data")
    @Description("Listing of Guitar Category")
    @DisplayName("TC13")
    @Severity(SeverityLevel.NORMAL)
    public void testListGuitarCategory(){
                //PAGEFACTORY
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

                //TEST

        //Double-click on the web item to access the guitar categories
        tools.buttonClicker(landingPage.guitarCategoryButton,true);
        //In an ArrayList (in TestBase) called "list", we upload the names of the categories
        guitarCategoryList = tools.elementToListString(landingPage.categoryTexts);

                //ASSERTION

        //Check that the "list" array is indeed filled with elements
        Assertions.assertNotNull(guitarCategoryList);
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Listing")
    @Feature("Valid Tests")
    @Story("Listing Of Data")
    @Description("Listing of Microphone Category")
    @DisplayName("TC14")
    @Severity(SeverityLevel.MINOR)
    public void testListMicCategory(){
            //PAGEFACTORY
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        //Double-click on the web item to access the guitar categories
        tools.buttonClicker(landingPage.micCategoryButton,true);
        //In an ArrayList (in TestBase) called "list", we upload the names of the categories
        microphoneCategoryList = tools.elementToListString(landingPage.categoryTexts);

            //ASSERTION

        //Check that the "list" array is indeed filled with elements
        Assertions.assertNotNull(microphoneCategoryList);
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Listing")
    @Feature("Valid Tests")
    @Story("Listing Of Data")
    @Description("Listing of Studio Category")
    @DisplayName("TC15")
    @Severity(SeverityLevel.MINOR)
    public void testListStudioCategory(){
        //PAGEFACTORY
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

        //TEST

        //Double-click on the web item to access the guitar categories
        tools.buttonClicker(landingPage.studioCategoryButton,true);
        //In an ArrayList (in TestBase) called "list", we upload the names of the categories
        studioCategoryList = tools.elementToListString(landingPage.categoryTexts);

        //ASSERTION

        //Check that the "list" array is indeed filled with elements
        Assertions.assertNotNull(studioCategoryList);
    }
}
