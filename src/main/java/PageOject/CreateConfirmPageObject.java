package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateConfirmPageObject extends AbstractComponents {
    public CreateConfirmPageObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public static final String expectedMsg = "ACCOUNT CREATED!";
    public static final String msgXPath ="//h2[@data-qa='account-created']";
    @FindBy(xpath = msgXPath)
    public WebElement msgEle;
    public static final String continueBtnXPath ="//a[@data-qa='continue-button']";
    @FindBy(xpath = continueBtnXPath)
    public WebElement countinueBtn;
}
