import io.qameta.allure.*;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;

public class TestNewDataInput extends TestBase{



    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("New Data Input")
    @Description("General search")
    @DisplayName("TC18")
    @Severity(SeverityLevel.CRITICAL)
    public void TestNewDataInputGeneral() throws IOException {
            //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

            //TEST

        //In the search box, enter the SWGeneral data
        driver.findElement(landingPage.searchBarInput).sendKeys(tools.jSonStringCollector("SWGeneral"));
        driver.findElement(landingPage.searchButton).click();

            //ASSERT

        //Check that the search has been performed with the data you entered
        String assertString = driver.findElement(landingPage.searchResultText).getText();
        Assertions.assertTrue(assertString.contains(tools.jSonStringCollector("SWGeneral")));
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("New Data Input")
    @Description("An irrelevant search")
    @DisplayName("TC19")
    @Severity(SeverityLevel.NORMAL)
    public void TestNewDataInputIrrelevant() throws IOException {
            //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

            //TEST
        //In the search box, enter the SWIrrelevant data
        driver.findElement(landingPage.searchBarInput).sendKeys(tools.jSonStringCollector("SWIrrelevant"));
        driver.findElement(landingPage.searchButton).click();

            //ASSERT
        //Check that the search has been performed with the data you entered
        String assertString = driver.findElement(landingPage.searchResultText).getText();
        Assertions.assertTrue(assertString.contains(tools.jSonStringCollector("SWIrrelevant")));
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("New Data Input")
    @Description("Search for a specific product")
    @DisplayName("TC20")
    @Severity(SeverityLevel.NORMAL)
    public void TestNewDataInputSpecific() throws IOException {
        //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

        //TEST
        //In the search box, enter the SWSpecific data
        driver.findElement(landingPage.searchBarInput).sendKeys(tools.jSonStringCollector("SWSpecific"));
        driver.findElement(landingPage.searchButton).click();

        //ASSERT
        //Check that the search has been performed with the data you entered
        String assertString = driver.findElement(landingPage.searchResultText).getText();
        Assertions.assertTrue(assertString.contains(tools.jSonStringCollector("SWSpecific")));
    }



}
