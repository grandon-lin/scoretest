package thescore.MobileTestFramework.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import thescore.MobileTestFramework.generalUtilities.AppControl;
import thescore.MobileTestFramework.generalUtilities.FieldLookup;

public class WelcomePage extends AppControl {
	
	public WelcomePage(AndroidDriver<MobileElement> aDriver)
	{
		super(aDriver);
	}
	
	public void login()
	{
		MobileElement loginBtn = driver.findElement(By.id(FieldLookup.LOG_IN_BTN_RESOURCE_ID));
		int elementX = loginBtn.getLocation().getX() + loginBtn.getRect().getWidth() - 80;
		int elementY = loginBtn.getLocation().getY() + 20;
		tapOnElementAtPosition(elementX, elementY);
		
		sendKeys("grandonlin@gmail.com", By.id(FieldLookup.EMAIL_INPUT_RESOURCE_ID));
		sendKeys("Abcd123$", By.id(FieldLookup.PASSWORD_INPUT_RESOURCE_ID));
		tap(By.id(FieldLookup.LOGIN_BUTTON_RESOURCE_ID));
	}
}
