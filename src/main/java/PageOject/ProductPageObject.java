package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPageObject extends AbstractComponents {
    public ProductPageObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public static final String expectedTitle="ALL PRODUCTS";
    public static final String searchProdTitle="SEARCHED PRODUCTS";

    public static final String pageTitle_xPath="//h2[@class='title text-center']";
    @FindBy(xpath = pageTitle_xPath)
    public WebElement pageTitle;

    public static final String prodList_xPath="//div[@class='productinfo text-center']//p";
    @FindBy(xpath = prodList_xPath)
    public List<WebElement> prodList;

    public static final String addCartBtn_xPath="//a[@class='btn btn-default add-to-cart']";
    @FindBy(xpath = addCartBtn_xPath)
    public List<WebElement> addCartList;

    public static final String viewProd_xPath="//a[contains(@href,'/product_detail')]";
    @FindBy(xpath = viewProd_xPath)
    public List<WebElement> viewProdList;

    @FindBy(xpath = "//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']")
    public List<WebElement> overLayCartList;

    public static final String prodName_xPath="//div[contains(@class,'productinfo text-center')]//p";
    @FindBy(xpath = prodName_xPath)
    public List<WebElement> prodNameList;

    public static final String continueBtn_xPath ="//button[.='Continue Shopping']";
    @FindBy(xpath = continueBtn_xPath)
    public WebElement continueBtn;

    public static final String viewCartBtn_xPath = "//a[.='View Cart']";
    @FindBy(xpath = viewCartBtn_xPath)
    public WebElement viewCart;

    public static final String searchField_id="search_product";
    @FindBy(id = searchField_id)
    public WebElement searchField;

    public static final String searchBtn_id="submit_search";
    @FindBy(id = searchBtn_id)
    public WebElement searchBtn;

    public static final String brand_xPath="//div[@class='brands_products']//h2";
    @FindBy(xpath = brand_xPath)
    public WebElement brand;

    public static final String brandList_xPath ="//ul[@class='nav nav-pills nav-stacked']//li";
    @FindBy(xpath = brandList_xPath)
    public List<WebElement> brandList;

    @FindBy(xpath = "//div[@class='productinfo text-center']//h2")
    public List<WebElement> prodPriceList;

}
