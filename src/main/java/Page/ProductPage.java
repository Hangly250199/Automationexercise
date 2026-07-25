package Page;

import PageOject.ProductPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends ProductPageObject {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyProductPage() {
        Assert.assertEquals(pageTitle.getText(), ProductPageObject.expectedTitle);
    }

    @Step("The products list is visible")
    public void verifyProductsList() {
        Assert.assertFalse(prodList.isEmpty());
    }

    @Step("Get Detail of product")
    public String getProdName(int prodNo) {
        verifyProductsList();
        return prodList.get(prodNo).getText();
    }

    public String getProdPrice(int prodNo) {
        verifyProductsList();
        return prodPriceList.get(prodNo).getText();
    }

    @Step("Click on 'View Product' of first product")
    public ProductDetailPage clickViewProd(int prodNo) {
        viewProdList.get(prodNo).click();
        return new ProductDetailPage(driver);
    }

    @Step("Enter product name in search input and click search button")
    public void enterNameToSearch(String prodName) {
        searchField.sendKeys(prodName);
        searchBtn.click();
    }

    @Step("Verify all the products related to search are visible")
    public void verifySearchProd(String prodSearchName) {
        waitForEleAppear(prodNameList.get(0));
        if (prodSearchName == null || prodSearchName.trim().isEmpty()) {
            Assert.assertEquals(prodNameList.size(), prodList.size());
        } else {
            Assert.assertTrue(prodNameList.stream()
                    .allMatch(p -> p.getText().toLowerCase()
                            .contains(prodSearchName.toLowerCase())));
        }
    }

    @Step("Verify 'SEARCHED PRODUCTS' is visible")
    public void verifySearchProdTitle() {
        waitForTextToBe(pageTitle, searchProdTitle);
        Assert.assertEquals(pageTitle.getText(), searchProdTitle);
    }

    @Step("Hover over first product and click 'Add to cart'")
    public void hoverProd(int totalProd) {
        Actions act = new Actions(driver);
        verifyProductsList();
//        scrollToEle(brand);
        for (int i = 2; i < totalProd; i++) {
            act.moveToElement(prodList.get(i)).build().perform();
            WebElement findEle = overLayCartList.get(i);
            waitForEleClickable(findEle);
            findEle.click();
            if (i < totalProd - 1) {
                continueShopping();
            }
        }
    }

    public List<String> getProdNameAdd(int totalProd) {
        List<String> expectedNames = new ArrayList<>();
        for (int i = 2; i < totalProd; i++) {
            expectedNames.add(prodNameList.get(i).getText());
        }
        return expectedNames;
    }

    @Step("Click 'Continue Shopping' button")
    public void continueShopping() {
        waitForEleClickable(continueBtn);
        continueBtn.click();
    }

    @Step("Click 'View Cart' button")
    public CartPage goToCartPage() {
        waitForEleAppear(viewCart);
        viewCart.click();
        return new CartPage(driver);
    }

    @Step("Verify that Brands are visible on left side bar")
    public void verifyBrands() {
        brand.isDisplayed();
    }

    @Step("Click on any brand name")
    public void selectBrand(int brandNo) {
        scrollToEle(brandList.get(0));
        brandList.get(brandNo).click();
    }

    public String getBrandName(int brandNo) {
        return brandList.get(brandNo).getText();
    }

    @Step("Verify that user is navigated to brand page and brand products are displayed")
    public void verifyBrandPage(int brandNo) {
        String fullText = getBrandName(brandNo);
        String brandName = fullText.split("\\)")[1].trim();
        String expectedTitle = "BRAND - " + brandName + " PRODUCTS";
        Assert.assertEquals(pageTitle.getText(), expectedTitle);
    }

    @Step("Add those products to cart")
    public void addAllProdToCart() {
        for (int i = 0; i < addCartList.size(); i = i + 2) {
            waitForEleClickable(addCartList.get(i));
            addCartList.get(i).click();
            continueShopping();
        }
    }

    @Step("Get number of products")
    public int getProdQuantity() {
        return addCartList.size() / 2;
    }
}
