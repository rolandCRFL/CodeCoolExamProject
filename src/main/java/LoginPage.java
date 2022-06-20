import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    final By emailAddressField = By.id("input-email");
    final By passwordField = By.id("input-password");
    final By loginButton = By.xpath("//button[@data-loading-text=\"<span>Login</span>\"]");





    //constructor
    public LoginPage(WebDriver drv) {
        super(drv);
    }
}
