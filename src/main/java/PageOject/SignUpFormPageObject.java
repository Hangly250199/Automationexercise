package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpFormPageObject extends AbstractComponents {
    public SignUpFormPageObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public static String expectedTitle = "ENTER ACCOUNT INFORMATION";

    public static final String nameID = "name";
    @FindBy(id = nameID)
    public WebElement nameField;

//    public static String gender1Id = "id_gender1";
//    public static String gender2Id = "id_gender2";
//    public static String passWordId = "password";
//    public static String daysId = "days";
//    public static String monthsId = "months";
//    public static String yearsId = "years";
//    public static String newsletterId = "newsletter";
//    public static String optionId = "optin";
//    public static String first_nameID = "first_name";
//    public static String last_nameID = "last_name";
//    public static String companyID = "company";
//    public static String address1ID = "address1";
//    public static String address2ID = "address2";
//    public static String countryID = "country";
//    public static String stateID = "state";
//    public static String cityID = "city";
//    public static String zipcodeID = "zipcode";
//    public static String mobile_numberId = "mobile_number";
//    public static String submitBtn_xPath="//button[@data-qa='create-account']";
//    public static String pageTitle_xPath="(//h2[@class='title text-center'])[1]";

    public static final String gender1Id = "id_gender1";
    @FindBy(id = gender1Id)
    public WebElement gender1Radio;

    public static final String gender2Id = "id_gender2";
    @FindBy(id = gender2Id)
    public WebElement gender2Radio;

    public static final String passWordId = "password";
    @FindBy(id = passWordId)
    public WebElement passWordInput;

    public static final String daysId = "days";
    @FindBy(id = daysId)
    public WebElement daysSelect;

    public static final String monthsId = "months";
    @FindBy(id = monthsId)
    public WebElement monthsSelect;

    public static final String yearsId = "years";
    @FindBy(id = yearsId)
    public WebElement yearsSelect;

    public static final String newsletterId = "newsletter";
    @FindBy(id = newsletterId)
    public WebElement newsletterCheckbox;

    public static final String optionId = "optin";
    @FindBy(id = optionId)
    public WebElement optionCheckbox;

    // Address Information
    public static final String first_nameID = "first_name";
    @FindBy(id = first_nameID)
    public WebElement firstNameInput;

    public static final String last_nameID = "last_name";
    @FindBy(id = last_nameID)
    public WebElement lastNameInput;

    public static final String companyID = "company";
    @FindBy(id = companyID)
    public WebElement companyInput;

    public static final String address1ID = "address1";
    @FindBy(id = address1ID)
    public WebElement address1Input;

    public static final String address2ID = "address2";
    @FindBy(id = address2ID)
    public WebElement address2Input;

    public static final String countryID = "country";
    @FindBy(id = countryID)
    public WebElement countrySelect;

    public static final String stateID = "state";
    @FindBy(id = stateID)
    public WebElement stateInput;

    public static final String cityID = "city";
    @FindBy(id = cityID)
    public WebElement cityInput;

    public static final String zipcodeID = "zipcode";
    @FindBy(id = zipcodeID)
    public WebElement zipcodeInput;

    public static final String mobile_numberId = "mobile_number";
    @FindBy(id = mobile_numberId)
    public WebElement mobileNumberInput;

    // Buttons & Headers
    public static final String submitBtn_xPath = "//button[@data-qa='create-account']";
    @FindBy(xpath = submitBtn_xPath)
    public WebElement submitBtn;

    public static final String pageTitle_xPath = "(//h2[@class='title text-center'])[1]";
    @FindBy(xpath = pageTitle_xPath)
    public WebElement pageTitle;
}
