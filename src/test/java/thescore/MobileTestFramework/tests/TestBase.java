package thescore.MobileTestFramework.tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import thescore.MobileTestFramework.generalUtilities.FieldLookup;

public class TestBase {
	
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		System.out.println("In Before Test");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),setDesiredCapabilities());
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(FieldLookup.LOG_IN_BTN_RESOURCE_ID)));
	}
	
	private DesiredCapabilities setDesiredCapabilities()
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/thescore.MobileTestFramework.apps/" + "com.fivemobile.thescore_24.4.0-24040.apk");
		caps.setCapability("appPackage", "com.fivemobile.thescore");
		caps.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");
		caps.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability("autoGrantPermissions", true);
		System.out.println("Starting...");
		return caps;
	}
		
	@AfterMethod
	public void closeApplication()
	{
		driver.quit();
	}
}
