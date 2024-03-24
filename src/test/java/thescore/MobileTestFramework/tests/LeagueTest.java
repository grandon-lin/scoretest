package thescore.MobileTestFramework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import thescore.MobileTestFramework.generalUtilities.FieldLookup;
import thescore.MobileTestFramework.generalUtilities.ReadExcelUtils;
import thescore.MobileTestFramework.pages.LeaguesPage;
import thescore.MobileTestFramework.pages.MainPage;
import thescore.MobileTestFramework.pages.WelcomePage;

public class LeagueTest extends TestBase {
	
	@Test
	public void testFile() throws Exception
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\thescore.MobileTestFramework.testData" + "\\exceldata.xlsx";
		System.out.println("The file path is: " + filePath);
		try
		{
			ReadExcelUtils.setExcelFile(filePath, "Leagues");
		}
		catch (Exception e)
		{
			throw(e);
		}
		
		int rowCount = ReadExcelUtils.getRowCount();
		System.out.println("The rowCount is: " + rowCount);
		
		for(int i = 0; i < rowCount; i++)
		{
			String league = ReadExcelUtils.getCellData(i, 0);

		}
	}

	@Test
	public void testLeague() throws Exception
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.login();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(FieldLookup.DIALOG_DISMISS_BUTTON_RESOURCE_ID))));
			driver.findElement(By.id(FieldLookup.DIALOG_DISMISS_BUTTON_RESOURCE_ID)).click();
			System.out.println("Found the dialog");
		}
		catch (Exception e) 
		{
			System.out.println("No dialog displayed.");
			
		}
		
		MainPage mainPage = new MainPage(driver);
		mainPage.navigateToLeagues();
		
		LeaguesPage leaguesPage = new LeaguesPage(driver);
		String expectedPageTitle = "Leagues";
		String actualPageTitle = driver.findElement(By.id(FieldLookup.LEAGUES_PAGE_TITLE_RESOURCE_ID)).getText().toString();
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		
		int rowCount = ReadExcelUtils.getRowCount();
		
		leaguesPage.openALeague("MMA");
//		for(int i = 0; i < 1; i++)
//		{
//			String league = ReadExcelUtils.getCellData(i, 0);
//			leaguesPage.openALeague(league);
//		}
	}
}
