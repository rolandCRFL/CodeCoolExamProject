import io.qameta.allure.*;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TestDataSave extends TestBase{


    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Data save")
    @Description("Saving guitar category list to a file")
    @DisplayName("TC26")
    @Severity(SeverityLevel.NORMAL)
    public void TestDataListSave() throws IOException {
                //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

                //TEST

        // Create a list from guitar category
        tools.buttonClicker(landingPage.guitarCategoryButton,true);
        //In an ArrayList (in TestBase) called "list", we upload the names of the categories
        guitarCategoryList = tools.elementToListString(landingPage.categoryTexts);

        // After listing the data, we upload it to a JSON file with a method we have written
        tools.saveToJson(guitarCategoryList,PageBase.listDataFilePath);

                //ASSERTION

        // Read file contents with a method we have written
        JSONArray jsonArray = tools.readJsonArray(PageBase.listDataFilePath);
        // Convert JSONArray to String Array with a method we have written
        ArrayList<String> jsList = tools.jSonArrayToStringArray(jsonArray);
        // Compare
        Assertions.assertEquals(guitarCategoryList,jsList);
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Data save")
    @Description("Accessing guitar string pages and the name of each string is stored in a JSON file ")
    @DisplayName("TC27")
    @Severity(SeverityLevel.NORMAL)
    public void TestMultiplePagesStringSave() throws IOException, InterruptedException {
        //PAGEFACTORY

        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        GoodsPage goodsPage = (GoodsPage) PageFactory.Create("GSPage",driver);

        //TEST

        //Double-click on the web item to access the guitar categories
        tools.buttonClicker(landingPage.guitarCategoryButton,true);
        //Select a sub-category
        tools.buttonClicker(landingPage.guitarStringsButton,false);
        //Create a local integer variable to store the number of available pages
        int totalPagesNumber = tools.getTotalPagesNumberFromStringElement(goodsPage.pageSizeLoc);
        //We use a method we have written to scroll through the pages and the given data is extracted into an array
        tools.paginizer(totalPagesNumber,goodsPage.goodsStringName,guitarStringList);

        //Finally, save your data to a file.
        tools.saveToJson(guitarStringList,PageBase.guitarStringsFilePath);

        //ASSERT

        // Read file contents
        JSONArray jsonArray = tools.readJsonArray(PageBase.guitarStringsFilePath);
        // Convert JSONArray to String Array
        ArrayList<String> jsList = tools.jSonArrayToStringArray(jsonArray);
        // Compare
        Assertions.assertEquals(guitarStringList,jsList);
    }

    @RepeatedTest(1)
    @Epic("Hangszerdiszkont.hu")
    @Story("Data save")
    @Description("Accessing headphones pages and the name of each headphones is stored in a JSON file ")
    @DisplayName("TC28")
    @Severity(SeverityLevel.NORMAL)
    public void TestMultiplePagesHeadphoneSave() throws IOException, InterruptedException {
        //PAGEFACTORY

        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        GoodsPage goodsPage = (GoodsPage) PageFactory.Create("GSPage",driver);

        //TEST

        //Double-click on the web item to access the studio categories
        tools.buttonClicker(landingPage.studioCategoryButton,true);
        //Select a sub-category
        tools.buttonClicker(landingPage.headphoneButton,false);
        //Create a local integer variable to store the number of available pages
        int totalPagesNumber = tools.getTotalPagesNumberFromStringElement(goodsPage.pageSizeLoc);
        //We use a method we have written to scroll through the pages and the given data is extracted into an array
        tools.paginizer(totalPagesNumber,goodsPage.goodsStringName,headPhoneList);

        //Finally, save your data to a file.
        tools.saveToJson(headPhoneList,PageBase.headPhonesFilePath);

        //ASSERT

        // Read file contents
        JSONArray jsonArray = tools.readJsonArray(PageBase.headPhonesFilePath);
        // Convert JSONArray to String Array
        ArrayList<String> jsList = tools.jSonArrayToStringArray(jsonArray);
        // Compare
        Assertions.assertEquals(headPhoneList,jsList);
    }

}
