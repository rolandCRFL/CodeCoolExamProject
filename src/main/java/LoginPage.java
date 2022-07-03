import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    final By emailAddressField = By.id("input-email");
    final By passwordField = By.id("input-password");
    final By passwordConfirmField = By.id("input-confirm");
    final By loginButton = By.xpath("//button[@data-loading-text=\"<span>Login</span>\"]");
    final By editAccountInformationButton = By.xpath("//*[@class=\"edit-info\"]");
    final By editAccountPasswordButton = By.xpath("//*[@class=\"edit-pass\"]");
    final By firstNameField = By.id("input-firstname");
    final By lastNameField = By.id("input-lastname");
    final By telephoneField = By.id("input-telephone");
    final By continueButton = By.xpath("//*[@class=\"pull-right\"]//*[@type=\"submit\"]");


    //Constructor
    public LoginPage(WebDriver drv) {
        super(drv);
    }
}
