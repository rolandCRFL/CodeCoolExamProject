import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TestDataOperations extends TestBase{


    @Test
    public void TestDataList(){
                //PAGEFACTORY
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

                //TEST

        //Double-click on the web item to access the guitar categories
        tools.buttonClicker(landingPage.guitarCategoryButton,true);
        //In an ArrayList called "list", we upload the names of the categories
        guitarCategoryList = tools.elementToListString(landingPage.guitarCategoryTexts);

                //ASSERTION

        //Check that the "list" array is indeed filled with elements
        Assertions.assertNotNull(guitarCategoryList);

    }

    @Test
    public void TestDataListSave() throws IOException {
                //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

                //TEST

        // To create the list, we run our previous list creation method
        TestDataList();
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

    @Test
    public void TestNewDataInput(){
                //PAGEFACTORY
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);

                //TEST



        tools.buttonClicker(landingPage.myAccountButton,false);

    }

}
