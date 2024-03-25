package thescore.MobileTestFramework.generalUtilities;

public class FieldLookup {

	//Welcome page elements
	public static final String GETSTARTED_BTN_XPATH = "//android.widget.TextView[@text='Get Started']";
	public static final String LOG_IN_BTN_RESOURCE_ID = "com.fivemobile.thescore:id/txt_sign_in";
	public static final String CONTINUE_BTN_XPATH = "//android.widget.TextView[@text='Continue']";
	public static final String DONE_BTN_XPATH = "//android.widget.TextView[@text='Done']";
	
	//Login page elements
	public static final String EMAIL_INPUT_RESOURCE_ID = "com.fivemobile.thescore:id/email_input_edittext";
	public static final String PASSWORD_INPUT_RESOURCE_ID = "com.fivemobile.thescore:id/password_input_edittext";
	public static final String LOGIN_BUTTON_RESOURCE_ID = "com.fivemobile.thescore:id/login_button";
	
	//Main control
	//Dialog/popup?
	public static final String DIALOG_DISMISS_BUTTON_RESOURCE_ID = "com.fivemobile.thescore:id/dismiss_modal";
	
	//Top bar
	public static final String TOP_BAR_NAVIGATE_UP_XPATH = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
	public static final String TOP_BAR_TITLE_RESOURCE_ID = "com.fivemobile.thescore:id/titleTextView";
	//android.view.ViewGroup[@resource-id='com.fivemobile.thescore:id/toolbar']//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/titleTextView']
	
	//Bottom navigation bar on main screen
	public static final String BOTTOM_NAVIGATION_BAR_RESOURCE_ID = "com.fivemobile.thescore:id/bottom_navigation";
	public static final String BOTTOM_NAVIGATION_LEAGUES_RESOURCE_ID = "com.fivemobile.thescore:id/navigation_leagues";
	public static final String BOTTOM_NAVIGATION_NEWS_RESOURCE_ID = "com.fivemobile.thescore:id/navigation_news";
	public static final String BOTTOM_NAVIGATION_SCORES_RESOURCE_ID = "com.fivemobile.thescore:id/navigation_scores";
	public static final String BOTTOM_NAVIGATION_FAVORITES_RESOURCE_ID = "com.fivemobile.thescore:id/navigation_favorites";
	public static final String BOTTOM_NAVIGATION_BET_RESOURCE_ID = "com.fivemobile.thescore:id/navigation_discover";
	
	//Leagues page
	public static final String LEAGUES_PAGE_TITLE_RESOURCE_ID = "com.fivemobile.thescore:id/titleTextView";
	public static final String LEAGUES_PAGE_TOP_BAR_XPATH = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.fivemobile.thescore:id/recycler_view']";
	public static final String LEAGUES_PAGE_TOP_BAR_QUICK_ACCESS_XPATH(String leagueName)
	{
		return "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.TextView[contains(@text, '" + leagueName + "')]";
	}
	public static final String LEAGUES_PAGE_LIST_INDIVIDUAL_LEAGUE_XPATH(String leagueName) 
	{
		return  "//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/league_name_text' and @text='" + leagueName + "']/preceding-sibling::android.widget.ImageView[@resource-id='com.fivemobile.thescore:id/league_icon']";
	}
	public static final String LEAGUES_PAGE_TOP_BAR_INDIVIDUAL_LEAGUE_XPATH(String leagueName) 
	{
		return  "//android.widget.TextView[@resource-id ='com.fivemobile.thescore:id/league_name' and @text='" + leagueName + "']";
	}
}
