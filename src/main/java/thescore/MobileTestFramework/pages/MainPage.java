package thescore.MobileTestFramework.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import thescore.MobileTestFramework.generalUtilities.AppControl;
import thescore.MobileTestFramework.generalUtilities.FieldLookup;

public class MainPage extends AppControl {

	public MainPage(AndroidDriver<MobileElement> aDriver) 
	{
		super(aDriver);
	}

	public void navigateToLeagues()
	{
		tap(By.id(FieldLookup.BOTTOM_NAVIGATION_LEAGUES_RESOURCE_ID));
	}
}
