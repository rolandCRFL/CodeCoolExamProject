import io.github.bonigarcia.wdm.WebDriverManager;

//import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestBase  {

     public WebDriver driver;

     public ArrayList<String> guitarCategoryList;
     public ArrayList<String> microphoneCategoryList;
     public ArrayList<String> studioCategoryList;

     public ArrayList<String> guitarStringList;
     public ArrayList<String> headPhoneList = new ArrayList<>();

    Boolean Subscribe;

    {
        try {
            Subscribe = jSonBooleanCollector("Subscribe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Boolean conditionAgree;

    {
        try {
            conditionAgree = jSonBooleanCollector("conditionAgree");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Boolean continueClick;

    {
        try {
            continueClick = jSonBooleanCollector("continueClick");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    String siteUrl = "https://www.hangszerdiszkont.hu/";

    public TestBase()  {
        this.guitarStringList = new ArrayList<>();
    }


    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("−−incognito");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.hangszerdiszkont.hu/");



    }


    public String jSonStringCollector(String data) throws IOException {
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        return tools.readJsonObject(PageBase.dataFilePath).getString(data);
    }
    public Boolean jSonBooleanCollector(String data) throws IOException {
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        return tools.readJsonObject(PageBase.dataFilePath).getBoolean(data);

    }

    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver){
        return((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }





}
