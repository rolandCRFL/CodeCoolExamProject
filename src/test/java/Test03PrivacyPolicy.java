import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;


public class Test03PrivacyPolicy extends Test00Base {

    @RepeatedTest(3)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Privacy Policy")
    @Feature("Valid Tests")
    @Story("Privacy Policy Valid")
    @Description("Privacy Policy Open")
    @DisplayName("TC11")
    @Severity(SeverityLevel.NORMAL)
    public void testPrivacyDetailsOpen(){
            // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

            //TEST

        //Open the privacy statement and go to the window
        takeScreenShot("Landing page with Privacy Bar");
        tools.buttonClicker(landingPage.cookiesDetailButton,false);
        tools.windowHandlerNextOpen();
        takeScreenShot("Opened privacy policy site");

            //ASSERTION

        //Check that the statement has been opened
        Assertions.assertEquals(landingPage.cookiesPageURL,driver.getCurrentUrl());
    }

    @RepeatedTest(3)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Privacy Policy")
    @Feature("Valid Tests")
    @Story("Privacy Policy Valid")
    @Description("Privacy Policy Accept")
    @DisplayName("TC12")
    @Severity(SeverityLevel.MINOR)
    public void testPrivacyAccepted() throws InterruptedException {;
            // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

            //TEST
        takeScreenshot();
        tools.buttonClicker(landingPage.cookiesAcceptButton,false);
        //The battery visibility switch takes time to toggle.
        Thread.sleep(2000);
        takeScreenShot("Disappear bar");

            //ASSERT 1

        //Visibility value of the pop-up bar
        String cookiesBarVisibility = driver.findElement(landingPage.cookiesBar).getCssValue("display");
        Assertions.assertEquals("none",cookiesBarVisibility);

            //ASSERT 2
        driver.navigate().refresh();
        Thread.sleep(2000);
        takeScreenShot("Still disappear after refresh");

        //The pop-bar no longer appears
        boolean expectElement = driver.findElements(landingPage.cookiesBar).isEmpty();
        Assertions.assertTrue(expectElement);
    }
}
