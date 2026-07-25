package Page;

import PageOject.CreateConfirmPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateAccConfirmPage extends CreateConfirmPageObject {
    WebDriver driver;
    public CreateAccConfirmPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    @Step("Verify that 'ACCOUNT CREATED!' is visible")
    public void verifyConfirmMsg(){
        Assert.assertEquals(msgEle.getText(), CreateConfirmPageObject.expectedMsg);
    }
    @Step("Click 'Continue' button")
    public HomePage seclectContinue(){
        org.openqa.selenium.WebElement continueBtn = countinueBtn;
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "document.querySelectorAll('ins.adsbygoogle, #google_vignette, .google-vignette, iframe[id*=\"google_ads\"]').forEach(el => el.remove());" +
                            "document.body.style.overflow = 'auto';"
            );
        } catch (Exception e) {
        }
        return new HomePage(driver);
    }
}
