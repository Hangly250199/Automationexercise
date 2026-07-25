package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DelConfirmPageObject extends AbstractComponents {
    public DelConfirmPageObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public static String expectedMsg = "ACCOUNT DELETED!";
    public static final String msgXpath = "//h2[@data-qa='account-deleted']//b";
    @FindBy(xpath = msgXpath)
    public WebElement msgEle;
    public static final String countinueBtn_xPath="//a[@class='btn btn-primary']";
    @FindBy(xpath = countinueBtn_xPath)
    public WebElement countinueBtn;
}
