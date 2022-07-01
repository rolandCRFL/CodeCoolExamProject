import io.qameta.allure.*;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;

public class TestDeleteData extends TestBase{


    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Delete Data")
    @Description("Delete first name data")
    @DisplayName("TC23")
    @Severity(SeverityLevel.NORMAL)
    public void TestExistDataDeleteFirstN() throws IOException {
                //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

                //TEST

        //Login and click Edit your account information
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email3"));
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord1"));
        tools.buttonClicker(loginPage.loginButton,false);
        driver.findElement(loginPage.editAccountInformationButton).click();
        //Delete data in First Name field
        driver.findElement(loginPage.firstNameField).sendKeys(Keys.LEFT_CONTROL,"A",Keys.DELETE);
        driver.findElement(loginPage.continueButton).click();

                //ASSERT

        //Check if it allows you to delete the data
        String result = driver.findElement(By.xpath("//*[@id=\"account\"]/div[1]/div/div")).getText();
        String expectedResult = "First Name must be between 1 and 32 characters!";
        Assertions.assertTrue(result.contains(expectedResult));
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Delete Data")
    @Description("Delete last name data")
    @DisplayName("TC24")
    @Severity(SeverityLevel.NORMAL)
    public void TestExistDataDeleteLastN() throws IOException {
        //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

        //TEST

        //Login and click Edit your account information
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email3"));
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord1"));
        tools.buttonClicker(loginPage.loginButton,false);
        driver.findElement(loginPage.editAccountInformationButton).click();
        //Delete data in Last Name field
        driver.findElement(loginPage.lastNameField).sendKeys(Keys.LEFT_CONTROL,"A",Keys.DELETE);
        driver.findElement(loginPage.continueButton).click();

        //ASSERT

        //Check if it allows you to delete the data
        String result = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
        String expectedResult = "Last Name must be between 1 and 32 characters!";
        Assertions.assertTrue(result.contains(expectedResult));
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Delete Data")
    @Description("Delete account")
    @DisplayName("TC25")
    @Severity(SeverityLevel.BLOCKER)
    public void TestDeleteFullAccount() throws IOException {
        //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

        //TEST

        //Login and click Edit your account information
        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email3"));
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord1"));
        tools.buttonClicker(loginPage.loginButton,false);
        driver.findElement(loginPage.editAccountInformationButton).click();

        //ASSERT

        //Check that the function is available
        boolean expectElement = !driver.findElements(By.xpath("//*[@class=\"button\"]//*[contains(text(),\" Delete account\")]")).isEmpty();

        Assertions.assertTrue(expectElement);
    }

}
