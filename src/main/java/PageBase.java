import org.openqa.selenium.WebDriver;

public class PageBase {
    static WebDriver driver;

    public static String listDataFilePath = "src/test/listData.json";
    public static String dataFilePath = "src/test/data.json";
    public static String guitarStringsFilePath = "src/test/guitarStrings.json";
    public static String headPhonesFilePath = "src/test/headPhones.json";
    public static final int TAB = 4;

    //Constructor
    public PageBase(WebDriver drv){
        driver = drv;
    }
}
