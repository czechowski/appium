package Steps;

import Framework.CapabilitiesDevices;
import Framework.TestHooks;
import PageObjects.PlayStoreHomePage;
import com.google.gson.Gson;
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
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest extends TestHooks {
    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;

    PlayStoreHomePage playStoreHomePage;

    @BeforeMethod(groups = {"smoke", "regression"})
    public void setUp(ITestContext context) throws MalformedURLException, FileNotFoundException {
        playStoreHomePage = new PlayStoreHomePage(context);
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Procountor"},
                {"Facebook"},
        };
    }

    @Test(groups = {"appium","smoke", "regression"}, dataProvider = "test1")
    public void testName(ITestContext context,String appName) throws MalformedURLException {
        ((FluentWait<WebDriver>)context.getAttribute("wait")).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@resource-id,'search_box_idle_text')]")));
        playStoreHomePage.searchInStore(appName);

    }

}
