package thescore.MobileTestFramework.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import thescore.MobileTestFramework.generalUtilities.AppControl;
import thescore.MobileTestFramework.generalUtilities.FieldLookup;

public class MainControl extends AppControl {

	public MainControl(AndroidDriver<MobileElement> aDriver) {
		super(aDriver);
	}

	public void navigateToLeagues()
	{
		tap(By.id(FieldLookup.BOTTOM_NAVIGATION_LEAGUES_RESOURCE_ID));
	}
	
	public void navigateToNews()
	{
		tap(By.id(FieldLookup.BOTTOM_NAVIGATION_NEWS_RESOURCE_ID));
	}

	public void navigateToScores()
	{
		tap(By.id(FieldLookup.BOTTOM_NAVIGATION_SCORES_RESOURCE_ID));
	}
	
	public void navigateToFavorites()
	{
		tap(By.id(FieldLookup.BOTTOM_NAVIGATION_FAVORITES_RESOURCE_ID));
	}
	
	public void navigateToBet()
	{
		tap(By.id(FieldLookup.BOTTOM_NAVIGATION_BET_RESOURCE_ID));
	}
	
	public void navigateBack()
	{
		tap(By.xpath(FieldLookup.TOP_BAR_NAVIGATE_UP_XPATH));
	}
}
