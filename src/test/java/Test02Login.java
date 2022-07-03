import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Test02Login extends Test00Base {

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Login")
    @Feature("USER 1")
    @Feature("Valid Tests")
    @Story("Login Valid")
    @Description("Login with a registered account (USER 1)")
    @DisplayName("TC07")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginRegistered() throws IOException {
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
        takeScreenShot("Data filled, BEFORE");
        //Click on Login button
        tools.buttonClicker(loginPage.loginButton,false);
        takeScreenShot("AFTER Login");

            //ASSERT

        //Navigate to the account informations
        tools.buttonClicker(landingPage.myAccountButton,false);
        takeScreenShot("My account");
        driver.findElement(loginPage.editAccountInformationButton).click();
        takeScreenShot("Edit account page");
        //Get the email address from form and compare it with the login address
        String expectedEmail = tools.jSonStringCollector("email"+accountSelector);
        String actualEmail = driver.findElement(loginPage.emailAddressField).getAttribute("value");
        Assertions.assertEquals(expectedEmail,actualEmail);
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Login")
    @Feature("USER 3")
    @Feature("Valid Tests")
    @Story("Login Valid")
    @Description("Login with an unregistered account (USER 3)")
    @DisplayName("TC08")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUnRegistered() throws IOException {
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
        takeScreenShot("Before click on Login button");
        tools.buttonClicker(loginPage.loginButton,false);

            //ASSERT

        takeScreenShot("After");
        WebElement warning = driver.findElement(By.xpath("//*[text()=\" Warning: No match for E-Mail Address and/or Password.\"]"));
        Assertions.assertTrue(warning.isDisplayed());
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Login")
    @Feature("USER 1")
    @Feature("Valid Tests")
    @Story("Login Valid")
    @Description("Sign in with missing email address (USER 1)")
    @DisplayName("TC09")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginMissingEmail() throws IOException {
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
        takeScreenShot("Before click on Login button");
        tools.buttonClicker(loginPage.loginButton,false);

            //ASSERT

        takeScreenShot("After");
        WebElement warning = driver.findElement(By.xpath("//*[text()=\" Warning: No match for E-Mail Address and/or Password.\"]"));
        Assertions.assertTrue(warning.isDisplayed());
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Login")
    @Feature("USER 1")
    @Feature("Valid Tests")
    @Story("Login Valid")
    @Description("Login with missing password (USER 1)")
    @DisplayName("TC10")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginMissingPassword() throws IOException {
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
        takeScreenShot("Before click on Login button");
        tools.buttonClicker(loginPage.loginButton,false);

            //ASSERT

        takeScreenShot("After");
        WebElement warning = driver.findElement(By.xpath("//*[contains(text(),\" Warning:\")]"));
        Assertions.assertTrue(warning.isDisplayed());
    }

}
