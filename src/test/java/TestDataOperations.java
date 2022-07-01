import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;

public class TestDataOperations extends TestBase{

// KIVEZETVE A TestListingData osztályba
//    @Test
//    public void TestDataList(){
//                //PAGEFACTORY
//        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
//        Tools tools = (Tools) PageFactory.Create("Tools", driver);
//
//                //TEST
//
//        //Double-click on the web item to access the guitar categories
//        tools.buttonClicker(landingPage.guitarCategoryButton,true);
//        //In an ArrayList called "list", we upload the names of the categories
//        guitarCategoryList = tools.elementToListString(landingPage.categoryTexts);
//
//                //ASSERTION
//
//        //Check that the "list" array is indeed filled with elements
//        Assertions.assertNotNull(guitarCategoryList);
//
//    }

    @Test
    public void TestDataListSave() throws IOException {
                //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

                //TEST

        // To create the list, we run our previous list creation method
        //TestDataList();
        // After listing the data, we upload it to a JSON file
        tools.saveToJson(guitarCategoryList,PageBase.listDataFilePath);

                //ASSERTION

        // Read file contents
        JSONArray jsonArray = tools.readJsonArray(PageBase.listDataFilePath);
        // Convert JSONArray to String Array
        ArrayList<String> jsList = tools.jSonArrayToStringArray(jsonArray);
        // Compare
        Assertions.assertEquals(guitarCategoryList,jsList);
    }


    //KIVEZETVE A TESTNEWDATAINPUT-BA!
    /*
    @Test
    public void TestNewDataInput() throws IOException {
                //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);


                //TEST
        driver.findElement(landingPage.searchBarInput).sendKeys(tools.jSonStringCollector("searchWord"));
        driver.findElement(landingPage.searchButton).click();
                //ASSERT
        String assertString = driver.findElement(landingPage.searchResultText).getText();
        Assertions.assertTrue(assertString.contains(tools.jSonStringCollector("searchWord")));
    }
    */


    //KIVEZETVE A TESTMODIFYEXISTINGDATA-ba!
    /*
    @Test
    public void TestExistDataModify() throws IOException {
                //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

                //TEST

        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email3"));
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord1"));
        tools.buttonClicker(loginPage.loginButton,false);
        driver.findElement(loginPage.editAccountInformationButton).click();

        By[] elems = {loginPage.firstNameField,loginPage.lastNameField,loginPage.emailAddressField,loginPage.telephoneField};
        String array[] = {"fName","lName","email","phone"};

        tools.dataFiller(elems,array,"3");

        driver.findElement(loginPage.continueButton).click();
                //ASSERT

        String exceptedResultText = "Success: Your account has been successfully updated.";
        String result = driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText();
        Assertions.assertTrue(result.contains(exceptedResultText));

    }

     */
    //KISZERVEZVE A TESTDELETEDATA osztályba!
    /*
    @Test
    public void TestExistDataDelete() throws IOException {
                //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

                //TEST

        tools.buttonClicker(landingPage.myAccountButton,false);
        driver.findElement(loginPage.emailAddressField).sendKeys(tools.jSonStringCollector("email3"));
        driver.findElement(loginPage.passwordField).sendKeys(tools.jSonStringCollector("passWord1"));
        tools.buttonClicker(loginPage.loginButton,false);
        driver.findElement(loginPage.editAccountInformationButton).click();

        driver.findElement(loginPage.firstNameField).sendKeys(Keys.LEFT_CONTROL,"A",Keys.DELETE);

        driver.findElement(loginPage.continueButton).click();

                //ASSERT
        String result = driver.findElement(By.xpath("//*[@id=\"account\"]/div[1]/div/div")).getText();
        String expectedResult = "First Name must be between 1 and 32 characters!";

        Assertions.assertTrue(result.contains(expectedResult));


    }

     */

}
