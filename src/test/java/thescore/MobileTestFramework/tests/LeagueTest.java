package thescore.MobileTestFramework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import thescore.MobileTestFramework.generalUtilities.Constant;
import thescore.MobileTestFramework.generalUtilities.FieldLookup;
import thescore.MobileTestFramework.generalUtilities.ReadExcelUtils;
import thescore.MobileTestFramework.pages.LeaguesPage;
import thescore.MobileTestFramework.pages.MainControl;
import thescore.MobileTestFramework.pages.WelcomePage;

public class LeagueTest extends TestBase {
	
	@Test
	public void getStartedTest() throws Exception
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getStarted();
		welcomePage.continueTapped();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")));
		welcomePage.chooseFavoriteTeam();
		welcomePage.continueTapped();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FieldLookup.DONE_BTN_XPATH)));
		welcomePage.doneTapped();
		
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
		
		MainControl mainControl = new MainControl(driver);
		mainControl.navigateToLeagues();
		
		LeaguesPage leaguesPage = new LeaguesPage(driver);
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\thescore.MobileTestFramework.testData" + "\\exceldata.xlsx";

		try
		{
			ReadExcelUtils.setExcelFile(filePath, "Leagues");
		}
		catch (Exception e)
		{
			throw(e);
		}
		
		int rowCount = ReadExcelUtils.getRowCount();
		for(int i = 0; i < rowCount; i++)
		{
			String league = ReadExcelUtils.getCellData(i, 0);
			leaguesPage.openALeague(league);
			String leaguePageTitle = driver.findElement(By.id(FieldLookup.TOP_BAR_TITLE_RESOURCE_ID)).getText();
			Assert.assertEquals(league, leaguePageTitle);
			mainControl.navigateBack();
			Assert.assertTrue(leaguesPage.isSelectedLeagueAddedToTopBar(league));
		}
	}

	@Test
	public void testLeague() throws Exception
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.login();

		//In case a dialog appears, close the dialog
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
		
		//Step 1: Open a league
		MainControl mainControl = new MainControl(driver);
		mainControl.navigateToLeagues();
		
		//Step 2: Verify that the expected page opens correctly
		LeaguesPage leaguesPage = new LeaguesPage(driver);
		String expectedPageTitle = Constant.LEAGUES_PAGE_TITLE;
		String actualPageTitle = driver.findElement(By.id(FieldLookup.LEAGUES_PAGE_TITLE_RESOURCE_ID)).getText().toString();
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		
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
		
		int rowCount = ReadExcelUtils.getRowCount();
		
		for(int i = 0; i < rowCount; i++)
		{
			//Step 3. Open a league
			String league = ReadExcelUtils.getCellData(i, 0);
			leaguesPage.openALeague(league);
			
			//Step 4. Verify it's the correct tab
			String leaguePageTitle = driver.findElement(By.id(FieldLookup.TOP_BAR_TITLE_RESOURCE_ID)).getText();
			Assert.assertEquals(league, leaguePageTitle);
			
			//Step 5. Navigate back and verify it returns to the previous page
			mainControl.navigateBack();
			expectedPageTitle = Constant.LEAGUES_PAGE_TITLE;
			actualPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FieldLookup.LEAGUES_PAGE_TITLE_RESOURCE_ID))).getText();
			Assert.assertEquals(expectedPageTitle, actualPageTitle);
			Assert.assertTrue(leaguesPage.isSelectedLeagueAddedToTopBar(league));
		}
	}
}
