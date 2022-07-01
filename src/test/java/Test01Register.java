import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Test01Register extends TestBase {


    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Registration")
    @Story("Registration tests")
    @Description("To check if the page is available")
    @DisplayName("TC01 - Site Availability")
    @Severity(SeverityLevel.CRITICAL)
    public void testSiteAvailability() {

            //TEST

        //Navigate to the site
        driver.get(siteUrl);
        //The site logo will be the basis for verification
        WebElement pageLogo = driver.findElement(By.xpath("//*[@id=\"logo\"]"));

            //ASSERT

        //Check that the logo is displayed on the page
        Assertions.assertEquals(true, pageLogo.isDisplayed());

        saveFailureScreenShot(driver);


    }


    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Registration tests")
    @Description("Registration with correctly filled data")
    @DisplayName("TC02")
    @Severity(SeverityLevel.CRITICAL)
    public void testingRegistrationCorrectData() throws IOException {

            //PAGEFACTORY
        RegisterPage registerPage = (RegisterPage) PageFactory.Create("RegisterPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        //Navigate to the registration page
        driver.get(registerPage.registrationURL);

        //Collecting the web elements to be filled in an array, THE ORDER IS IMPORTANT!
        By[] elements = {
                registerPage.firstNameField,
                registerPage.lastNameField,
                registerPage.emailField,
                registerPage.telephoneField,
                registerPage.passwordField,
                registerPage.passwordConfirmField};

        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "fName",
                "lName",
                "email",
                "phone",
                "passWord",
                "passWord"};

        //Using a method we have written to fill in the data
        //USER 1 !
        tools.dataFiller(elements, dataSelector, "1");

        //Complete the registration process based on the criteria specified in the data.json file.
        tools.booleanFieldFiller(registerPage.subscribeYes, registerPage.subscribeNo, Subscribe);
        tools.booleanFieldFiller(registerPage.agreeCheckBox, null, conditionAgree);
        tools.booleanFieldFiller(registerPage.continueButton, null, continueClick);

            //ASSERT
        WebElement loginCheckedText = driver.findElement(By.linkText("Logout"));

        Assertions.assertEquals(true, loginCheckedText.isDisplayed());

    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Registration tests")
    @Description("Registration with incorrect email data")
    @DisplayName("TC03")
    @Severity(SeverityLevel.CRITICAL)
    public void testingRegistrationBadEmail() throws IOException {

            //PAGEFACTORY
        RegisterPage registerPage = (RegisterPage) PageFactory.Create("RegisterPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        //Navigate to the registration page
        driver.get(registerPage.registrationURL);

        //Collecting the web elements to be filled in an array, THE ORDER IS IMPORTANT!
        By[] elements = {
                registerPage.firstNameField,
                registerPage.lastNameField,
                registerPage.emailField,
                registerPage.telephoneField,
                registerPage.passwordField,
                registerPage.passwordConfirmField};

        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "fName",
                "lName",
                "email",
                "phone",
                "passWord",
                "passWord"};

        //Using a method we have written to fill in the data
        //USER 2 !
        tools.dataFiller(elements, dataSelector, "2");

        //Complete the registration process based on the criteria specified in the data.json file.
        tools.booleanFieldFiller(registerPage.subscribeYes, registerPage.subscribeNo, Subscribe);
        tools.booleanFieldFiller(registerPage.agreeCheckBox, null, conditionAgree);
        tools.booleanFieldFiller(registerPage.continueButton, null, continueClick);

            //ASSERT

        WebElement emailCheckedText = driver.findElement(By.xpath("//*[ text() = \"E-Mail Address does not appear to be valid!\"]"));
        Assertions.assertEquals(true, emailCheckedText.isDisplayed());

    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Registration tests")
    @Description("Registration with missing data")
    @DisplayName("TC04")
    @Severity(SeverityLevel.CRITICAL)
    public void testingRegistrationMissingData() throws IOException {

            //PAGEFACTORY
        RegisterPage registerPage = (RegisterPage) PageFactory.Create("RegisterPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST
        //Navigate to the registration page
        driver.get(registerPage.registrationURL);

        //Collecting the web elements to be filled in an array, THE ORDER IS IMPORTANT!
        By[] elements = {
                registerPage.firstNameField,
                registerPage.lastNameField,
                registerPage.emailField,
                registerPage.telephoneField,
                registerPage.passwordField,
                registerPage.passwordConfirmField};

        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "fName",
                "lName",
                "email",
                "phone",
                "passWord",
                "passWord"};

        //Using a method we have written to fill in the data
        //USER 3 !
        tools.dataFiller(elements, dataSelector, "3");

        //Complete the registration process based on the criteria specified in the data.json file.
        tools.booleanFieldFiller(registerPage.subscribeYes, registerPage.subscribeNo, Subscribe);
        tools.booleanFieldFiller(registerPage.agreeCheckBox, null, conditionAgree);
        tools.booleanFieldFiller(registerPage.continueButton, null, continueClick);

            //ASSERT

        WebElement phoneCheckedText = driver.findElement(By.xpath("//*[ text() = \"Telephone must be between 3 and 32 characters!\"]"));
        Assertions.assertEquals(true, phoneCheckedText.isDisplayed());

    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Registration tests")
    @Description("Registration with too easy password")
    @DisplayName("TC05")
    @Severity(SeverityLevel.CRITICAL)
    public void testingRegistrationEasyPassword() throws IOException, InterruptedException {

        //PAGEFACTORY
        RegisterPage registerPage = (RegisterPage) PageFactory.Create("RegisterPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

        //TEST
        //Navigate to the registration page
        driver.get(registerPage.registrationURL);

        //Collecting the web elements to be filled in an array, THE ORDER IS IMPORTANT!
        By[] elements = {
                registerPage.firstNameField,
                registerPage.lastNameField,
                registerPage.emailField,
                registerPage.telephoneField,
                registerPage.passwordField,
                registerPage.passwordConfirmField};

        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {"fName", "lName", "email", "phone", "passWord", "passWord"};
        //Using a method we have written to fill in the data
        //USER 4 !
        tools.dataFiller(elements, dataSelector, "4");

        //Complete the registration process based on the criteria specified in the data.json file.
        tools.booleanFieldFiller(registerPage.subscribeYes, registerPage.subscribeNo, Subscribe);
        tools.booleanFieldFiller(registerPage.agreeCheckBox, null, conditionAgree);
        tools.booleanFieldFiller(registerPage.continueButton, null, continueClick);

                //ASSERT
        Thread.sleep(5000);
        String expectedURL = "https://www.hangszerdiszkont.hu/index.php?route=account/register&popup=register";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());


    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Registration tests")
    @Description("Registration with incorrect char types")
    @DisplayName("TC06")
    @Severity(SeverityLevel.NORMAL)
    public void testingRegistrationIncorrectChar() throws IOException, InterruptedException {

            //PAGEFACTORY
        RegisterPage registerPage = (RegisterPage) PageFactory.Create("RegisterPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        //Navigate to the registration page
        driver.get(registerPage.registrationURL);

        //Collecting the web elements to be filled in an array, THE ORDER IS IMPORTANT!
        By[] elements = {registerPage.firstNameField, registerPage.lastNameField, registerPage.emailField,
                registerPage.telephoneField, registerPage.passwordField, registerPage.passwordConfirmField};

        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {"fName", "lName", "email", "phone", "passWord", "passWord"};

        //Using a method we have written to fill in the data
        //USER 5 !
        tools.dataFiller(elements, dataSelector, "5");

        //Complete the registration process based on the criteria specified in the data.json file.
        tools.booleanFieldFiller(registerPage.subscribeYes, registerPage.subscribeNo, Subscribe);
        tools.booleanFieldFiller(registerPage.agreeCheckBox, null, conditionAgree);
        tools.booleanFieldFiller(registerPage.continueButton, null, continueClick);

            //ASSERT

        //The site is sometimes slow to respond, which is why all this sleep is necessary
        Thread.sleep(5000);
        String expectedURL = "https://www.hangszerdiszkont.hu/index.php?route=account/register&popup=register";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());

    }
}
