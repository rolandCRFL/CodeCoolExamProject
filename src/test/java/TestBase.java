import io.github.bonigarcia.wdm.WebDriverManager;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestBase  {

     public WebDriver driver;

     public ArrayList<String> guitarCategoryList;

     public ArrayList<String> guitarStringList;

     public
    String firstName;

    {
        try {
            firstName = jSonStringCollector("fName");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String lastName;

    {
        try {
            lastName = jSonStringCollector("lName");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String email;

    {
        try {
            email = jSonStringCollector("email");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String phone;

    {
        try {
            phone = jSonStringCollector("phone");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String passWord;

    {
        try {
            passWord = jSonStringCollector("passWord");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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


    String url = "https://www.hangszerdiszkont.hu/";

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
        //options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
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





}
