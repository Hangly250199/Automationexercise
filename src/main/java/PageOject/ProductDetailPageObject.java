package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPageObject extends AbstractComponents {

    public ProductDetailPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static final String expectedTitle = "Write Your Review";
    public static final String expectedAlertReviewMsg = "Thank you for your review.";

    public static final String prodName_xPath = "//div[@class='product-information']//h2";
    @FindBy(xpath = prodName_xPath)
    public WebElement prodName;

    public static final String prodCategory_xPath = "//p[contains(.,'Category')]";
    @FindBy(xpath = prodCategory_xPath)
    public WebElement prodCategory;

    public static final String prodPrice_xPath = "//div[@class='product-information']//span//span";
    @FindBy(xpath = prodPrice_xPath)
    public WebElement prodPrice;

    public static final String prodAvaible_xPath = "//b[contains(.,'Availability:')]";
    @FindBy(xpath = prodAvaible_xPath)
    public WebElement prodAvailable;

    public static final String prodCondition_xPath = "//b[contains(.,'Condition:')]";
    @FindBy(xpath = prodCondition_xPath)
    public WebElement prodCondition;

    public static final String prodBrand_xPath = "//b[contains(.,'Brand:')]";
    @FindBy(xpath = prodBrand_xPath)
    public WebElement prodBrand;

    public static final String quantityID = "quantity";
    @FindBy(id = quantityID)
    public WebElement quantity;

    public static final String addCart_xPath = "//button[@class='btn btn-default cart']";
    @FindBy(xpath = addCart_xPath)
    public WebElement addCart;

    public static final String viewCart_xPath = "//p[@class='text-center']//a";
    @FindBy(xpath = viewCart_xPath)
    public WebElement viewCart;

    public static final String review_xPath = "//ul[@class='nav nav-tabs']//li//a";
    @FindBy(xpath = review_xPath)
    public WebElement review;

    public static final String nameID = "name";
    @FindBy(id = nameID)
    public WebElement nameField;

    public static final String mailID = "email";
    @FindBy(id = mailID)
    public WebElement mailField;

    public static final String reviewID = "review";
    @FindBy(id = reviewID)
    public WebElement reviewField;

    public static final String submitBtnID = "button-review";
    @FindBy(id = submitBtnID)
    public WebElement submitBtn;

    public static final String alertReviewMsg_xPath = "//div[@class='alert-success alert']";
    @FindBy(xpath = alertReviewMsg_xPath)
    public WebElement alertReviewMsg;

}
