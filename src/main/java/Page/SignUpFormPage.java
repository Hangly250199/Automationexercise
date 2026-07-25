package Page;

import PageOject.SignUpFormPageObject;
import TestComponents.UserRegisterInfor;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUpFormPage extends SignUpFormPageObject {
    WebDriver driver;
    public static String userName;
    public SignUpFormPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void verifyTitle() {
        waitForEleAppear(pageTitle);
        Assert.assertEquals(pageTitle.getText(), expectedTitle);
    }

    @Step("9. Fill details: Title, Name, Email, Password, Date of birth")
    public void fillCusInformation(UserRegisterInfor userRegisterInfor) {
        if (userRegisterInfor.getGenderTitle().equalsIgnoreCase("Mr.")) {
            gender1Radio.click();
        } else {
            gender2Radio.click();
        }
        passWordInput.sendKeys(userRegisterInfor.getPassword());
        new Select(daysSelect).selectByValue(userRegisterInfor.getDayOfBirth());
        new Select(monthsSelect).selectByVisibleText(userRegisterInfor.getMonthOfBirth());
        new Select(yearsSelect).selectByValue(userRegisterInfor.getYearOfBirth());
    }

    @Step("10. Select checkbox 'Sign up for our newsletter!'")
    public void selectNewsletterCheckbox() {
        newsletterCheckbox.click();
    }

    @Step("11. Select checkbox 'Receive special offers from our partners!'")
    public void selectOptionCheckbox() {
        optionCheckbox.click();
    }

    @Step("12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fillAddressInformation(UserRegisterInfor userRegisterInfor) {
        firstNameInput.sendKeys(userRegisterInfor.getFirstName());
        lastNameInput.sendKeys(userRegisterInfor.getLastName());
        companyInput.sendKeys(userRegisterInfor.getCompany());
        address1Input.sendKeys(userRegisterInfor.getAddress1());
        address2Input.sendKeys(userRegisterInfor.getAddress2());
        new Select(countrySelect).selectByValue(userRegisterInfor.getCountry());
        stateInput.sendKeys(userRegisterInfor.getState());
        cityInput.sendKeys(userRegisterInfor.getCity());
        zipcodeInput.sendKeys(userRegisterInfor.getZipcode());
        mobileNumberInput.sendKeys(userRegisterInfor.getMobileNumber());
    }

    @Step("13. Click 'Create Account button'")
    public CreateAccConfirmPage createAccount() {
        userName = nameField.getAttribute("value");
        findByxPath(SignUpFormPageObject.submitBtn_xPath).click();
        return new CreateAccConfirmPage(driver);
    }
}
