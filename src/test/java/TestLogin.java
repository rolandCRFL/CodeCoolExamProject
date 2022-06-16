import org.junit.jupiter.api.Test;

public class TestLogin extends TestBase{

    LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
    LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);
    Tools tools = (Tools) PageFactory.Create("Tools", driver);
    @Test
    public void testingLogin(){

        tools.buttonClicker(landingPage.myAccountButton);
        driver.findElement(loginPage.emailAddressField).sendKeys(emaill);


    }

}
