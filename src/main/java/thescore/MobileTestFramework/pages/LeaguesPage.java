package thescore.MobileTestFramework.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import thescore.MobileTestFramework.generalUtilities.AppControl;
import thescore.MobileTestFramework.generalUtilities.FieldLookup;

public class LeaguesPage extends AppControl {
	
	public LeaguesPage(AndroidDriver<MobileElement> aDriver) {
		super(aDriver);
	}

	public void openALeague(String leagueName)
	{
		By leagueXpath = By.xpath(FieldLookup.LEAGUES_PAGE_LIST_INDIVIDUAL_LEAGUE_XPATH(leagueName));
		swipeDownToElment(leagueXpath);
		tap(leagueXpath);
		System.out.println("Open the league: " + leagueName);
	}
	
	public boolean isSelectedLeagueAddedToTopBar(String selectedLeague)
	{
		swipeUpToElment(By.xpath(FieldLookup.LEAGUES_PAGE_TOP_BAR_XPATH));
		By recyclerViewBy = By.xpath("//androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView");
		By elementBy = By.xpath(FieldLookup.LEAGUES_PAGE_TOP_BAR_QUICK_ACCESS_XPATH(selectedLeague));
		swipeRightToElement(recyclerViewBy, elementBy);
		return isElementVisible(elementBy);
	}
}
