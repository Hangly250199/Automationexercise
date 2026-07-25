package Page;

import TestComponents.AbstractComponents;
import TestComponents.DefaultValue;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LaunchingPage extends AbstractComponents {
    WebDriver driver;
    public LaunchingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @Step("Verify that home page is visible successfully")
    public void verifyWebsite() {
        waitForTitleToBe(DefaultValue.webTitle);
        Assert.assertEquals(driver.getTitle(), DefaultValue.webTitle);
    }
}
