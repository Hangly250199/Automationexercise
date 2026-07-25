package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPageObject extends AbstractComponents {
    public ContactUsPageObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public static final String expectedTitle = "GET IN TOUCH";
    public static final String expectedMsg = "Success! Your details have been submitted successfully.";
    public static final String contactTitle_xPath = "//div[@class='contact-form']//h2";
    public static final String name_xPath = "//input[@data-qa='name']";
    public static final String email_xPath = "//input[@data-qa='email']";
    public static final String subject_xPath = "//input[@data-qa='subject']";
    public static final String submitBtn_xPath = "//input[@name='submit']";
    public static final String confirmMsg_xPath = "//div[@class='status alert alert-success']";
    public static final String homeBtn_xPath = "//a[@class='btn btn-success']";
    public static final String msgId = "message";
    @FindBy(xpath = contactTitle_xPath)
    public WebElement contactTitle;
    @FindBy(xpath = name_xPath)
    public WebElement nameField;
    @FindBy(xpath = email_xPath)
    public WebElement mailField;
    @FindBy(xpath = subject_xPath)
    public WebElement subjectField;
    @FindBy(xpath = submitBtn_xPath)
    public WebElement submitBtn;
    @FindBy(xpath = confirmMsg_xPath)
    public WebElement confirmMsg;
    @FindBy(xpath = homeBtn_xPath)
    public WebElement homeBtn;
    @FindBy(id = msgId)
    public WebElement msgField;
}
