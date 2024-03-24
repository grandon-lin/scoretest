package thescore.MobileTestFramework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import thescore.MobileTestFramework.base.AppBase;
import thescore.MobileTestFramework.generalUtilities.FieldLookup;
import thescore.MobileTestFramework.generalUtilities.ReadExcelUtils;

public class TestBase {
	
	public AndroidDriver<MobileElement> driver;
	public AppBase appBase;
	public WebDriverWait wait;
	
	public TestBase() {
		appBase = new AppBase();		
	}
	
	@BeforeTest
	public void setup() throws Exception
	{
		System.out.println("In Before Test");
		driver = appBase.initializeDriver();
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(FieldLookup.LOG_IN_BTN_RESOURCE_ID)));
		
		//Load test data file
		String filePath = System.getProperty("user.dir") + "/src/test/resources/thescore.MobileTestFramework.testData" + "/exceldata.xlsx";
		
		try
		{
			ReadExcelUtils.setExcelFile(filePath, "Leagues");
		}
		catch (Exception e)
		{
			throw(e);
		}
	}
		
	@AfterTest
	public void closeApplication()
	{
//		driver.quit();
	}
}
