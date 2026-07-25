package Page;

import PageOject.FooterObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FooterPage extends FooterObject {
    WebDriver driver;
    public FooterPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @Step("Verify text 'SUBSCRIPTION'")
    public void verifySubscription(){
        Assert.assertEquals(subscription.getText(), expectedTitle);
    }
    @Step("Enter email address in input and click arrow button")
    public void fillInforAndSub(String email){
        subEmail.sendKeys(email);
        submitBtn.click();
    }
    @Step("Verify success message 'You have been successfully subscribed!' is visible")
    public void verifySubSuccess(){
        waitForEleAppear(successMsg);
        Assert.assertEquals(successMsg.getText(), FooterObject.expectedMsg);
    }

}
