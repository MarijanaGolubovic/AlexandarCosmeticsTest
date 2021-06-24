package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Browser;
import pages.HomePage;
import utility.Constants;

public class SearchTest {
	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 30);

	@Before
	public void searchFieldClear() {
		driver.get(Constants.HOME_URL);
		HomePage.clearSearchField();
	}
	
	@Test
	public void emptySearchFieldTest() throws InterruptedException {

		HomePage.clickSearchButton();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.PRODUCTS_FOUND)));
		assertNotEquals("0", result.getText());
	}

	@Test
	public void searchUsingLowerCaseOnlyTest() throws InterruptedException {

		HomePage.inputKeyword("lipstick");
		HomePage.clickSearchButton();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.PRODUCTS_FOUND)));
		assertNotEquals("0", result.getText());
	}

	@Test
	public void searchUsingUppAndLowCaseTest() throws InterruptedException {

		HomePage.inputKeyword("LipsticK");
		HomePage.clickSearchButton();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.PRODUCTS_FOUND)));
		assertNotEquals("0", result.getText());
	}

	@Test
	public void searchUsingNumbersTest() throws InterruptedException {

		WebElement allowCookiesButton = HomePage.allowAllCookiesButton();
		wait.until(ExpectedConditions.elementToBeClickable(allowCookiesButton));

		HomePage.clickAllowAllCookiesButton();

		HomePage.inputKeyword("98765");

		HomePage.clickSearchButton();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.NO_RESULTS_TXT)));
		assertEquals("Unable to find product. Please change one of the specified conditions.", result.getText());
	}

	@Test
	public void searchUsingSpaceBeforeKeywordTest() throws InterruptedException {

		HomePage.inputKeyword("   lipstick");
		HomePage.clickSearchButton();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.PRODUCTS_FOUND)));
		assertNotEquals("0", result.getText());
	}

	@Test
	public void searchUsingSpecCharTest() throws InterruptedException {

		HomePage.inputKeyword(".,&>");
		HomePage.clickSearchButton();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.NO_RESULTS_TXT)));
		assertEquals("Unable to find product. Please change one of the specified conditions.", result.getText());
	}
	
	@AfterClass
		public static void cleanUp() {
			Browser.getBrowser().quit();
		}
}
