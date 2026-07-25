package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutObject extends AbstractComponents {
    public CheckOutObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2']")
    public List<WebElement> address;
    public static final String name_xPath="//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']";
    public static final String cityStateZip_xPath ="//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']";
    public static final String country_xPath="//ul[@id='address_delivery']//li[@class='address_country_name']";
    public static final String phone_xPath="//ul[@id='address_delivery']//li[@class='address_phone']";
    public static final String prodName_xPath="//td[@class='cart_description']//h4//a";
    public static final String text_xPath="//textarea";
    public static final String placeOrderBtn_xPath="//a[@class='btn btn-default check_out']";

    @FindBy(xpath = name_xPath)
    public WebElement deliveryName;
    @FindBy(xpath = cityStateZip_xPath)
    public WebElement deliveryCityStateZip;
    @FindBy(xpath = country_xPath)
    public WebElement deliveryCountry;
    @FindBy(xpath = phone_xPath)
    public WebElement deliveryPhone;
    @FindBy(xpath = prodName_xPath)
    public WebElement prodNameEle;
    @FindBy(xpath = text_xPath)
    public WebElement textField;
    @FindBy(xpath = placeOrderBtn_xPath)
    public WebElement placeOderBtn;
    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_firstname address_lastname']")
    public WebElement billingName;
    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_address1 address_address2']")
    public List<WebElement> billingAddress;
    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_city address_state_name address_postcode']")
    public WebElement billingCityStateZip;
    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_country_name']")
    public WebElement billingCountry;
    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_phone']")
    public WebElement billingPhone;
}
