package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public BaseTest(){}
    public WebDriver initializedDriver() throws IOException {
        Properties prod = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resource/GlobalData.properties");
        prod.load(file);
        String browserName = System.getProperty("browser")!=null?System.getProperty("browser"): prod.getProperty("browser");

        // Cấu hình chung để chặn pop-up quảng cáo cho các trình duyệt
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.popups", 2); // 2 = Block toàn bộ pop-up quảng cáo
        prefs.put("profile.default_content_setting_values.notifications", 2); // Chặn luôn thông báo đẩy phiền phức

        if(browserName.equalsIgnoreCase("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", prefs);
            chromeOptions.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browserName.equalsIgnoreCase("edge")){
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setExperimentalOption("prefs", prefs);
            edgeOptions.addArguments("--disable-popup-blocking");
            driver = new EdgeDriver(edgeOptions);
        }

        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void launchingWeb() throws IOException {
        driver=initializedDriver();
        driver.get(DefaultValue.webUrl);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "const style = document.createElement('style');" +
                        "style.innerHTML = '*[id*=\"google_ads\"], .google-vignette, #google_vignette, .adsbygoogle { display: none !important; pointer-events: none !important; }';" +
                        "document.head.appendChild(style);"
        );
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebsite() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}