package Page;

import PageOject.PaymentPageObject;
import TestComponents.DefaultValue;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PaymentPage extends PaymentPageObject {
    WebDriver driver;
    public PaymentPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @Step("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void fillPaymentInfor(){
        cardName.sendKeys(DefaultValue.defaultName);
        cardNoField.sendKeys("1234567890");
        cvcField.sendKeys("251");
        expiredMonth.sendKeys("01");
        expiredYear.sendKeys("2030");
    }
    @Step("Click 'Pay and Confirm Order' button")
    public void clickPayBtn(){
        payBtn.click();
    }
    @Step("Verify success message 'Your order has been placed successfully!'")
    public void verifyAlertMsg(){
        waitForEleAppear(confirmMsg);
        Assert.assertEquals(confirmMsg.getText(), expectedMsg);
    }
    @Step("Click 'Download Invoice' button and verify invoice is downloaded successfully.")
    public void downloadInvoice(){
        waitForEleClickable(downloadInvoiceBtn);
        downloadInvoiceBtn.click();
    }
}
