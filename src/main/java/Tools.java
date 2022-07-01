import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Tools extends PageBase {



    public Tools(WebDriver drv) {
        super(drv);
    }

    //Clicker method with single or double click
    public void buttonClicker(By ButtonLoc, Boolean doubleClick){
        WebElement button = driver.findElement(ButtonLoc);
        if(doubleClick){
            Actions action = new Actions(driver);
            action.doubleClick(button).perform();
        } else button.click();
    }

    //Send String data to web element
    public void stringFieldFiller(By element, String fillerData){
        driver.findElement(element).sendKeys(fillerData);}

    //Send a boolean to select the appropriate element
    public void booleanFieldFiller(By elementYes, By elementNo, Boolean fillerData){
        if(fillerData) driver.findElement(elementYes).click();
        else if (elementNo == null) ;
        else driver.findElement(elementNo).click();
    }

    //Switch to the next open window
    public void windowHandlerNextOpen(){
        String mainPage=driver.getWindowHandle();
        Set s=driver.getWindowHandles();
        Iterator iter=s.iterator();
        while(iter.hasNext())
        {
            String windowHandle=iter.next().toString();
            if(!windowHandle.contains(mainPage))
            {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    //Load elements into String list
    public ArrayList elementToListString(By elements){
        List<WebElement> elems = driver.findElements(elements);
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(WebElement element:elems){stringArrayList.add(element.getText());}
        return stringArrayList;
    }


    public JSONObject readJsonObject(String filePath) throws IOException {
        String jsonDataAsString;
        jsonDataAsString = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonData = new JSONObject(jsonDataAsString);
        return jsonData;
    }
    public JSONArray readJsonArray(String filePath) throws IOException {

        String jsonDataAsString;
        jsonDataAsString = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray jsonData = new JSONArray(jsonDataAsString);
        return jsonData;
    }
    public void saveToJson(ArrayList<String> data, String file) throws IOException {
        JSONArray jsonarray = new JSONArray(data.toArray());
        FileWriter writer = new FileWriter(file);
        writer.write(jsonarray.toString(TAB));
        writer.close();
    }

    public ArrayList<String> jSonArrayToStringArray(JSONArray jsonArray){

        ArrayList<String> listdata = new ArrayList<>();
        for (int i = 0; i<jsonArray.length();i++){
            listdata.add((String) jsonArray.get(i));
        }
        return listdata;
    }

    public int getTotalPagesNumberFromStringElement(By textLoc ){
        String text = driver.findElement(textLoc).getText();
        int indexOfParser = text.indexOf("(");
        String totalPagesInString = text.substring(indexOfParser+1,indexOfParser+2);
        int totalPages = Integer.parseInt(totalPagesInString);
        return totalPages;
    }
    public ArrayList<String> getTextToArrayList(By elementsLoc, ArrayList<String> arrayList){
        List<WebElement> elements = driver.findElements(elementsLoc);
        for(WebElement ele:elements){
            arrayList.add(ele.getText());
        }
        return arrayList;

    }
    public String getGoodsURL(){
        String URL = driver.getCurrentUrl();
        String endOfUrl = "?page=";
        String result = URL.concat(endOfUrl);
        return result;
    }

    public String jSonStringCollector(String data) throws IOException {
        return readJsonObject(PageBase.dataFilePath).getString(data);
    }

    public Boolean jSonBooleanCollector(String data) throws IOException {
        return readJsonObject(PageBase.dataFilePath).getBoolean(data);
    }

    public void modifyData(By element, String data) throws IOException {
        driver.findElement(element).sendKeys(Keys.LEFT_CONTROL,"A");
        driver.findElement(element).sendKeys(readJsonObject(PageBase.dataFilePath).getString(data));
    }

    public void dataFiller(By[] elements, String[] data, String accountSelector ) throws IOException {

        for (int i = 0; i < elements.length; i++) {
            driver.findElement(elements[i]).sendKeys(Keys.LEFT_CONTROL,"A");
            driver.findElement(elements[i]).sendKeys(readJsonObject(PageBase.dataFilePath).getString(data[i]+accountSelector));

        }
    }
    //Create a for loop that will allow you to add the page number to the URL you just stored, one by one, and extract the data you want to an ArrayList.
    public void paginizer(int totalPagesNumber,By goodsStringName, ArrayList<String> StringList) throws InterruptedException {
        String pageURL = getGoodsURL();
        for (int i =2; i<totalPagesNumber+2; i++){
            Thread.sleep(500);
            getTextToArrayList(goodsStringName,StringList);
            if (i<totalPagesNumber+1){
                String newPageURL = pageURL.concat(String.valueOf(i));
                driver.get(newPageURL);}
        }
    }

}
