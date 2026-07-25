package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPageObject extends AbstractComponents {
    WebDriver driver;
    public CartPageObject(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public static final String expectedTitle = "Shopping Cart";
    public static final String prodName_xPath="//a[contains(@href,'/product_details')]";
    public static String quantity_xPath ="//td[@class='cart_quantity']//button";
    public static final String pageTitle_xPath = "//li[@class='active']";
    public static final String checkOutBtn_xPath="//a[@class='btn btn-default check_out']";
    public static final String loginBtn_xPath ="//p[.='Register / Login']";
    public static final String removeProdBtn_xPath="//a[@class='cart_quantity_delete']";

    @FindBy(xpath = pageTitle_xPath)
    public WebElement pageTitle;
    @FindBy(xpath = checkOutBtn_xPath)
    public WebElement checkOutBtn;
    @FindBy(xpath = loginBtn_xPath)
    public WebElement loginBtn;
    @FindBy(xpath = removeProdBtn_xPath)
    public WebElement removeBtn;
    @FindBy(xpath = prodName_xPath)
    public List<WebElement> prodCartList;

}
