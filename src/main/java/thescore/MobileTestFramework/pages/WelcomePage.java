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
	
	public void getStarted()
	{
		MobileElement getStartedBtn = driver.findElement(By.xpath(FieldLookup.GETSTARTED_BTN_XPATH));
		getStartedBtn.click();
		waitUntilElementClickable(By.xpath(FieldLookup.CONTINUE_BTN_XPATH));
	}
	
	public void continueTapped()
	{
		MobileElement continueBtn = driver.findElement(By.xpath(FieldLookup.CONTINUE_BTN_XPATH));
		continueBtn.click();
	}
	
	public void doneTapped()
	{
		MobileElement doneBtn = driver.findElement(By.xpath(FieldLookup.DONE_BTN_XPATH));
		doneBtn.click();
	}

	//For testing purpose for now
	public void chooseFavoriteTeam()
	{
		MobileElement selectedTeam = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView"));
		selectedTeam.click();
		waitUntilElementClickable(By.xpath(FieldLookup.CONTINUE_BTN_XPATH));
	}
	
	public void login()
	{
		MobileElement loginBtn = driver.findElement(By.id(FieldLookup.LOG_IN_BTN_RESOURCE_ID));
		int elementX = loginBtn.getLocation().getX() + loginBtn.getRect().getWidth() - 80;
		int elementY = loginBtn.getLocation().getY() + 20;
		tapOnElementAtPosition(elementX, elementY);
		
		enterEmail("grandonlin@gmail.com");
		enterPassword("Abcd123$");
		loginTapped();
	}
	
	public void enterEmail(String email)
	{
		sendKeys(email, By.id(FieldLookup.EMAIL_INPUT_RESOURCE_ID));
	}
	
	public void enterPassword(String password)
	{
		sendKeys(password, By.id(FieldLookup.PASSWORD_INPUT_RESOURCE_ID));
	}
	
	public void loginTapped()
	{
		tap(By.id(FieldLookup.LOGIN_BUTTON_RESOURCE_ID));
	}
}
