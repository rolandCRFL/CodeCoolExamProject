import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;

public class Test06NewDataInput extends Test00Base {

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("New Data Input")
    @Feature("Valid Tests")
    @Story("New Data Input with result")
    @Description("General search")
    @DisplayName("TC18")
    @Severity(SeverityLevel.CRITICAL)
    public void testNewDataInputGeneral() throws IOException {
            //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

            //TEST

        //In the search box, enter the SWGeneral data
        driver.findElement(landingPage.searchBarInput).sendKeys(tools.jSonStringCollector("SWGeneral"));
        takeScreenShot("Search keyword entered before search");
        driver.findElement(landingPage.searchButton).click();

            //ASSERT

        //Check that the search has been performed with the data you entered
        takeScreenShot("Search results");
        String assertString = driver.findElement(landingPage.searchResultText).getText();
        Assertions.assertTrue(assertString.contains(tools.jSonStringCollector("SWGeneral")));
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("New Data Input")
    @Feature("Valid Tests")
    @Story("New Data Input without result")
    @Description("An irrelevant search")
    @DisplayName("TC19")
    @Severity(SeverityLevel.NORMAL)
    public void testNewDataInputIrrelevant() throws IOException {
            //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

            //TEST
        //In the search box, enter the SWIrrelevant data
        driver.findElement(landingPage.searchBarInput).sendKeys(tools.jSonStringCollector("SWIrrelevant"));
        takeScreenShot("Search keyword entered before search");
        driver.findElement(landingPage.searchButton).click();

            //ASSERT
        //Check that the search has been performed with the data you entered
        takeScreenShot("Search results");
        String assertString = driver.findElement(landingPage.searchResultText).getText();
        Assertions.assertTrue(assertString.contains(tools.jSonStringCollector("SWIrrelevant")));
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("New Data Input")
    @Feature("Valid Tests")
    @Story("New Data Input with result")
    @Description("Search for a specific product")
    @DisplayName("TC20")
    @Severity(SeverityLevel.NORMAL)
    public void testNewDataInputSpecific() throws IOException {
        //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

        //TEST
        //In the search box, enter the SWSpecific data
        driver.findElement(landingPage.searchBarInput).sendKeys(tools.jSonStringCollector("SWSpecific"));
        takeScreenShot("Search keyword entered before search");
        driver.findElement(landingPage.searchButton).click();

        //ASSERT
        //Check that the search has been performed with the data you entered
        takeScreenShot("Search results");
        String assertString = driver.findElement(landingPage.searchResultText).getText();
        Assertions.assertTrue(assertString.contains(tools.jSonStringCollector("SWSpecific")));
    }
}
