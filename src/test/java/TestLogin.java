import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;

public class TestLogin extends TestBase{

    @Test
    public void cookiesDetailsOpen(){
        // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

        //TEST

        tools.buttonClicker(landingPage.cookiesDetailButton,false);
        tools.windowHandlerNextOpen();

        //ASSERTION
        Assertions.assertEquals(landingPage.cookiesPageURL,driver.getCurrentUrl());
    }

    @Test
    public void cookiesAccepted(){
        // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

        //TEST
        tools.buttonClicker(landingPage.cookiesAcceptButton,false);

        //ASSERTION
        String cookiesBarVisibility = driver.findElement(landingPage.cookiesBar).getCssValue("display");
        Assertions.assertEquals("none",cookiesBarVisibility);
    }



    @Test
    public void testingLogin(){
        // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);
        // TEST
        tools.buttonClicker(landingPage.myAccountButton,false);
        tools.stringFieldFiller(loginPage.emailAddressField,email);
        tools.stringFieldFiller(loginPage.passwordField,passWord);
        tools.buttonClicker(loginPage.loginButton,false);

    }

}
