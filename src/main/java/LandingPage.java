import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends PageBase {

    final By myAccountButton = By.cssSelector("body > div.site-wrapper > header > div.header.header-classic.header-lg > div.top-bar.navbar-nav > div.top-menu.secondary-menu > div > ul > li.menu-item.top-menu-item.top-menu-item-2");
    final By cookiesDetailButton = By.xpath("//*[@id=\"cookie-bar-prompt-button\"]");
    final By cookiesAcceptButton = By.xpath("//*[@id=\"cookie-bar-button\"]");
    final By cookiesBar = By.xpath("//*[@id=\"cookie-bar\"]");
    final String cookiesPageURL = "https://www.hangszerdiszkont.hu/adatvedelmi-tajekoztato";
    final By guitarCategoryButton = By.linkText("Guitar");
    final By guitarCategoryTexts = By.xpath("//*[@id=\"content\"]//*[@class=\"links-text\"]");
    final By guitarStringsButton = By.xpath("//*[@id=\"content\"]/div[1]/div/div[16]/a");
    ////*[@class="top-menu secondary-menu"]//*[@class="menu-item top-menu-item top-menu-item-2"]

    public LandingPage(WebDriver drv) {
        super(drv);
    }







}
