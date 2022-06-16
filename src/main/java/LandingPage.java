import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends PageBase {

    final By myAccountButton = By.cssSelector("body > div.site-wrapper > header > div.header.header-classic.header-lg > div.top-bar.navbar-nav > div.top-menu.secondary-menu > div > ul > li.menu-item.top-menu-item.top-menu-item-2");




    public LandingPage(WebDriver drv) {
        super(drv);
    }







}
