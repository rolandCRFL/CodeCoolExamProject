import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestLogin extends TestBase{

    LandingPage landingPage = (LandingPage) PageFactory.Create("LandingPage",driver);
    LoginPage loginPage = (LoginPage) PageFactory.Create("LoginPage", driver);

    @Test
    public void testingLogin(){


        String namez = jsonData.getString("fName");

        System.out.println(namez);
        //Tools tools = (Tools) PageFactory.Create("Tools", driver);

        //tools.buttonClicker(landingPage.myAccountButton);



    }

}
