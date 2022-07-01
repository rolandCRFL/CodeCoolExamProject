import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;

import java.io.IOException;

public class TestModifyExistingData extends Test00Base {

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Modify existing data")
    @Description("Modify existing account basic data")
    @DisplayName("TC21")
    @Severity(SeverityLevel.CRITICAL)
    public void TestExistDataModifyBasic() throws IOException {
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
        //Collect the necessary data
        By[] elems = {loginPage.firstNameField,loginPage.lastNameField,loginPage.emailAddressField,loginPage.telephoneField};
        String array[] = {"fName","lName","email","phone"};
        //Fill the data
        tools.dataFiller(elems,array,"3");
        driver.findElement(loginPage.continueButton).click();

                //ASSERT

        String exceptedResultText = "Success: Your account has been successfully updated.";
        String result = driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText();
        Assertions.assertTrue(result.contains(exceptedResultText));

    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Modify existing data")
    @Description("Modify existing account password data")
    @DisplayName("TC22")
    @Severity(SeverityLevel.CRITICAL)
    public void TestExistDataModifyPassword() throws IOException {
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
        driver.findElement(loginPage.editAccountPasswordButton).click();
        //Collect the necessary data
        By[] elems = {loginPage.passwordField,loginPage.passwordConfirmField};
        String array[] = {"passWord","passWord"};
        //Fill the data
        tools.dataFiller(elems,array,"3");
        driver.findElement(loginPage.continueButton).click();

        //ASSERT

        String exceptedResultText = "Success: Your password has been successfully updated.";
        String result = driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText();
        Assertions.assertTrue(result.contains(exceptedResultText));

    }
}
