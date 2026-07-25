package Page;

import PageOject.CartPageObject;
import TestComponents.APIPath;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends CartPageObject {
    WebDriver driver;
    ProductPage productPage;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @Step("Verify both products are added to Cart")
    public void verifyProdCart(String prodName){
        productPage = new ProductPage(driver);
//        List<WebElement> prodCartList = findByxPaths(CartPageObject.prodName_xPath);
        Assert.assertTrue(prodCartList.stream()
                .anyMatch(p->p.getText().equalsIgnoreCase(prodName)));
    }
    public List<String> getProdName(){
        List<WebElement> prodCartList = findByxPaths(CartPageObject.prodName_xPath);
        List<String> prodName = new ArrayList<>();
        for (WebElement ele:prodCartList){
            prodName.add(ele.getText());
        }
        return prodName;
    }
    @Step("Verify that product is displayed in cart page with exact quantity")
    public void verifyProdQuantity(int prodQuantity){
        Assert.assertEquals(prodQuantity, Integer.parseInt(findByxPath(CartPageObject.quantity_xPath).getText()));
    }
    @Step("Verify that cart page is displayed")
    public void verifyCartPage(){
        waitForEleAppear(pageTitle);
        String endpoint = APIPath.cartUrl;
        String detailProdUrl = APIPath.BASE_URL + endpoint;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(detailProdUrl));
        Assert.assertEquals(detailProdUrl, driver.getCurrentUrl());
        Assert.assertEquals(pageTitle.getText(), CartPageObject.expectedTitle);
    }
    @Step("Click Proceed To Checkout")
    public void clickProcessCheckOutToRegis(){
        checkOutBtn.click();
    }
    public CheckOutPage clickProcessCheckOut(){
        checkOutBtn.click();
        return new CheckOutPage(driver);
    }
    @Step("Click 'Register / Login' button")
    public LoginPage clickResLoginBtn(){
        loginBtn.click();
        return new LoginPage(driver);
    }
    @Step("Click 'X' button corresponding to particular product")
    public void clickToRemoveProd(){
        removeBtn.click();
    }
    @Step("Verify that product is removed from the cart")
    public void verifyRemove(String prodName){
        waitForEleDisappear(removeBtn);
        Assert.assertFalse(prodCartList.stream()
                .anyMatch(p->p.getText().equalsIgnoreCase(prodName)));
    }
    @Step("Click 'Cart' button and verify that products are visible in cart")
    public void verifyProdVisible(String prodSearchName, int prodQuantity){
        Assert.assertEquals(prodCartList.size(), prodQuantity);
        Assert.assertTrue(prodCartList.stream()
                .allMatch(p
                        ->p.getText().toLowerCase()
                        .contains(prodSearchName.toLowerCase())));
    }
    @Step("Verify that product is displayed in cart page")
    public void verifyProdCartPage(String expectedProdName){
        Assert.assertEquals(prodCartList.get(0).getText().toLowerCase(), expectedProdName);
    }
    @Step("Verify products add to cart is presented in cart Page")
    public void verifyAddProd(List<String> expectedProList){
        productPage=new ProductPage(driver);
        Assert.assertEquals(getProdName(), expectedProList);
    }
}
