package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import browser.Browser;
import pages.HomePage;
import pages.LogInPage;
import utility.Constants;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LogInTest {
	
	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 50);
	Actions actions = new Actions(driver);
	
	@Before
	public void testSetup() throws InterruptedException {
		driver.get(Constants.HOME_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void logInUsingInvalidCredentialsTest() throws InterruptedException {
		
		HomePage.clickLogIn();
		HomePage.clickLogInButton();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(LogInPage.USERNAME)));
		LogInPage.inputUsername("marijanagol@gmail.com");
		LogInPage.inputPassword("M1234567");
		LogInPage.clickSubmit();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(Constants.USER_NOT_FOUND_TXT)));
		assertEquals("Username not found", result.getText());

	}

	@Test
	public void logInUsingInvalidPasswordTest() throws InterruptedException {

		HomePage.clickLogIn();
		HomePage.clickLogInButton();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(LogInPage.USERNAME)));
		LogInPage.inputUsername("marijanagolubovic7@gmail.com");
		LogInPage.inputPassword("M1234567");
		LogInPage.clickSubmit();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(Constants.INVALID_PASSW_TXT)));
		assertEquals("Invalid password", result.getText());
	}

	@Test
	public void logInUsingInvalidEmailTest() throws InterruptedException {

		HomePage.clickLogIn();
		HomePage.clickLogInButton();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(LogInPage.USERNAME)));
		LogInPage.inputUsername("marijanagol@gmail.com");
		LogInPage.inputPassword("M12345g");
		LogInPage.clickSubmit();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(Constants.USER_NOT_FOUND_TXT)));
		assertEquals("Username not found", result.getText());
	}

	@Test
	public void emptyUsernAndPassFieldTest() throws InterruptedException {

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(HomePage.ACCEPT_COOKIES_BTN)));

		HomePage.clickAllowAllCookiesButton();
		HomePage.clickLogIn();
		HomePage.clickLogInButton();

		WebElement submitButton = LogInPage.submitButton();
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		LogInPage.clickSubmit();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.LOGIN_WINDOW_TITLE)));
		assertEquals("Log in", result.getText());
	}

	@Test
	public void forgotenPasswordLinkTest() throws InterruptedException {

		HomePage.clickLogIn();
		HomePage.clickLogInButton();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(LogInPage.FORGOTEN_PASSW)));
		LogInPage.clickForgotenPassw();

		WebElement result = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.FORGOTEN_PASSW_HEADING)));
		assertEquals("FORGOTEN PASSWORD", result.getText());
	}

	@Test
	public void registerLinkTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		HomePage.clickLogIn();
		HomePage.clickLogInButton();
		LogInPage.clickRegisterLink();

		WebElement result = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.REGISTER_TITLE)));
		assertEquals("Register", result.getText());
	}

	@Test
	public void validCredentialsLogInTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		HomePage.clickLogIn();
		HomePage.clickLogInButton();

		WebElement usernameField = LogInPage.usernameField();
		wait.until(ExpectedConditions.elementToBeClickable(usernameField));

		LogInPage.inputUsername("marijanagolubovic7@gmail.com");
		LogInPage.inputPassword("M12345g");
		LogInPage.clickSubmit(); 
		
		boolean result = wait.until(
				ExpectedConditions.textToBe(By.xpath(Constants.USER_NAME_TXT), "Marijana"));
		assertEquals(true, result);
	}
	
	@AfterClass
		public static void cleanUp() {
			Browser.getBrowser().quit();
		}
}




