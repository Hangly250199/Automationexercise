package Page;

import PageOject.ProductDetailPageObject;
import TestComponents.APIPath;
import TestComponents.DataGen;
import TestComponents.DefaultValue;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductDetailPage extends ProductDetailPageObject {
    WebDriver driver;
    ProductPage productPage;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("User is landed to product detail page")
    public void verifyDetailPage(int prodNo) {
        String endpoint = APIPath.prodDetail.replace("%s", String.valueOf(prodNo));
        String detailProdUrl = APIPath.BASE_URL + endpoint;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(detailProdUrl));
        Assert.assertEquals(detailProdUrl, driver.getCurrentUrl());
    }
    public void verifyEleDisplay(WebElement webElement) {
        Assert.assertTrue(webElement.isDisplayed());
    }
    @Step("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verifyProductDetail(String expectProdName, String expectProdPrice) {
        productPage = new ProductPage(driver);
        Assert.assertEquals(prodName.getText(), expectProdName);
        Assert.assertEquals(prodPrice.getText(), expectProdPrice);
        verifyEleDisplay(prodCategory);
        verifyEleDisplay(prodAvailable);
        verifyEleDisplay(prodCondition);
        verifyEleDisplay(prodBrand);
    }

    @Step("Increase quantity to 4")
    public void enterQuantity(int quantityValue) {
//        WebElement quantity = findByID(quantityID);
        quantity.clear();
        quantity.sendKeys(String.valueOf(quantityValue));
    }

    @Step("Click 'Add to cart' button")
    public void addToCart() {
        addCart.click();
    }

    @Step("Click 'View Cart' button")
    public CartPage clickViewCart() {
        waitForEleAppear(viewCart);
        viewCart.click();
        return new CartPage(driver);
    }

    @Step(" Verify 'Write Your Review' is visible")
    public void verifyReviewVisible() {
        Assert.assertEquals(review.getText().toLowerCase(), expectedTitle.toLowerCase());
    }

    @Step("Enter name, email and review")
    public void fillReviewInfor(){
        nameField.sendKeys(DefaultValue.defaultName);
        mailField.sendKeys(DataGen.genEmail());
        reviewField.sendKeys("Review Test");

    }
    @Step("Click 'Submit' button")
    public void clickSubmitBtn(){
        submitBtn.click();
    }
    @Step("Verify success message 'Thank you for your review.'")
    public void verifyMsg(){
       waitForEleAppear(alertReviewMsg);
       Assert.assertEquals(alertReviewMsg.getText().toLowerCase(), expectedAlertReviewMsg.toLowerCase());
    }
}
