package thescore.MobileTestFramework.generalUtilities;

public class FieldLookup {

	//Welcome page elements
	public static final String GETSTARTED_BTN_RESOURCE_ID = "com.fivemobile.thescore:id/btn_primary";
	public static final String LOG_IN_BTN_RESOURCE_ID = "com.fivemobile.thescore:id/txt_sign_in";
	
	//Login page elements
	public static final String EMAIL_INPUT_RESOURCE_ID = "com.fivemobile.thescore:id/email_input_edittext";
	public static final String PASSWORD_INPUT_RESOURCE_ID = "com.fivemobile.thescore:id/password_input_edittext";
	public static final String LOGIN_BUTTON_RESOURCE_ID = "com.fivemobile.thescore:id/login_button";
	
	//Main page
	//Dialog/popup?
	public static final String DIALOG_DISMISS_BUTTON_RESOURCE_ID = "com.fivemobile.thescore:id/dismiss_modal";
	
	//Bottom navigation bar on main screen
	public static final String BOTTOM_NAVIGATION_BAR_RESOURCE_ID = "com.fivemobile.thescore:id/bottom_navigation";
	public static final String BOTTOM_NAVIGATION_LEAGUES_RESOURCE_ID = "com.fivemobile.thescore:id/navigation_leagues";
	
	//Leagues page
	public static final String LEAGUES_PAGE_TITLE_RESOURCE_ID =  "com.fivemobile.thescore:id/titleTextView";
	public static final String LEAGUES_PAGE_LIST_INDIVIDUAL_LEAGUE_XPATH(String leagueName) {
		return  "//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/league_name_text' and @text='" + leagueName + "']/preceding-sibling::android.widget.ImageView[@resource-id='com.fivemobile.thescore:id/toggle_pin_btn']";
	}
	public static final String LEAGUES_PAGE_TOP_BAR_INDIVIDUAL_LEAGUE_XPATH(String leagueName) {
		return  "//android.widget.TextView[@resource-id ='com.fivemobile.thescore:id/league_name' and @text='" + leagueName + "']";
	}
}
