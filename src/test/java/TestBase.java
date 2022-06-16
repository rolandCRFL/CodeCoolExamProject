import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONObject;
import org.junit.Test;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class TestBase  {

     public WebDriver driver;

    String jsonDataAsString;

    {
        try {
            jsonDataAsString = new String(Files.readAllBytes(Paths.get("src/test/data.json")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    JSONObject jsonData = new JSONObject(jsonDataAsString);
    String firstName = jSonStringCollector("fName");
    String lastName = jSonStringCollector("lName");
    String email = jSonStringCollector("email");
    String phone = jSonStringCollector("phone");
    String passWord = jSonStringCollector("passWord");
    Boolean Subscribe = jSonBooleanCollector("Subscribe");
    Boolean conditionAgree = jSonBooleanCollector("conditionAgree");
    Boolean continueClick = jSonBooleanCollector("continueClick");



    String url = "https://www.hangszerdiszkont.hu/";

    public TestBase()  {
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
        //options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("https://www.hangszerdiszkont.hu/");


    }

    public String jSonStringCollector(String data){
        return jsonData.getString(data);
    }
    public Boolean jSonBooleanCollector(String data){
        return jsonData.getBoolean(data);

    }





}
