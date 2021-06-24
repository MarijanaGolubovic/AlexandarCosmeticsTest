package pages;

import org.openqa.selenium.WebElement;

public class LogInPage extends BasePage {

	public static final String USERNAME = "//input[@id='username']";
	private static final String PASSWORD = "//input[@id='password']";
	private static final String SUBMIT_BTN = "#_submit";
	public static final String FORGOTEN_PASSW = "//*[@id=\"login-modal\"]/div/div/div[4]/form/div[1]/div[1]/a";
	public static final String REGISTER_LINK = "#login-register-button";
	
	public static WebElement usernameField(){
		return findElementByXpath(USERNAME);
	}
	
	public static void inputUsername(String input){
		usernameField().clear();
		usernameField().sendKeys(input);		
	}

	public static WebElement passwordField(){
		return findElementByXpath(PASSWORD);
	}
	
	public static void inputPassword(String input){
		passwordField().clear();
		passwordField().sendKeys(input);		
	}

	public static WebElement submitButton(){
		return findElementByCss(SUBMIT_BTN);
	}
	
	public static void clickSubmit() {
		submitButton().click();;		
	}

	public static WebElement forgotenPasswordLink(){
		return findElementByXpath(FORGOTEN_PASSW);
	}
	
	public static void clickForgotenPassw(){
		forgotenPasswordLink().click();		
	}

	public static WebElement registerLink(){
		return findElementByCss(REGISTER_LINK);
	}
	
	public static void clickRegisterLink(){
		registerLink().click();		
	}
}
