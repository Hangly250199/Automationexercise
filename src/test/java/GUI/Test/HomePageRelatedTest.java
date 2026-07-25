package GUI.Test;

import GUI.Steps.FooterSteps;
import Page.CartPage;
import Page.HeaderMenu;
import Page.LaunchingPage;
import Page.TestCasePage;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
public class HomePageRelatedTest extends FooterSteps {
    LaunchingPage launchingPage;
    HeaderMenu headerMenu;
    TestCasePage testCasePage;
    CartPage cartPage;


    @Test(groups = {"TC07"})
    public void verifyTCPage() {
        verifyWebsiteStep();
        headerMenu = new HeaderMenu(driver);
        testCasePage = headerMenu.goToTCPage();
        testCasePage.verifyPageTitle();
    }

    @Test(groups = {"TC10"})
    public void verifySubscriptionHP() {
        verifyWebsiteStep();
        fillSubInfor();
    }

    @Test(groups = {"VerifySubscriptionCartPage", "TC11"})
    public void verifySubscriptionCartPage() {
        verifyWebsiteStep();
        headerMenu = new HeaderMenu(driver);
        cartPage = headerMenu.goToCartPage();
        fillSubInfor();
    }
}
