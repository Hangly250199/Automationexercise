package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractComponents {
    public LoginPageObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public static final String expectedSignUpTitle = "New User Signup!";
    public static final String expectedLogInTitle = "Login to your account";
    public static final String expectedLogInFailMsg = "Your email or password is incorrect!";
    public static final String expectedSignUpErrMsg = "Email Address already exist!";

    public static final String signUpTitle_xpath = "//div[@class='signup-form']//h2";
    @FindBy(xpath = signUpTitle_xpath)
    public WebElement signUpTitle;

    public static final String signUpMail_xPath= "//input[@data-qa='signup-email']";
    @FindBy(xpath = signUpMail_xPath)
    public WebElement signUpMail;

    public static final String signUpName_xPath= "//input[@data-qa='signup-name']";
    @FindBy(xpath = signUpName_xPath)
    public WebElement signUpName;

    public static final String signUpBtn_xPath= "//button[@data-qa='signup-button']";
    @FindBy(xpath = signUpBtn_xPath)
    public WebElement signUpBtn;

    public static final String logInTitle_xpath = "//div[@class='login-form']//h2";
    @FindBy(xpath = logInTitle_xpath)
    public WebElement logInTitle;

    public static final String logInMail_xPath= "//input[@data-qa='login-email']";
    @FindBy(xpath = logInMail_xPath)
    public WebElement logInMail;

    public static final String logInPass_xPath= "//input[@data-qa='login-password']";
    @FindBy(xpath = logInPass_xPath)
    public WebElement logInPass;

    public static final String logInBtn_xPath= "//button[@data-qa='login-button']";
    @FindBy(xpath = logInBtn_xPath)
    public WebElement logInBtn;

    public static final String errorMsg_xPath = "//p[@style='color: red;']";
    @FindBy(xpath = errorMsg_xPath)
    public WebElement errorMsg;
}
