import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tools extends PageBase {


    public Tools(WebDriver drv) {
        super(drv);
    }

    public void buttonClicker(By ButtonLoc){
        WebElement button = driver.findElement(ButtonLoc);
        button.click();
    }



}
