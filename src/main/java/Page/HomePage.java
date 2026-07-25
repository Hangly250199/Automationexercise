package Page;

import PageOject.HomePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends HomePageObject {
    WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @Step("Click 'View Product' for any product on home page")
    public ProductDetailPage viewProd(int prodNo){
        viewProdList.get(prodNo).click();
        return new ProductDetailPage(driver);
    }
    @Step("Add products to cart")
    public void addCart(int prodNo){
        prodCartList.get(prodNo-1).click();
    }
    @Step("Click continue")
    public void clickContinue(){
        waitForEleClickable(continueBtn);
        continueBtn.click();
    }
    public String prodName(int prodNo){
        return getProdName(prodNo);
    }
    @Step("Click on 'Women' category")
    public void clickWomenCategory(){
        womenCategory.click();
    }
    public void selectCategory(int categoryNo){
        scrollToEle(categoryList.get(categoryNo));
        categoryList.get(categoryNo).click();
    }
    @Step("Click on any category link under 'Women' category, for example: Dress")
    public void clickDressSubCategory(){
        waitForEleAppear(womenSubCategory.get(0));
        dressSubCategory.click();
    }
    public void clickSubCate(int categoryNo, int subCateNo){
        waitForEleAppear(subCategoryList.get(0));
        String categoryName = categoryList.get(categoryNo).getText().toUpperCase();
        if (categoryName.contains("WOMEN")) {
            womenSubCategory.get(subCateNo).click();
        } else if (categoryName.contains("KIDS")) {
            kidsSubCategory.get(subCateNo).click();
        } else {
            menSubCategory.get(subCateNo).click();
        }
    }
    @Step("Verify that category page is displayed and confirm text 'WOMEN - Dress PRODUCTS'")
    public void verifyCategoryTitlePage(){
        Assert.assertEquals(categoryTitle.getText(), expectedCateTitle);
    }
    public void verifyCategoryPage(int categoryNo, int subCateNo){
        Assert.assertEquals(textTitle().getText(), getExpectedCatePageName(categoryNo, subCateNo));
    }
    @Step("On left side bar, click on any sub-category link of 'Men' category")
    public void clickManSubCategory(){
        menCategory.click();
        waitForEleAppear(menCategory);
        menSubCategory.get(0).click();
    }
    @Step("Scroll to bottom of page/ Verify 'RECOMMENDED ITEMS' are visible")
    public void verifyRcmPage(){
        scrollEndPage();
        Assert.assertEquals(recommendTitle.getText().toLowerCase(), expectedRecommendTitle);
    }
    @Step("Click on 'Add To Cart' on Recommended product")
    public void addRecommendProdToCart(int prodNo){
        recommendAddToCartList.get(prodNo).click();
    }
    @Step("Click on 'View Cart' button")
    public CartPage clickViewCart(){
        waitForEleClickable(viewCart);
        viewCart.click();
        return new CartPage(driver);
    }
    public String getRecommendProdName(int prodNo){
        return recommendProdNameList.get(prodNo).getText();
    }
    @Step("Click on arrow at bottom right side to move upward")
    public void clickArrowUp(){
        arrowUpBtn.click();
    }
    @Step("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen")
    public void verifyScrollUpSuccess() throws InterruptedException {
        waitForEleAppear(textTitle);
        Assert.assertEquals(textTitle.getText().toLowerCase(), expectedText.toLowerCase());
    }
}
