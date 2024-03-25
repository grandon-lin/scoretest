package thescore.MobileTestFramework.generalUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("rawtypes")
public class AppControl {

	protected AndroidDriver<MobileElement> driver;
	protected WebDriverWait wait;
	
	public AppControl(AndroidDriver<MobileElement> aDriver)
	{
		driver = aDriver;
		wait = new WebDriverWait(driver, 30);
	}
	
	public void tap(By by)
	{
		driver.findElement(by).click();
	}
	
	public void tapOnElementAtPosition(int coordinateX, int coordinateY)
	{
		TouchAction<?> ta = new TouchAction(driver);
		ta.tap(PointOption.point(coordinateX, coordinateY)).perform();
	}
	
	public void sendKeys(String input, By by)
	{
		driver.findElement(by).sendKeys(input);
	}
	
	public AndroidDriver<MobileElement> getDriver() 
	{
		return driver;
	}
	
	public void waitUntilElementVisible(By by)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
	}
	
	public void waitUntilElementClickable(By by)
	{
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	//Swipe up to move down
	public void swipeDownToElment(By by)
	{
		while(!isElementVisible(by))
		{
			System.out.println("Can't find the element yet");
			TouchAction<?> touchAction = new TouchAction(driver);
			Dimension size = driver.manage().window().getSize();
			int x = size.getWidth() / 2;
			int startPoint = (int)(size.getHeight() * 0.8);
			int endPoint = (int)(size.getHeight() * 0.2);
			
			touchAction.press(PointOption.point(x, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(x, endPoint)).release().perform();
		}
		waitUntilElementClickable(by);
	}
	
	//Swipe down to move up
	public void swipeUpToElment(By by)
	{
		while(!isElementVisible(by))
		{
			System.out.println("Can't find the element yet");
			TouchAction<?> touchAction = new TouchAction(driver);
			Dimension size = driver.manage().window().getSize();
			int x = size.getWidth() / 2;
			int startPoint = (int)(size.getHeight() * 0.2);
			int endPoint = (int)(size.getHeight() * 0.8);
			
			touchAction.press(PointOption.point(x, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(x, endPoint)).release().perform();
		}
		waitUntilElementClickable(by);
	}
	
	//Swipe left to move right
	public void swipeRightToElement(By recycleViewBy, By elementBy)
	{
		while(!isElementVisible(elementBy))
		{
			System.out.println("Can't find the element yet");
			TouchAction<?> touchAction = new TouchAction(driver);
			MobileElement recyclerView = driver.findElement(recycleViewBy);
			int y = recyclerView.getCenter().getY();
			Dimension size = driver.manage().window().getSize();
			int startPoint = (int)(size.getWidth() * 0.9);
			int endPoint = (int)(size.getWidth() * 0.1);
			
			touchAction.press(PointOption.point(startPoint, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(endPoint, y)).release().perform();
		}
		waitUntilElementClickable(elementBy);
	}
	
	public boolean isElementVisible(By by)
	{
		try
		{
			return driver.findElement(by).isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
