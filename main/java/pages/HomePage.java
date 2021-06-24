package pages;

import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
		
	private static final String SEARCH_FIELD = "//*[@id=\"form-autocomplete\"]/div/div/span/input";
	private static final String SEARCH_BUTTON = "//*[@id=\"form-autocomplete\"]/div/span/button/i";
	private static final String LOGIN = "body > header > div > div > div.header-icons.col-sm-5.col-md-4 > div.user-container > span";
	private static final String LOGIN_BTN = "/html/body/header/div/div/div[3]/div[4]/div[2]/div[2]/button[1]";
	public static final String ACCEPT_COOKIES_BTN = "//*[@id=\"cconsent-bar\"]/div/div[2]/div/button";
	private static final String MAKEUP_NAV_ELEMENT = "//*[@id=\"navbar\"]/nav/div[2]/ul/li[4]/a/span";
	

	public static WebElement searchField() {
		return findElementByXpath(SEARCH_FIELD);
	}
	
	public static void clearSearchField() {
		searchField().clear();
	}
	
	public static void inputKeyword(String input) {
		searchField().sendKeys(input);
	}
	
	public static WebElement searchButton() {
		return findElementByXpath(SEARCH_BUTTON);
	}
	
	public static void clickSearchButton() {
		searchButton().click();
	}
	
	public static WebElement logIn() {
		return findElementByCss(LOGIN);
	}
	
	public static void clickLogIn() {
		logIn().click();
	}
	
	public static WebElement logInButton() {
		return findElementByXpath(LOGIN_BTN);
	}
	
	public static void clickLogInButton() {
		logInButton().click();
	}

	public static WebElement allowAllCookiesButton() {
		return findElementByXpath(ACCEPT_COOKIES_BTN);
	}
		
	public static void clickAllowAllCookiesButton() {
		allowAllCookiesButton().click();
	}
	
	public static WebElement makeupNavElem() {
		return findElementByXpath(MAKEUP_NAV_ELEMENT);
	}
	
	public static void clickMakeupNavElem() {
		makeupNavElem().click();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

