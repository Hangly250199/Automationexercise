package Page;

import TestComponents.AbstractComponents;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasePage extends AbstractComponents {
    WebDriver driver;
    public TestCasePage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @Step("Verify user is navigated to test cases page successfully")
    public void verifyPageTitle(){
        Assert.assertEquals(findByxPath("//b").getText(), "TEST CASES");
    }
}
