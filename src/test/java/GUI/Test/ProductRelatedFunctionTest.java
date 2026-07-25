package GUI.Test;

import GUI.Steps.LogInSignInStep;
import Page.*;
import TestComponents.UserRegisterInfor;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class ProductRelatedFunctionTest extends LogInSignInStep {
    HeaderMenu headerMenu;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    HomePage homePage;
    LoginPage loginPage;
    CheckOutPage checkOutPage;
    UserRegisterInfor userRegisterInfor;

    @Test(groups = {"TC08"})
    public void VerifyProductPage() {
        int prodNo = 0;
        verifyWebsiteStep();
        headerMenu = new HeaderMenu(driver);
        productPage = headerMenu.goToProductPage();
        productPage.verifyProductPage();
        productPage.verifyProductsList();
        String prodName = productPage.getProdName(prodNo);
        String prodPrice = productPage.getProdPrice(prodNo);
        productDetailPage = productPage.clickViewProd(prodNo);
        productDetailPage.verifyDetailPage(prodNo + 1);
        productDetailPage.verifyProductDetail(prodName, prodPrice);
    }

    @Test(groups = {"TC09"})
    public void searchProd() {
        verifyWebsiteStep();
        headerMenu = new HeaderMenu(driver);
        productPage = headerMenu.goToProductPage();
        productPage.verifyProductPage();
        productPage.verifyProductsList();
        String prodSearchName = productPage.getProdName(0);
        productPage.enterNameToSearch(prodSearchName);
        productPage.verifySearchProd(prodSearchName);
    }

    @Test(groups = "TC18_01")
    @Description("View Category Products")
    public void viewCategoryProd01() {
        verifyWebsiteStep();
        int categoryWomenNum=0;
        int categoryMenNum=0;
        int subCateNum=0;
        homePage=new HomePage(driver);
        homePage.selectCategory(0);
        homePage.clickSubCate(0, 2);
//        homePage.verifyCategoryPage(0,0);
        homePage.selectCategory(1);
        homePage.clickSubCate(1, 0);
    }
    @Test(groups = {"TC18", "regression"})
    @Description("View Category Products")
    public void viewCategoryProd() {
        verifyWebsiteStep();
        homePage=new HomePage(driver);
        homePage.clickWomenCategory();
        homePage.clickDressSubCategory();
        homePage.verifyCategoryTitlePage();
        homePage.clickManSubCategory();
//        homePage.clickSubCate(1, 0);
    }
    @Test(groups = {"TC22"})
    @Description("Add to cart from Recommended items")
    public void addRecommendProd() {
        int prodNum = 1;
        homePage = new HomePage(driver);
        homePage.verifyRcmPage();
        String prodName = homePage.getRecommendProdName(prodNum).toLowerCase();
        homePage.addRecommendProdToCart(prodNum);
        cartPage = homePage.clickViewCart();
        cartPage.verifyProdCartPage(prodName);
    }
}
