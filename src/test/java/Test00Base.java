import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Test00Base {

     public WebDriver driver;

     public ArrayList<String> guitarCategoryList;
     public ArrayList<String> microphoneCategoryList;
     public ArrayList<String> studioCategoryList;

     public ArrayList<String> guitarStringList = new ArrayList<>();
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

//    public Test00Base()  {}
    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("−−incognito");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.hangszerdiszkont.hu/");

    }

    @AfterEach
    public void evidenceKiller(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

        //METHODS

    public Boolean jSonBooleanCollector(String data) throws IOException {
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
        return tools.readJsonObject(PageBase.dataFilePath).getBoolean(data);

    }
    public void takeScreenshot(){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    public void takeScreenShot(String text){
        Allure.addAttachment(text, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }





}
