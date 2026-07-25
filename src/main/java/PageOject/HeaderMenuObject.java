package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenuObject extends AbstractComponents {
    public HeaderMenuObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static final String signUp_LoginBtn_xPath = "//a[@href='/login']";
    @FindBy(xpath = signUp_LoginBtn_xPath)
    public WebElement signInLogInBtn;

    public static final String userName_xPath = "//a[contains(.,'Logged in as')]//b";
    @FindBy(xpath = userName_xPath)
    public WebElement userName;

    public static final String deleteBtn_xPath = "//a[@href='/delete_account']";
    @FindBy(xpath = deleteBtn_xPath)
    public WebElement deleteBtn;

    public static final String loggedInAs_xPath = "//a[contains(.,'Logged in as')]";
    @FindBy(xpath = loggedInAs_xPath)
    public WebElement loggedInAs;

    public static final String logOutBtn_xPath = "//a[@href='/logout']";
    @FindBy(xpath = logOutBtn_xPath)
    public WebElement logOutBtn;

    public static final String contactUs_xPath= "//a[@href='/contact_us']";
    @FindBy(xpath = contactUs_xPath)
    public WebElement contactUs;

    public static final String testCase_xPath="//ul//li//a[@href='/test_cases']";
    @FindBy(xpath = testCase_xPath)
    public WebElement testCase;

    public static final String product_xPath="//a[@href='/products']";
    @FindBy(xpath = product_xPath)
    public WebElement product;

    public static final String cart_xPath="//li//a[@href='/view_cart']";
    @FindBy(xpath = cart_xPath)
    public WebElement cart;
}
