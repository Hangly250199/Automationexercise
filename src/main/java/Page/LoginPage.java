package Page;

import PageOject.LoginPageObject;
import TestComponents.DefaultValue;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends LoginPageObject {
    WebDriver driver;
    String registedMail;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @Step("Verify 'New User Signup!' is visible")
    public void verifySignUpVisible(){
//        Boolean matchSignUp = signUpTitle.getText().equals(LoginPageObject.expectedSignUpTitle);
//        Assert.assertTrue(matchSignUp);
        Assert.assertEquals(signUpTitle.getText(), expectedSignUpTitle);
    }
    @Step("Enter name and email address to Sign Up")
    public void fillSignUpForm(String registeredMail){
        signUpName.sendKeys(DefaultValue.defaultName);
        signUpMail.sendKeys(registeredMail);
    }
    @Step("Get email that register")
    public String getRegistedMail(){
        return this.registedMail;
    }
    @Step("Click 'Signup' button")
    public SignUpFormPage signUp(){
        waitForEleAppear(signUpBtn);
        signUpBtn.click();
        return new SignUpFormPage(driver);
    }
    @Step("Verify 'Login to your account' is visible")
    public void verifyLogInVisible(){
//        boolean matchLogIn = findByxPath(LoginPageObject.logInTitle_xpath).getText().equals(LoginPageObject.expectedLogInTitle);
//        Assert.assertTrue(matchLogIn);
        Assert.assertEquals(logInTitle.getText(), expectedLogInTitle);
    }
    @Step("Enter correct email address and password")
    public void fillLogInInfor(String userMail, String password){
        logInMail.sendKeys(userMail);
        logInPass.sendKeys(password);
    }
    @Step("Click 'login' button")
    public void selectLogInBtn(){
        logInBtn.click();
        new HomePage(driver);
    }
    @Step("Verify error 'Your email or password is incorrect!' is visible")
    public void verifyLoginFailMsg(){
        Assert.assertEquals(errorMsg.getText(), LoginPageObject.expectedLogInFailMsg);
    }
    @Step("Verify error 'Email Address already exist!' is visible")
    public void verifySigUpErrMsg(){
        Assert.assertEquals(errorMsg.getText(), expectedSignUpErrMsg);
    }
}
