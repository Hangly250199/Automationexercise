package GUI.Steps;

import Page.FooterPage;
import TestComponents.DataGen;

public class FooterSteps extends LogInSignInStep{
    FooterPage footerPage;
    public void fillSubInfor(){
        footerPage = new FooterPage(driver);
        footerPage.scrollEndPage();
        footerPage.verifySubscription();
        footerPage.fillInforAndSub(DataGen.genEmail());
        footerPage.verifySubSuccess();
    }
}
