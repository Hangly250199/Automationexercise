package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterObject extends AbstractComponents {
    public FooterObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public static final String expectedTitle="SUBSCRIPTION";
    public static final String expectedMsg="You have been successfully subscribed!";

    public static final String subscription_xPath ="//div[@class='single-widget']//h2";
    @FindBy(xpath = subscription_xPath)
    public WebElement subscription;

    public static final String successMsg_xPath="//div[@class='alert-success alert']";
    @FindBy(xpath = successMsg_xPath)
    public WebElement successMsg;

    public static final String subEmail_id="susbscribe_email";
    @FindBy(id = subEmail_id)
    public WebElement subEmail;

    public static final String subBtn_id="subscribe";
    @FindBy(id = subBtn_id)
    public WebElement submitBtn;
}
