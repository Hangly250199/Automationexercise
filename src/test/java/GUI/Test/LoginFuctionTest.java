package GUI.Test;

import API.CreateAcc;
import GUI.Steps.LogInSignInStep;
import Page.*;
import TestComponents.DataGen;
import TestComponents.DefaultValue;
import TestComponents.UserRegisterInfor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFuctionTest extends LogInSignInStep {
    LaunchingPage launchingPage;
    HeaderMenu headerMenu;
    LoginPage loginPage;
    SignUpFormPage signUpFormPage;
    ContactUsPage contactUsPage;
    TestCasePage testCasePage;
    UserRegisterInfor userRegisterInfor;
    HomePage homePage;

    @Test(groups = {"TC01"})
    public void registerUser() {
        userRegisterInfor = new UserRegisterInfor();
        registerUser(DataGen.genEmail(), userRegisterInfor);
        headerMenu = new HeaderMenu(driver);
        headerMenu.verifyUserName();
        deleteAccStep();
    }

    @Test(groups = {"TC02"})
    public void loginSuccess() {
        userRegisterInfor = new UserRegisterInfor();
        String userMail = CreateAcc.createNewAccount(userRegisterInfor);
        login(userMail, DefaultValue.defaultPassword);
        headerMenu = new HeaderMenu(driver);
        headerMenu.verifyLoggedUser(userRegisterInfor);
        deleteAccStep();
    }

    @DataProvider
    public Object[][] getData() {
        userRegisterInfor = new UserRegisterInfor();
        String registerMail = CreateAcc.createNewAccount(userRegisterInfor);
        return new Object[][]{
                {"nbv@g.com", DefaultValue.defaultPassword},
                {registerMail, "36363"}
        };
    }

    @Test(dataProvider = "getData", groups = "TC03")
    public void loginFail(String usermail, String password) {
        login(usermail, password);
        loginPage = new LoginPage(driver);
        loginPage.verifyLoginFailMsg();
    }

    @Test(groups = {"TC04"})
    public void logOut() {
        userRegisterInfor = new UserRegisterInfor();
        String userMail = CreateAcc.createNewAccount(userRegisterInfor);
        login(userMail, DefaultValue.defaultPassword);
        headerMenu = new HeaderMenu(driver);
        headerMenu.logOut();
    }

    @Test(groups = {"TC05"})
    public void signInWithExistMail() {
        userRegisterInfor = new UserRegisterInfor();
        String userMail = CreateAcc.createNewAccount(userRegisterInfor);
        loginPage = fillSignUpFormStep(userMail);
        signUpFormPage = loginPage.signUp();
        loginPage.verifySigUpErrMsg();
    }

    @Test(groups = {"TC06"})
    public void contactUs() {
        verifyWebsiteStep();
        headerMenu = new HeaderMenu(driver);
        contactUsPage = headerMenu.contactUs();
        contactUsPage.verifyGetInTouch();
        contactUsPage.fillContactInfor();
        contactUsPage.submitForm();
        contactUsPage.acceptPopupAlert();
        contactUsPage.verifySuccessMsg();
        launchingPage = contactUsPage.clickHomeBtn();
        launchingPage.verifyWebsite();
    }

}
