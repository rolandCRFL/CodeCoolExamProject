import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class TestRegister extends TestBase{

//    String firstName = "Roland";
//    String lastName = "Crisan";
//    String email = "valami@valami.hu";
//    String phone = "06304573264";
//    String passWord = "belavagyok";
//    Boolean Subscribe = true;
//    Boolean conditionAgree = true;
//    Boolean continueClick = false;



    @Test
    public void testingRegistration(){
        RegisterPage registerPage = (RegisterPage) PageFactory.Create("RegisterPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        driver.get(registerPage.registrationURL);
//        registerPage.fieldFiller("FirstName", firstName,null);
//        registerPage.fieldFiller("LastName", lastName,null);
//        registerPage.fieldFiller("Email", email,null);
//        registerPage.fieldFiller("Phone", phone, null);
//        registerPage.fieldFiller("Password", passWord, null);
//        registerPage.fieldFiller("Subscribe", null, Subscribe );
//        registerPage.fieldFiller("Agree",null, conditionAgree);
//        registerPage.fieldFiller("ContinueClick", null,continueClick);
        tools.stringFieldFiller(registerPage.firstNameField,firstName);
        tools.stringFieldFiller(registerPage.lastNameField,lastName);
        tools.stringFieldFiller(registerPage.telephoneField,phone);
        tools.stringFieldFiller(registerPage.emailField,email);
        tools.stringFieldFiller(registerPage.passwordField,passWord);
        tools.stringFieldFiller(registerPage.passwordConfirmField,passWord);
        tools.booleanFieldFiller(registerPage.subscribeYes,registerPage.subscribeNo,Subscribe);
        tools.booleanFieldFiller(registerPage.agreeCheckBox, null, conditionAgree);
        tools.booleanFieldFiller(registerPage.continueButton,null,continueClick);



    }


}
