import org.openqa.selenium.WebDriver;

public class PageFactory {
    public static PageBase Create(String name, WebDriver driver){
        switch (name){
            case "LandingPage":
                return new LandingPage(driver);
            case "RegisterPage":
                return new RegisterPage(driver);
            case "LoginPage":
                return new LoginPage(driver);
            case "Tools":
                return new Tools(driver);
            case "GSPage":
                return new GoodsPage(driver);
            default:
                return null;
        }
    }
}
