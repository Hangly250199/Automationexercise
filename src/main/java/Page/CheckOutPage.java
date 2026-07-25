package Page;

import PageOject.CheckOutObject;
import TestComponents.UserRegisterInfor;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOutPage extends CheckOutObject {
    WebDriver driver;
    UserRegisterInfor userRegisterInfor;
    public CheckOutPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @Step("Verify Address Details and Review Your Order")
    public void verifyDeliveryInfo(UserRegisterInfor userRegisterInfor){
        Assert.assertEquals(deliveryName.getText(), userRegisterInfor.getFullNameTitle());
        Assert.assertEquals(address.get(0).getText(), userRegisterInfor.getCompany());
        Assert.assertEquals(address.get(1).getText(), userRegisterInfor.getAddress1());
        Assert.assertEquals(address.get(2).getText(), userRegisterInfor.getAddress2());
        Assert.assertEquals(deliveryCityStateZip.getText(), userRegisterInfor.getCityStateZip());
        Assert.assertEquals(deliveryCountry.getText(), userRegisterInfor.getCountry());
        Assert.assertEquals(deliveryPhone.getText(), userRegisterInfor.getMobileNumber());
    }
    public void reviewOrder(String prodName){
        Assert.assertEquals(prodName, prodNameEle.getText());
    }
    @Step("Enter description in comment text area and click 'Place Order'")
    public PaymentPage placeOrder(){
        textField.sendKeys("Noted");
        placeOderBtn.click();
        return new PaymentPage(driver);
    }
    @Step("Verify that the billing address is same address filled at the time registration of account")
    public void verifyBillingAddress(UserRegisterInfor userRegisterInfor){
        Assert.assertEquals(billingName.getText(), userRegisterInfor.getFullNameTitle());
        Assert.assertEquals(billingAddress.get(0).getText(), userRegisterInfor.getCompany());
        Assert.assertEquals(billingAddress.get(1).getText(), userRegisterInfor.getAddress1());
        Assert.assertEquals(billingAddress.get(2).getText(), userRegisterInfor.getAddress2());
        Assert.assertEquals(billingCityStateZip.getText(), userRegisterInfor.getCityStateZip());
        Assert.assertEquals(billingCountry.getText(), userRegisterInfor.getCountry());
        Assert.assertEquals(billingPhone.getText(), userRegisterInfor.getMobileNumber());
    }
}
