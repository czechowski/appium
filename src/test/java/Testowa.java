import PageObjects.PlayStoreHomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Testowa {
    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;

    PlayStoreHomePage playStoreHomePage;

    @BeforeMethod
    public void setUp(ITestContext context) throws MalformedURLException {
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"), getCapabilities());
        wait = new WebDriverWait(driver, 30)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);

        context.setAttribute("driver", this.driver);
        context.setAttribute("wait", this.wait);

        playStoreHomePage = new PlayStoreHomePage(context);


    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "Procountor" },
                { "Facebook"},
        };
    }
    @Test (dataProvider = "test1")
    public void testName(String appName) throws MalformedURLException {


        FluentWait<WebDriver> wait = new WebDriverWait(driver, 90)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@resource-id,'search_box_idle_text')]")));
        playStoreHomePage.searchInStore(appName);
        //driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'li_title')][@text='Procountor Key']")).click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities = new DesiredCapabilities();
        //capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "7.1.2");
        capabilities.setCapability("deviceName", "Redmi");
        capabilities.setCapability("udid", "5b37c8d7d140");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.vending");
        capabilities.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("newCommandTimeout", 900000);
        capabilities.setCapability("androidInstallTimeout", 900000);
        return capabilities;
    }
}
