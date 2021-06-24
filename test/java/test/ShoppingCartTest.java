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
import pages.MakeupItemsPage;
import utility.Constants;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShoppingCartTest {
	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	Actions actions = new Actions(driver);

	@Before
	public void testSetup() throws InterruptedException {
		driver.navigate().to(Constants.HOME_URL);
	}

	@Test
	public void addOneItemTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePage.ACCEPT_COOKIES_BTN)));

		HomePage.clickAllowAllCookiesButton();

		HomePage.clickMakeupNavElem();
		MakeupItemsPage.clickOnProduct();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MakeupItemsPage.ADD_TO_CART_BTN)));
		MakeupItemsPage.clickAddToCart();

		WebElement shoppingBag = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(MakeupItemsPage.SHOPPING_BAG_BTN)));
		actions.moveToElement(shoppingBag).perform();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.CART_QUANTITY_PREVIEW)));
		assertEquals("Quantity : 1", result.getText());
	}

    @Test
	public void addToWishlistTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(MakeupItemsPage.SHOPPING_BAG_BTN)));
		MakeupItemsPage.clickSBagButton();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MakeupItemsPage.WISHLIST_BTN)));
		MakeupItemsPage.clickAddToWishlist();
  
		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.POPUP_TITLE)));
		assertEquals("You need to be logged-in in order to add product to the Wishlist", result.getText());
	}

	@Test
	public void testQuantityIncrease() throws InterruptedException {

		HomePage.clickMakeupNavElem();
		MakeupItemsPage.clickOnProduct();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MakeupItemsPage.QUANTITY_BTN)));
		MakeupItemsPage.clickQuantityBtn();
		MakeupItemsPage.increaseQuantity("2 pieces");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MakeupItemsPage.ADD_TO_CART_BTN)));
		MakeupItemsPage.clickAddToCart();

		//WebElement acceptBtn = wait.until(
		//		ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[22]/div/div[10]/button[2]")));
		//acceptBtn.click();

		WebElement shoppingBag = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(MakeupItemsPage.SHOPPING_BAG_BTN)));
		actions.moveToElement(shoppingBag).perform();

		boolean result = wait.until(ExpectedConditions.textToBe(
				By.xpath(Constants.CART_QUANTITY_PREVIEW), "Quantity : 2"));
		assertEquals(true, result);
	}

	@Test
	public void removeFromShoppingBagTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(MakeupItemsPage.SHOPPING_BAG_BTN)));
		MakeupItemsPage.clickSBagButton();
		
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(MakeupItemsPage.REMOVE_FROM_BAG_BTN)));
		MakeupItemsPage.clickRemoveFromSBag();

		boolean result = wait
				.until(ExpectedConditions.textToBe(By.xpath(Constants.EMPTY_CART_MSG), "Your cart is empty"));
		assertEquals(true, result);
	}

	@Test
	public void shoppingBagButtonTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(MakeupItemsPage.EMPTY_SHOPPING_BAG)));

		MakeupItemsPage.emptyShoppingBagButton().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.EMPTY_CART_MSG)));
		assertEquals("Your cart is empty", result.getText());
	}

	@Test
	public void shoppingBagButton2Test() throws InterruptedException {

		HomePage.clickMakeupNavElem();
		MakeupItemsPage.clickSBagButton2();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.ADD_TO_CART_BTN)));
		assertEquals("ADD TO CART", result.getText());
	}
	
	@AfterClass
		public static void cleanUp() {
			Browser.getBrowser().quit();
		}
}
