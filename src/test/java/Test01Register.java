import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Test01Register extends Test00Base {

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Registration")
    @Feature("Valid tests")
    @Story("Availability tests")
    @Description("To check if the page is available")
    @DisplayName("TC01 - Site Availability")
    @Severity(SeverityLevel.CRITICAL)
    public void testSiteAvailability() {
            //TEST

        //Navigate to the site
        driver.get(siteUrl);
        //The site logo will be the basis for verification
        WebElement pageLogo = driver.findElement(By.xpath("//*[@id=\"logo\"]"));
        takeScreenShot("Available check");

            //ASSERT

        //Check that the logo is displayed on the page
        Assertions.assertEquals(true, pageLogo.isDisplayed());

    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Registration")
    @Feature("USER 1")
    @Feature("Valid tests")
    @Feature("BUGS")
    @Story("Registration valid")
    @Description("Registration with correctly filled data (USER 1) - BUG #1")
    @DisplayName("TC02")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegCorrectData() throws IOException, InterruptedException {
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
                registerPage.telephoneField,
                registerPage.passwordField,
                registerPage.passwordConfirmField};
        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "fName",
                "lName",
                "phone",
                "passWord",
                "passWord"};
        //Using a method we have written to fill in the data
        //USER 1 !
        tools.dataFiller(elements, dataSelector, "1");
        //You will need a randomly generated email address to run the test in sequence.
        driver.findElement(registerPage.emailField).sendKeys(tools.randomMail());
        //Complete the registration process based on the criteria specified in the data.json file.
        tools.booleanFieldFiller(registerPage.subscribeYes, registerPage.subscribeNo, Subscribe);
        tools.booleanFieldFiller(registerPage.agreeCheckBox, null, conditionAgree);
        takeScreenShot("Data filled, BEFORE");
        tools.booleanFieldFiller(registerPage.continueButton, null, continueClick);

            //ASSERT
        Thread.sleep(1500);
        WebElement loginCheckedText = driver.findElement(By.linkText("Logout"));
        takeScreenShot("AFTER");
        Assertions.assertEquals(true, loginCheckedText.isDisplayed());
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Registration")
    @Feature("USER 2")
    @Feature("Valid tests")
    @Story("Registration valid")
    @Description("Registration with incorrect email data (USER 2)")
    @DisplayName("TC03")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegBadEmail() throws IOException, InterruptedException {
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
        takeScreenShot("Data filled, BEFORE");
        tools.booleanFieldFiller(registerPage.continueButton, null, continueClick);

            //ASSERT
        Thread.sleep(1500);
        WebElement emailCheckedText = driver.findElement(By.xpath("//*[ text() = \"E-Mail Address does not appear to be valid!\"]"));
        takeScreenShot("AFTER");
        Assertions.assertEquals(true, emailCheckedText.isDisplayed());
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Registration")
    @Feature("USER 3")
    @Feature("Valid tests")
    @Story("Registration valid")
    @Description("Registration with missing data (USER 3)")
    @DisplayName("TC04")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegMissingData() throws IOException, InterruptedException {
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
                registerPage.telephoneField,
                registerPage.passwordField,
                registerPage.passwordConfirmField};
        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "fName",
                "lName",
                "phone",
                "passWord",
                "passWord"};
        //Using a method we have written to fill in the data
        //USER 3 !
        tools.dataFiller(elements, dataSelector, "3");
        //You will need a randomly generated email address to run the test in sequence.
        driver.findElement(registerPage.emailField).sendKeys(tools.randomMail());
        //Complete the registration process based on the criteria specified in the data.json file.
        tools.booleanFieldFiller(registerPage.subscribeYes, registerPage.subscribeNo, Subscribe);
        tools.booleanFieldFiller(registerPage.agreeCheckBox, null, conditionAgree);
        takeScreenShot("Data filled, BEFORE");
        tools.booleanFieldFiller(registerPage.continueButton, null, continueClick);

            //ASSERT
        Thread.sleep(1500);
        WebElement phoneCheckedText = driver.findElement(By.xpath("//*[text() = \"Telephone must be between 3 and 32 characters!\"]"));
        takeScreenShot("AFTER");
        Assertions.assertEquals(true, phoneCheckedText.isDisplayed());
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Registration")
    @Feature("USER 4")
    @Feature("Invalid tests")
    @Feature("BUGS")
    @Story("Registration invalid")
    @Description("Registration with too easy password (USER 4) - BUG #2")
    @DisplayName("TC05")
    @Severity(SeverityLevel.NORMAL)
    public void testRegEasyPassword() throws IOException, InterruptedException {
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
                registerPage.telephoneField,
                registerPage.passwordField,
                registerPage.passwordConfirmField};
        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "fName",
                "lName",
                "phone",
                "passWord",
                "passWord"};
        //Using a method we have written to fill in the data
        //USER 4 !
        tools.dataFiller(elements, dataSelector, "4");
        //You will need a randomly generated email address to run the test in sequence.
        driver.findElement(registerPage.emailField).sendKeys(tools.randomMail());
        //Complete the registration process based on the criteria specified in the data.json file.
        tools.booleanFieldFiller(registerPage.subscribeYes, registerPage.subscribeNo, Subscribe);
        tools.booleanFieldFiller(registerPage.agreeCheckBox, null, conditionAgree);
        takeScreenShot("Data filled, BEFORE");
        tools.booleanFieldFiller(registerPage.continueButton, null, continueClick);

            //ASSERT

        //Sleep is required due to the late response of the page.
        Thread.sleep(1500);
        takeScreenShot("AFTER");
        String expectedURL = "https://www.hangszerdiszkont.hu/index.php?route=account/register&popup=register";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Feature("Registration")
    @Feature("USER 5")
    @Feature("Invalid tests")
    @Feature("BUGS")
    @Story("Registration invalid")
    @Description("Registration with incorrect char types (USER 5) - BUG #3")
    @DisplayName("TC06")
    @Severity(SeverityLevel.MINOR)
    public void testRegIncorrectChar() throws IOException, InterruptedException {
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
                registerPage.telephoneField,
                registerPage.passwordField,
                registerPage.passwordConfirmField};
        //Collecting the data to be filled into an array. The order is important, it must be consistent with the order of the previously created web elements!
        String[] dataSelector = {
                "fName",
                "lName",
                "phone",
                "passWord",
                "passWord"};
        //Using a method we have written to fill in the data
        //USER 5 !
        tools.dataFiller(elements, dataSelector, "5");
        //You will need a randomly generated email address to run the test in sequence.
        driver.findElement(registerPage.emailField).sendKeys(tools.randomMail());
        //Complete the registration process based on the criteria specified in the data.json file.
        tools.booleanFieldFiller(registerPage.subscribeYes, registerPage.subscribeNo, Subscribe);
        tools.booleanFieldFiller(registerPage.agreeCheckBox, null, conditionAgree);
        takeScreenShot("Data filled, BEFORE");
        tools.booleanFieldFiller(registerPage.continueButton, null, continueClick);

            //ASSERT

        //The site is sometimes slow to respond, which is why all this sleep is necessary
        Thread.sleep(1500);
        takeScreenShot("AFTER");
        String expectedURL = "https://www.hangszerdiszkont.hu/index.php?route=account/register&popup=register";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());
    }
}
