package Page;

import PageOject.ContactUsPageObject;
import TestComponents.DataGen;
import TestComponents.DefaultValue;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsPage extends ContactUsPageObject {
    WebDriver driver;
    HomePage homePage;
    public ContactUsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @Step("Verify 'GET IN TOUCH' is visible")
    public void verifyGetInTouch(){
        Assert.assertEquals(contactTitle.getText(), ContactUsPageObject.expectedTitle);
    }
    @Step("Enter name, email, subject and message")
    public void fillContactInfor(){
        nameField.sendKeys(DefaultValue.defaultName);
        mailField.sendKeys(DataGen.genEmail());
        subjectField.sendKeys("Default Subject");
        msgField.sendKeys( "Default Message");
    }
    @Step("Upoad file")// chưa làm được phần này
    public void upLoadFile(){

    }
    @Step("Click 'Submit' button")
    public void submitForm(){
        submitBtn.click();
    }
    @Step("Click OK button")
    public void acceptPopupAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    @Step("Verify success message 'Success! Your details have been submitted successfully.' is visible")
    public void verifySuccessMsg(){
        Assert.assertEquals(confirmMsg.getText(), expectedMsg);
    }
    @Step("Click 'Home' button and verify that landed on home page successfully")
    public LaunchingPage clickHomeBtn(){
        homeBtn.click();
        return new LaunchingPage(driver);
    }
}
