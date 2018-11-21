package Framework;

import com.google.gson.Gson;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseDriver {
    public void setDriverContext(ITestContext context) throws FileNotFoundException, MalformedURLException {
        context.setAttribute("driver", initialiseDriver());
        context.setAttribute("wait",initialiseWait((AndroidDriver<AndroidElement>)context.getAttribute("driver")));
    }

    private FluentWait<WebDriver> initialiseWait(AndroidDriver<AndroidElement> driver) {
        return new WebDriverWait(driver, 30)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);
    }

    private AndroidDriver<AndroidElement> initialiseDriver() throws FileNotFoundException, MalformedURLException {
        return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"), getCapabilities());
    }


    private DesiredCapabilities getCapabilities() throws FileNotFoundException {
        Gson g = new Gson();
        BufferedReader cd = new BufferedReader(new FileReader("./src/test/Resources/capabilitiesDevices.json"));
        CapabilitiesDevices capabilitiesDevices = g.fromJson(cd,CapabilitiesDevices.class);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities = new DesiredCapabilities();
        //capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", capabilitiesDevices.getBROWSER_NAME());
        capabilities.setCapability("VERSION", capabilitiesDevices.getVERSION());
        capabilities.setCapability("deviceName", capabilitiesDevices.getDeviceName());
        capabilities.setCapability("udid", capabilitiesDevices.getUdid());
        capabilities.setCapability("platformName", capabilitiesDevices.getPlatformName());
        capabilities.setCapability("appPackage", capabilitiesDevices.getAppPackage());
        capabilities.setCapability("appActivity", capabilitiesDevices.getAppActivity());
        capabilities.setCapability("autoGrantPermissions", capabilitiesDevices.getAutoGrantPermissions());
        capabilities.setCapability("newCommandTimeout", capabilitiesDevices.getNewCommandTimeout());
        capabilities.setCapability("androidInstallTimeout", capabilitiesDevices.getAndroidInstallTimeout());
        return capabilities;
    }
}
