import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.IOException;

public class Test08DeleteData extends Test00Base {

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Delete Data")
    @Feature("USER 1")
    @Feature("Valid Tests")
    @Story("Delete Data Names")
    @Description("Delete first name data")
    @DisplayName("TC23")
    @Severity(SeverityLevel.NORMAL)
    public void testExistDataDeleteFirstN() throws IOException {
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
        takeScreenShot("Account information before delete");
        //Delete data in First Name field
        driver.findElement(loginPage.firstNameField).sendKeys(Keys.LEFT_CONTROL,"A",Keys.DELETE);
        takeScreenShot("Deleted First Name");
        driver.findElement(loginPage.continueButton).click();

                //ASSERT

        //Check if it allows you to delete the data
        takeScreenShot("Result");
        String result = driver.findElement(By.xpath("//*[@id=\"account\"]/div[1]/div/div")).getText();
        String expectedResult = "First Name must be between 1 and 32 characters!";
        Assertions.assertTrue(result.contains(expectedResult));
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Delete Data")
    @Feature("USER 1")
    @Feature("Valid Tests")
    @Story("Delete Data Names")
    @Description("Delete last name data")
    @DisplayName("TC24")
    @Severity(SeverityLevel.NORMAL)
    public void testExistDataDeleteLastN() throws IOException {
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
        takeScreenShot("Account information before delete");
        //Delete data in Last Name field
        driver.findElement(loginPage.lastNameField).sendKeys(Keys.LEFT_CONTROL,"A",Keys.DELETE);
        takeScreenShot("Deleted Last Name");
        driver.findElement(loginPage.continueButton).click();

            //ASSERT

        //Check if it allows you to delete the data
        takeScreenShot("Result");
        String result = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
        String expectedResult = "Last Name must be between 1 and 32 characters!";
        Assertions.assertTrue(result.contains(expectedResult));
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Delete Data")
    @Feature("USER 1")
    @Feature("Invalid Tests")
    @Feature("BUGS")
    @Story("Delete account")
    @Description("Delete account - BUG #4 - Missing feature")
    @DisplayName("TC25")
    @Severity(SeverityLevel.BLOCKER)
    public void testDeleteFullAccount() throws IOException {
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
        takeScreenShot("Account information before delete");

            //ASSERT

        //Check that the function is available
        takeScreenShot("Missing feature");
        boolean expectElement = !driver.findElements(By.xpath("//*[@class=\"button\"]//*[contains(text(),\" Delete account\")]")).isEmpty();
        Assertions.assertTrue(expectElement);
    }
}
