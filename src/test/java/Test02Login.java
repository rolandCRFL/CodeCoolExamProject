import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TestLogin extends Test00Base {


    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Login Tests")
    @Description("Login with a registered account (USER 1)")
    @DisplayName("TC07")
    @Severity(SeverityLevel.CRITICAL)
    public void testingLoginRegistered() throws IOException {

            // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

            // TEST

        //Navigate to the login page
        tools.buttonClicker(landingPage.myAccountButton,false);

        //Collecting the web elements to be filled in an array, THE ORDER IS IMPORTANT!
        By[] elements = {
                loginPage.emailAddressField,
                loginPage.passwordField};

        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "email",
                "passWord"};

        //Using a method we have written to fill in the data
        //USER 1 !
        String accountSelector = "1";
        tools.dataFiller(elements, dataSelector, accountSelector);

        //Click on Login button
        tools.buttonClicker(loginPage.loginButton,false);

            //ASSERT

        //Navigate to the account informations
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.editAccountInformationButton).click();

        //Get the email address from form and compare it with the login address
        String expectedEmail = tools.jSonStringCollector("email"+accountSelector);
        String actualEmail = driver.findElement(loginPage.emailAddressField).getAttribute("value");
        Assertions.assertEquals(expectedEmail,actualEmail);
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Login Tests")
    @Description("Login with an unregistered account (USER 3)")
    @DisplayName("TC08")
    @Severity(SeverityLevel.CRITICAL)
    public void testingLoginUnRegistered() throws IOException {

            // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

            // TEST

        //Navigate to the login page
        tools.buttonClicker(landingPage.myAccountButton,false);

        //Collecting the web elements to be filled in an array, THE ORDER IS IMPORTANT!
        By[] elements = {
                loginPage.emailAddressField,
                loginPage.passwordField};

        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "email",
                "passWord"};

        //Using a method we have written to fill in the data
        //USER 3 !
        String accountSelector = "3";
        tools.dataFiller(elements, dataSelector, accountSelector);

        //Click on Login button
        tools.buttonClicker(loginPage.loginButton,false);

            //ASSERT

        WebElement warning = driver.findElement(By.xpath("//*[text()=\" Warning: No match for E-Mail Address and/or Password.\"]"));
        Assertions.assertTrue(warning.isDisplayed());
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Login Tests")
    @Description("Sign in with missing email address")
    @DisplayName("TC09")
    @Severity(SeverityLevel.CRITICAL)
    public void testingLoginMissingEmail() throws IOException {

            // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

            // TEST

        //Navigate to the login page
        tools.buttonClicker(landingPage.myAccountButton,false);

        //Collecting the web elements to be filled in an array, THE ORDER IS IMPORTANT!
        By[] elements = {
                loginPage.passwordField};

        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "passWord"};

        //Using a method we have written to fill in the data
        //USER 1 !
        String accountSelector = "1";
        tools.dataFiller(elements, dataSelector, accountSelector);

        //Click on Login button
        tools.buttonClicker(loginPage.loginButton,false);

            //ASSERT

        WebElement warning = driver.findElement(By.xpath("//*[text()=\" Warning: No match for E-Mail Address and/or Password.\"]"));
        Assertions.assertTrue(warning.isDisplayed());
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Login Tests")
    @Description("Login with missing password")
    @DisplayName("TC10")
    @Severity(SeverityLevel.CRITICAL)
    public void testingLoginMissingPassword() throws IOException {

        // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

        // TEST

        //Navigate to the login page
        tools.buttonClicker(landingPage.myAccountButton,false);

        //Collecting the web elements to be filled in an array, THE ORDER IS IMPORTANT!
        By[] elements = {
                loginPage.emailAddressField};

        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "email"};

        //Using a method we have written to fill in the data
        //USER 1 !
        String accountSelector = "1";
        tools.dataFiller(elements, dataSelector, accountSelector);

        //Click on Login button
        tools.buttonClicker(loginPage.loginButton,false);

        //ASSERT

        WebElement warning = driver.findElement(By.xpath("//*[contains(text(),\" Warning:\")]"));
        Assertions.assertTrue(warning.isDisplayed());
    }

    @Test
    public void testLogout() throws IOException {
        // PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

        // TEST
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email3"));
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord1"));
        tools.buttonClicker(loginPage.loginButton,false);
        driver.findElement(By.linkText("Logout")).click();

        //ASSERT

        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText();
        String expectedResult = "You have been logged off your account. It is now safe to leave the computer.";

        Assertions.assertTrue(result.contains(expectedResult));
    }


}
