package Page;

import PageOject.HeaderMenuObject;
import TestComponents.UserRegisterInfor;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderMenu extends HeaderMenuObject {
    WebDriver driver;
    public HeaderMenu(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @Step("Click on 'Signup / Login' button")
    public LoginPage goToLoginPage(){
        signInLogInBtn.click();
        return new LoginPage(driver);
    }
    @Step("Verify that 'Logged in as username' is visible")
    public void verifyUserName(){
        waitForEleAppear(userName);
        String userNameOnHP=userName.getText().replace("Logged in as ","").trim();
        Assert.assertEquals(userNameOnHP, SignUpFormPage.userName);
    }
    @Step("Click 'Delete Account' button")
    public DeleteAccConfirmPage deleteAcc(){
        org.openqa.selenium.WebElement deleteBtnEle = deleteBtn;
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtnEle);
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "document.querySelectorAll('ins.adsbygoogle, #google_vignette, .google-vignette, iframe[id*=\"google_ads\"]').forEach(el => el.remove());" +
                            "document.body.style.overflow = 'auto';"
            );
        } catch (Exception e) {
        }
        return new DeleteAccConfirmPage(driver);
    }
    @Step("Verify that 'Logged in as username' is visible")
    public void verifyLoggedUser(UserRegisterInfor userRegisterInfor){
        waitForEleAppear(loggedInAs);
        String expected = "Logged in as "+ userRegisterInfor.getFullName();
        String onHeader=loggedInAs.getText();
        Assert.assertEquals(onHeader,expected);
    }
    @Step("Log out user")
    public void logOut(){
        waitForEleClickable(logOutBtn);
        logOutBtn.click();
        new LoginPage(driver);
    }
    @Step("Click on 'Contact Us' button")
    public ContactUsPage contactUs(){
        contactUs.click();
        return new ContactUsPage(driver);
    }
    @Step("Click on 'Test Cases' button")
    public TestCasePage goToTCPage(){
        testCase.click();
        return new TestCasePage(driver);
    }
    @Step("Click on 'Products' button")
    public ProductPage goToProductPage(){
        product.click();
        return new ProductPage(driver);
    }
    @Step("Click 'Cart' button")
    public CartPage goToCartPage(){
        cart.click();
        return new CartPage(driver);
    }
}
