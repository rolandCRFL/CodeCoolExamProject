import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TestPrivacyPolicy extends TestBase{


    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Privacy Policy")
    @Description("Privacy Policy Open")
    @DisplayName("TC11")
    @Severity(SeverityLevel.MINOR)
    public void privacyDetailsOpen(){
            // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

            //TEST

        //Open the privacy statement and go to the window
        tools.buttonClicker(landingPage.cookiesDetailButton,false);
        tools.windowHandlerNextOpen();

            //ASSERTION

        //Check that the statement has been opened
        Assertions.assertEquals(landingPage.cookiesPageURL,driver.getCurrentUrl());
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Privacy Policy")
    @Description("Privacy Policy Accept")
    @DisplayName("TC12")
    @Severity(SeverityLevel.NORMAL)
    public void privacyAccepted() throws InterruptedException {
            // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

            //TEST
        tools.buttonClicker(landingPage.cookiesAcceptButton,false);

            //ASSERTION

        //The battery visibility switch takes time to toggle.
        Thread.sleep(3000);
        //Visibility value of the pop-up bar
        String cookiesBarVisibility = driver.findElement(landingPage.cookiesBar).getCssValue("display");

        Assertions.assertEquals("none",cookiesBarVisibility);
    }

}
