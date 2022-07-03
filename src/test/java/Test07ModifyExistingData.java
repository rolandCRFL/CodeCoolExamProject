import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;

import java.io.IOException;

public class Test07ModifyExistingData extends Test00Base {

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Data Modification")
    @Feature("USER 1")
    @Feature("USER 2")
    @Feature("Valid Tests")
    @Story("Modify Existing Data")
    @Description("Modify existing account (USER 1) basic data with (USER 2) account data")
    @DisplayName("TC21")
    @Severity(SeverityLevel.CRITICAL)
    public void testExistDataModifyBasic() throws IOException {
            //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

            //TEST

        //Login and click Edit your account information
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email1"));
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord1"));
        tools.buttonClicker(loginPage.loginButton,false);
        driver.findElement(loginPage.editAccountInformationButton).click();
        takeScreenShot("The original data");
        //Collect the necessary data
        By[] elems = {
                loginPage.firstNameField,
                loginPage.lastNameField,
                loginPage.telephoneField};
        String array[] = {
                "fName",
                "lName",
                "phone"};
        //Fill the data
        tools.dataFiller(elems,array,"2");
        takeScreenShot("The new data are");
        driver.findElement(loginPage.continueButton).click();

                //ASSERT

        takeScreenShot("Success");
        String exceptedResultText = "Success: Your account has been successfully updated.";
        String result = driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText();
        Assertions.assertTrue(result.contains(exceptedResultText));
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Data Modification")
    @Feature("USER 3")
    @Feature("USER 4")
    @Feature("Valid Tests")
    @Story("Modify Existing Data")
    @Description("Modify existing account (USER 4) password data with (USER 3) account data and at the end we restore it ")
    @DisplayName("TC22")
    @Severity(SeverityLevel.CRITICAL)
    public void testExistDataModifyPassword() throws IOException {
            //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

            //TEST

        //Login and click Edit your account information
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email4"));
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord4"));
        tools.buttonClicker(loginPage.loginButton,false);
        driver.findElement(loginPage.editAccountPasswordButton).click();
        //Collect the necessary data
        By[] elems = {
                loginPage.passwordField,
                loginPage.passwordConfirmField};
        String array[] = {
                "passWord",
                "passWord"};
        //Define the two accounts to use
        String accountOriginal = "4";
        String accountNewPass = "3";
        //Fill the data
        tools.dataFiller(elems,array,accountNewPass);
        driver.findElement(loginPage.continueButton).click();

            //ASSERT 1

        //Check that the page says the password change was successful
        String exceptedResultText = "Success: Your password has been successfully updated.";
        String result = driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText();
        Assertions.assertTrue(result.contains(exceptedResultText));

            //ASSERT 2

        //To make sure that the password change was successful, log out and try to log in with the new password
        //Log out
        driver.findElement(By.linkText("Logout")).click();
        //Login with your new password
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email4"));
        //We are now trying to log in with the 3rd USER password
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord3"));
        tools.buttonClicker(loginPage.loginButton,false);
        //Check that the login was successful and that it was done with the original email
        tools.buttonClicker(landingPage.myAccountButton,false);
        takeScreenShot("My account");
        driver.findElement(loginPage.editAccountInformationButton).click();
        takeScreenShot("Edit account page");
        //Get the email address from form and compare it with the login email
        String expectedEmail = tools.jSonStringCollector("email"+accountOriginal);
        String actualEmail = driver.findElement(loginPage.emailAddressField).getAttribute("value");
        Assertions.assertEquals(expectedEmail,actualEmail);

            //RESTORE

        //To keep the test running, reset the original password
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.editAccountPasswordButton).click();
        tools.dataFiller(elems,array,accountOriginal);
        driver.findElement(loginPage.continueButton).click();

    }
}
