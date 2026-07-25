package Page;

import PageOject.DelConfirmPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteAccConfirmPage extends DelConfirmPageObject {
    WebDriver driver;
    public DeleteAccConfirmPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    public void verifyMsg(){
        waitForEleAppear(msgEle);
        Assert.assertEquals(msgEle.getText(),DelConfirmPageObject.expectedMsg);
    }
    public void clickCountinue(){
        countinueBtn.click();
    }

}
