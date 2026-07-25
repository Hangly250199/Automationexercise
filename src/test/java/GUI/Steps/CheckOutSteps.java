package GUI.Steps;

import API.CreateAcc;
import Page.*;
import TestComponents.DataGen;
import TestComponents.DefaultValue;
import TestComponents.UserRegisterInfor;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckOutSteps extends LogInSignInStep {
    HeaderMenu headerMenu;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    HomePage homePage;
    LoginPage loginPage;
    CheckOutPage checkOutPage;
    UserRegisterInfor userRegisterInfor;
    PaymentPage paymentPage;

    @Test(groups = {"TC12", "Add Product"})
    public void addProduct() throws InterruptedException {
        verifyWebsiteStep();
        int totalProds = 2;
        List<String> expectedNames = new ArrayList<>();
        headerMenu = new HeaderMenu(driver);
        productPage = headerMenu.goToProductPage();
        Thread.sleep(5000);
        for (int i = 0; i < totalProds; i++) {
            expectedNames.add(productPage.getProdName(i));
            productPage.hoverProd(i);
            if (i < totalProds - 1) {
                productPage.continueShopping();
            }
        }
        cartPage = productPage.goToCartPage();
        Assert.assertEquals(cartPage.getProdName(), expectedNames);
    }

    @Test(groups = {"TC13", "Verify Product quantity in Cart"})
    public void verifyProdQuantity() {
        int prodNum = 2;
        int quantity = 4;
        verifyWebsiteStep();
        homePage = new HomePage(driver);
//        Thread.sleep(10000);
        productDetailPage = homePage.viewProd(prodNum);
        productDetailPage.verifyDetailPage(prodNum + 1);
        productDetailPage.enterQuantity(quantity);
        productDetailPage.addToCart();
        cartPage = productDetailPage.clickViewCart();
        cartPage.verifyProdQuantity(quantity);

    }

    @Test(groups = {"TC14", "Place Order: Register while Checkout"})
    public void placeOrderThenRegis() {
        verifyWebsiteStep();
        int prodNum = 13;
        userRegisterInfor = new UserRegisterInfor();
        homePage = new HomePage(driver);
        headerMenu = new HeaderMenu(driver);
        homePage.addCart(prodNum);
        String prodName = homePage.prodName(prodNum);
        homePage.clickContinue();
        cartPage = headerMenu.goToCartPage();
        cartPage.verifyCartPage();
        cartPage.clickProcessCheckOutToRegis();
        loginPage = cartPage.clickResLoginBtn();
        loginPage.fillSignUpForm(DataGen.genEmail());
        registerUserInfor(userRegisterInfor);
        headerMenu.verifyUserName();
        cartPage = headerMenu.goToCartPage();
        cartPage.clickProcessCheckOutToRegis();
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.verifyDeliveryInfo(userRegisterInfor);
        checkOutPage.reviewOrder(prodName);
    }

    @Step("Select Product on HP then Checkout")
    public void checkOutStep(int prodNum, UserRegisterInfor userRegisterInfor) {
        homePage = new HomePage(driver);
        headerMenu=new HeaderMenu(driver);
        homePage.addCart(prodNum);
        String prodName = homePage.prodName(prodNum);
        homePage.clickContinue();
        cartPage = headerMenu.goToCartPage();
        cartPage.verifyCartPage();
        checkOutPage = cartPage.clickProcessCheckOut();
        checkOutPage.verifyDeliveryInfo(userRegisterInfor);
        checkOutPage.verifyBillingAddress(userRegisterInfor);
        checkOutPage.reviewOrder(prodName);
        paymentPage = checkOutPage.placeOrder();
        paymentPage.fillPaymentInfor();
        paymentPage.clickPayBtn();
        paymentPage.verifyAlertMsg();
    }

    @Test(groups = {"TC16"})
    @Description("Place Order: Login before Checkout")
    public void loginThenCheckOut() {
        verifyWebsiteStep();
        int prodNum = 5;
        userRegisterInfor = new UserRegisterInfor();
        String userMail = CreateAcc.createNewAccount(userRegisterInfor);
        login(userMail, userRegisterInfor.getPassword());
        headerMenu = new HeaderMenu(driver);
        headerMenu.verifyLoggedUser(userRegisterInfor);
        homePage = new HomePage(driver);
        String prodName = homePage.prodName(prodNum);
        homePage.addCart(prodNum);
        homePage.clickContinue();
        cartPage = headerMenu.goToCartPage();
        cartPage.verifyCartPage();
        checkOutPage = cartPage.clickProcessCheckOut();
        checkOutPage.verifyDeliveryInfo(userRegisterInfor);
        checkOutPage.reviewOrder(prodName);
        paymentPage = checkOutPage.placeOrder();
        paymentPage.fillPaymentInfor();
        paymentPage.clickPayBtn();
        paymentPage.verifyAlertMsg();
        deleteAccStep();
    }

    @Test(groups = {"TC17"})
    @Description("Remove Products From Cart")
    public void removeProd() {
        verifyWebsiteStep();
        int prodNum = 5;
        userRegisterInfor = new UserRegisterInfor();
        homePage = new HomePage(driver);
        headerMenu = new HeaderMenu(driver);
        String prodName = homePage.prodName(prodNum);
        homePage.addCart(prodNum);
        homePage.clickContinue();
        cartPage = headerMenu.goToCartPage();
        cartPage.verifyCartPage();
        cartPage.clickToRemoveProd();
        cartPage.verifyRemove(prodName);
    }

    @Test(groups = {"TC19"})
    @Description("View & Cart Brand Products")
    public void viewCartBrand() {
        //0=Polo, 1=H&M, 3=Madame,....
        int brandNum = 1;
        headerMenu = new HeaderMenu(driver);
        productPage = headerMenu.goToProductPage();
        productPage.verifyBrands();
        productPage.selectBrand(brandNum);
        productPage.verifyBrandPage(brandNum);
        productPage.verifyProductsList();
        productPage.selectBrand(brandNum + 1);
        productPage.verifyBrandPage(brandNum + 1);
        productPage.verifyProductsList();
    }

    @Test(groups = {"TC20"})
    @Description("Search Products and Verify Cart After Login")
    public void searchVerifyAfterLogin() throws InterruptedException {
        headerMenu = new HeaderMenu(driver);
        productPage = headerMenu.goToProductPage();
        productPage.verifyProductPage();
        String prodSearchName = "blue";
        productPage.enterNameToSearch(prodSearchName);
        productPage.verifySearchProdTitle();
        productPage.verifySearchProd(prodSearchName.toLowerCase());
        int prodQuantity = productPage.getProdQuantity();
        productPage.addAllProdToCart();
        cartPage = headerMenu.goToCartPage();
        cartPage.verifyCartPage();
        cartPage.verifyProdVisible(prodSearchName, prodQuantity);
        userRegisterInfor = new UserRegisterInfor();
        String userMail = CreateAcc.createNewAccount(userRegisterInfor);
        loginPage = headerMenu.goToLoginPage();
        loginPage.verifyLogInVisible();
        loginPage.fillLogInInfor(userMail, DefaultValue.defaultPassword);
        loginPage.selectLogInBtn();
        headerMenu.goToCartPage();
        cartPage.verifyProdVisible(prodSearchName, prodQuantity);
    }

    @Test(groups = {"TC21"})
    @Description("Add review on product")
    public void addReviewProd() {
        int prodNum = 0;
        headerMenu = new HeaderMenu(driver);
        productPage = headerMenu.goToProductPage();
        productPage.verifyProductPage();
        productDetailPage = productPage.clickViewProd(prodNum);
        productDetailPage.verifyReviewVisible();
        productDetailPage.fillReviewInfor();
        productDetailPage.clickSubmitBtn();
        productDetailPage.verifyMsg();
    }


    @Description("Verify address details in checkout page")
    public void verifyAddress(){
        verifyWebsiteStep();
        int prodNum = 5;
        userRegisterInfor = new UserRegisterInfor();
        registerUser(DataGen.genEmail(), userRegisterInfor);
        headerMenu = new HeaderMenu(driver);
        headerMenu.verifyUserName();
        homePage = new HomePage(driver);
        homePage.addCart(prodNum);
        String prodName = homePage.prodName(prodNum);
        homePage.clickContinue();
        cartPage = headerMenu.goToCartPage();
        cartPage.verifyCartPage();
        checkOutPage = cartPage.clickProcessCheckOut();
        checkOutPage.verifyDeliveryInfo(userRegisterInfor);
        checkOutPage.verifyBillingAddress(userRegisterInfor);
        deleteAccStep();
    }

}
