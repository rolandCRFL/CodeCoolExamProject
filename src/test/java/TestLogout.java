import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;

import java.io.IOException;

public class TestLogout extends Test00Base {



    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Logout")
    @Description("Log out of the account")
    @DisplayName("TC29")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogoutConfirm() throws IOException {
        // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

        // TEST
        //Login with a valid account
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email3"));
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord1"));
        tools.buttonClicker(loginPage.loginButton,false);
        //Find the exit button, then click on it
        driver.findElement(By.linkText("Logout")).click();

        //ASSERT

        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText();
        String expectedResult = "You have been logged off your account. It is now safe to leave the computer.";

        Assertions.assertTrue(result.contains(expectedResult));
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Logout")
    @Description("Log out of the account, and check that your account wish list is available despite the confirmation ")
    @DisplayName("TC30")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogoutCheckWishList() throws IOException {
        // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

        // TEST
        //Login with a valid account
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email3"));
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord1"));
        tools.buttonClicker(loginPage.loginButton,false);
        //We add you to our wish list
        driver.findElement(By.linkText("Wishlist")).click();
        //Check if the wish list is available
        boolean expectElement = !driver.findElements(By.xpath("//*[contains(text(),\"Your wish list is empty\")]")).isEmpty();
        Assertions.assertTrue(expectElement);
        //Logout
        //Find the exit button, then click on it
        driver.findElement(By.linkText("Logout")).click();
        //Click on the wishlist again
        driver.findElement(By.linkText("Wishlist")).click();
        //The previous assert must now run falsely
        boolean expectElement2 = !driver.findElements(By.xpath("//*[contains(text(),\"Your wish list is empty\")]")).isEmpty();
        //The element you are looking for should not be found if you exit correctly.
        Assertions.assertFalse(expectElement2);
    }
}
