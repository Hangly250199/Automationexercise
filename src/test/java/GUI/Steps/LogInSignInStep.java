package GUI.Steps;

import Page.*;
import TestComponents.BaseTest;
import TestComponents.DataGen;
import TestComponents.UserRegisterInfor;

public class LogInSignInStep extends BaseTest {
    LaunchingPage launchingPage;
    HeaderMenu headerMenu;
    LoginPage loginPage;
    SignUpFormPage signUpFormPage;
    CreateAccConfirmPage confirmPage;
    DeleteAccConfirmPage deleteAccConfirmPage;
    UserRegisterInfor userRegisterInfor;

    public void verifyWebsiteStep(){
        launchingPage = new LaunchingPage(driver);
        launchingPage.verifyWebsite();
    }
    public void login(String usermail, String password) {
        launchingPage = new LaunchingPage(driver);
        launchingPage.verifyWebsite();
        headerMenu = new HeaderMenu(driver);
        loginPage = headerMenu.goToLoginPage();
        loginPage.verifyLogInVisible();
        loginPage.fillLogInInfor(usermail, password);
        loginPage.selectLogInBtn();
        new LoginPage(driver);
    }
    public void fillSignUpForm(){
        headerMenu = new HeaderMenu(driver);
        loginPage=headerMenu.goToLoginPage();
        loginPage.fillSignUpForm(DataGen.genEmail());
    }
    public LoginPage fillSignUpFormStep(String registedMail) {
        launchingPage = new LaunchingPage(driver);
        launchingPage.verifyWebsite();
        headerMenu = new HeaderMenu(driver);
        loginPage = headerMenu.goToLoginPage();
        loginPage.verifySignUpVisible();
        loginPage.fillSignUpForm(registedMail);
        return loginPage;
    }

    public void registerUser(String registerMail, UserRegisterInfor user){
        fillSignUpFormStep(registerMail);
        signUpFormPage = loginPage.signUp();
        signUpFormPage.verifyTitle();
        signUpFormPage.fillCusInformation(user);
        signUpFormPage.selectNewsletterCheckbox();
        signUpFormPage.selectOptionCheckbox();
        signUpFormPage.fillAddressInformation(user);
        confirmPage = signUpFormPage.createAccount();
        confirmPage.verifyConfirmMsg();
        confirmPage.seclectContinue();
    }
    public void registerUserInfor(UserRegisterInfor user){
        loginPage=new LoginPage(driver);
        signUpFormPage = loginPage.signUp();
        signUpFormPage.verifyTitle();
        signUpFormPage.fillCusInformation(user);
        signUpFormPage.selectNewsletterCheckbox();
        signUpFormPage.selectOptionCheckbox();
        signUpFormPage.fillAddressInformation(user);
        confirmPage = signUpFormPage.createAccount();
        confirmPage.verifyConfirmMsg();
        confirmPage.seclectContinue();
    }
    public void deleteAccStep(){
        headerMenu=new HeaderMenu(driver);
        deleteAccConfirmPage = headerMenu.deleteAcc();
        deleteAccConfirmPage.verifyMsg();
        deleteAccConfirmPage.clickCountinue();
    }
}
