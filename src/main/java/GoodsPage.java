import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodsPage extends PageBase{


    final By pageSizeLoc = By.xpath("//*[@class=\"col-sm-6 text-right\"]");
    final By goodsStringName = By.xpath("//*[@class=\"main-products product-grid\"]//*[@class=\"name\"]");

    //Constructor
    public GoodsPage(WebDriver drv) {super(drv);}
}
