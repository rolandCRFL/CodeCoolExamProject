
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends PageBase {

    final By firstNameField = By.xpath("//*[@id=\"input-firstname\"]");
    final By lastNameField = By.id("input-lastname");
    final By emailField = By.id("input-email");
    final By telephoneField = By.id("input-telephone");
    final By passwordField = By.id("input-password");
    final By passwordConfirmField = By.id("input-confirm");
    final By agreeCheckBox = By.name("agree");
    final String registrationURL = "https://www.hangszerdiszkont.hu/index.php?route=account/register&popup=register";
    final By subscribeYes = By.cssSelector("body > div > form > fieldset:nth-child(3) > div > div > label:nth-child(1) > input[type=radio]");
    final By subscribeNo = By.cssSelector("body > div > form > fieldset:nth-child(3) > div > div > label:nth-child(2) > input[type=radio]");
    final By continueButton = By.xpath("/html/body/div/form/div[2]/div/button");

    //Constructor
    public RegisterPage(WebDriver drv) {
        super(drv);
    }


}
