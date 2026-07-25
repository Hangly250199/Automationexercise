package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPageObject extends AbstractComponents {
    WebDriver driver;
    public PaymentPageObject(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public static final String expectedMsg="Congratulations! Your order has been confirmed!";
    public static final String cardName_xPath="//input[@data-qa='name-on-card']";
    @FindBy(xpath = cardName_xPath)
    public WebElement cardName;

    public static final String cardNo_xPath="//input[@data-qa='card-number']";
    @FindBy(xpath = cardNo_xPath)
    public WebElement cardNoField;

    public static final String cvcNo_xPath="//input[@data-qa='cvc']";
    @FindBy(xpath = cvcNo_xPath)
    public WebElement cvcField;

    public static final String expiredMonth_xPath ="//input[@data-qa='expiry-month']";
    @FindBy(xpath = expiredMonth_xPath)
    public WebElement expiredMonth;

    public static final String expiredYear_xPath="//input[@data-qa='expiry-year']";
    @FindBy(xpath = expiredYear_xPath)
    public WebElement expiredYear;

    public static final String payBtn_xPath="//button[@data-qa='pay-button']";
    @FindBy(xpath = payBtn_xPath)
    public WebElement payBtn;

    public static final String confirmMsg_xPath ="//h2[@data-qa='order-placed']/following-sibling::p";
    @FindBy(xpath = confirmMsg_xPath)
    public WebElement confirmMsg;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public static WebElement downloadInvoiceBtn;
}
