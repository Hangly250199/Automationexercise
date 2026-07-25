package TestComponents;

import Page.FooterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractComponents {
    WebDriver driver;
    public AbstractComponents(WebDriver driver){
        this.driver=driver;
    }
    public void waitForEleAppear(WebElement webEle){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webEle));
    }
    public void waitForEleDisappear(WebElement webEle){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(webEle));
    }
    public WebElement findByID(String id){
        return driver.findElement(By.id(id));
    }
    public WebElement findByxPath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    public List<WebElement> findByxPaths(String xpath){
        return driver.findElements(By.xpath(xpath));
    }
    public void scrollToEle(WebElement ele){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
    }
    public FooterPage scrollEndPage(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, document.body.scrollHeight)");
        return new FooterPage(driver);
    }
    public void scrollUpStartPage(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 0)");
    }
    public void waitForEleClickable(WebElement findEle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(findEle));
    }
    public void waitForTitleToBe(String expectedTitle){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(expectedTitle));
    }
    public void waitForTextToBe(WebElement webElement, String expectedText){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, expectedText));
    }

//    public void closeAdIfExist() {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//            WebElement closeBtn = wait.until(ExpectedConditions
//                    .elementToBeClickable(By.xpath("//div[text()='Close']")));
//            closeBtn.click();
//        } catch (TimeoutException e) {
//        }
//    }
}
