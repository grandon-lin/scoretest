package thescore.MobileTestFramework.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;

public class AppBase {
	
	public AndroidDriver<MobileElement> driver;
	public DesiredCapabilities caps;
	
	public AppBase()
	{
		caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/thescore.MobileTestFramework.apps/" + "com.fivemobile.thescore_24.4.0-24040.apk");
		caps.setCapability("appPackage", "com.fivemobile.thescore");
		caps.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");
		caps.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability("autoGrantPermissions", true);
//		caps.setCapability("noReset", true);
		System.out.println("Starting...");
	}
	
	public AndroidDriver<MobileElement> initializeDriver() throws MalformedURLException
	{
		return driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps); 
	}
}
