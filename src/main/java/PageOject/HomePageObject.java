package PageOject;

import TestComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageObject extends AbstractComponents {
    public HomePageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static final String expectedText="Full-Fledged practice website for Automation Engineers";
    public static final String expectedCateTitle="WOMEN -  Dress PRODUCTS";
    public static final String expectedRecommendTitle ="recommended items";

    @FindBy(xpath = "(//div[@class='productinfo text-center']//p)")
    public  static List<WebElement> prodNameList;

    @FindBy(xpath = "(//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart'])")
    public static List<WebElement> prodCartList;

    @FindBy(xpath = "//div[@class='carousel slide']//div[@class='item active']//a[@class='btn btn-default add-to-cart']")
    public static List<WebElement> recommendAddToCartList;

    @FindBy(xpath = "//div[@id='recommended-item-carousel']//div[@class='item active']//div[@class='productinfo text-center']//p")
    public static List<WebElement> recommendProdNameList;

    @FindBy(id = "scrollUp")
    public static WebElement arrowUpBtn;

    @FindBy(xpath = "//div[@id='slider-carousel']//div[@class='item active']//h2")
    public static WebElement textTitle;

    public static final String viewProd_xPath="//a[contains(@href,'/product_detail')]";
    @FindBy(xpath = viewProd_xPath)
    public List<WebElement> viewProdList;

    public static final String title_xPath="//h2[@class='title text-center']";
    @FindBy(xpath = title_xPath)
    public WebElement pageTitle;

    public static final String continueBtn_xPath ="//button[.='Continue Shopping']";
    @FindBy(xpath = continueBtn_xPath)
    public WebElement continueBtn;

    public static final String womenSubCat_xPath ="//div[@id='Women']//li//a";
    @FindBy(xpath = womenSubCat_xPath)
    public List<WebElement> womenSubCategory;

    public static final String categoryTitle_xPath="//h2[@class='title text-center']";
    @FindBy(xpath = categoryTitle_xPath)
    public WebElement categoryTitle;

    public static final String menCat_xPath="//a[@href='#Men']";
    @FindBy(xpath = menCat_xPath)
    public WebElement menCategory;

    public static final String menSubCat_xPath ="//div[@id='Men']//li//a";
    @FindBy(xpath = menSubCat_xPath)
    public List<WebElement> menSubCategory;

    public static final String kidsSubCat_xPath ="//div[@id='Kids']//li//a";
    @FindBy(xpath = kidsSubCat_xPath)
    public List<WebElement> kidsSubCategory;

    public static final String category_xPath="(//h4[@class='panel-title']//a)";
    @FindBy(xpath = category_xPath)
    public List<WebElement> categoryList;

    public static final String subCate_xPath="//div[@class='panel-body']//ul//li";
    @FindBy(xpath = subCate_xPath)
    public List<WebElement> subCategoryList;

    public static final String womenCategory_xPath="//a[@href='#Women']";
    @FindBy(xpath = womenCategory_xPath)
    public WebElement womenCategory;

    public static final String dressSubCategory_xPath="//a[@href='/category_products/1']";
    @FindBy(xpath = dressSubCategory_xPath)
    public WebElement dressSubCategory;

    public static final String recommendTitle_xPath="//div[@class='recommended_items']//h2[@class='title text-center']";
    @FindBy(xpath = recommendTitle_xPath)
    public WebElement recommendTitle;

    public static final String viewCart_xPath="//div[@class='modal-body']//a";
    @FindBy(xpath = viewCart_xPath)
    public WebElement viewCart;

    public String getProdName(int prodNo){
       return prodNameList.get(prodNo-1).getText();
    }
    public WebElement getMenSubCate(int subCateNo){
        return findByxPaths(menSubCat_xPath).get(subCateNo);
    }
    public WebElement textTitle(){
        return findByxPath(categoryTitle_xPath);
    }
    public String getSubCateName(int categoryNo, int subCategoryNo){
        String subCateName = "";
        String categoryName= categoryList.get(categoryNo).getText().toUpperCase();
        if (categoryName.contains("WOMEN")) {
            subCateName = womenSubCategory.get(subCategoryNo).getText();
        }else if (categoryName.contains("KIDS")) {
            subCateName = kidsSubCategory.get(subCategoryNo).getText();
        } else if (categoryName.contains("MEN")) {
            subCateName = menSubCategory.get(subCategoryNo).getText();
        }
        return subCateName.trim();
    }
    public String getExpectedCatePageName(int categoryNo, int subCategoryNo){
        String categoryName= categoryList.get(categoryNo).getText();
        return categoryName+" - "+getSubCateName(categoryNo, subCategoryNo)+" PRODUCTS";
    }
}
