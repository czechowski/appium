package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestContext;

public class PlayStoreHomePage {

    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;
    private final By searchField = By.xpath("//*[contains(@resource-id,'search_box_idle_text')]");
    private final By searchFieldInput = By.xpath("//*[contains(@resource-id,'search_box_text_input')]");

    public PlayStoreHomePage(ITestContext context) {
        this.driver = (AndroidDriver<AndroidElement>)context.getAttribute("driver");
        this.wait = (FluentWait<WebDriver>)context.getAttribute("wait");
    }

    public void searchInStore(String ApkToFind) {
        driver.findElement(searchField).click();
        driver.findElement(searchFieldInput).sendKeys(ApkToFind);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
