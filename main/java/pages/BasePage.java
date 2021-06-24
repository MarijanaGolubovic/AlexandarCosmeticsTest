package pages;

import org.openqa.selenium.WebElement;


import browser.Browser;

public class BasePage {


	public static WebElement findElementByXpath(String xpath) {
		return Browser.getBrowser().findElementByXPath(xpath);
	}
	public static WebElement findElementByCss(String selector) {
		return Browser.getBrowser().findElementByCssSelector(selector);
	}
	
	public static WebElement findElementByLinkText(String text) {
		return Browser.getBrowser().findElementByLinkText(text);
	}
}
