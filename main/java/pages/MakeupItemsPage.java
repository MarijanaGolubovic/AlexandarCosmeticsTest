package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MakeupItemsPage extends BasePage{
	
	private static final String PRODUCT_XPATH = "//body/main[@id='main-content']/div[1]/div[3]/form[1]/div[6]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]";
	public static final String QUANTITY_BTN = "//*[@id=\"product-detail-page-content\"]/div/div[2]/div[3]/div[3]/div[2]/div[1]/div/select";
	public static final String ADD_TO_CART_BTN = "//*[@id=\"product-detail-page-content\"]/div/div[2]/div[3]/div[3]/div[2]/div[2]/button";
	public static final String SHOPPING_BAG_BTN = "/html/body/header/div/div/div[3]/div[3]/div/a/span";
	public static final String EMPTY_SHOPPING_BAG = "/html/body/header/div/div/div[3]/div[3]/div/a/i";
	public static final String REMOVE_FROM_BAG_BTN = "//*[@id=\"cart_item_remove_btn_58c89a97-0b99-4a9e-a064-9c21dfe7758e\"]";
	public static final String WISHLIST_BTN = "//*[@id=\"cart_item_table_row_58c89a97-0b99-4a9e-a064-9c21dfe7758e\"]/div[8]/div/button/span";
	private static final String SHOPPING_BAG_BTN2 = "//*[@id=\"58c89a97-0b99-4a9e-a064-9c21dfe7758e\"]/i"; 
	
	public static WebElement productElem(){
		return findElementByXpath(PRODUCT_XPATH);
	}
	
	public static void clickOnProduct(){
		productElem().click();
	}
	
	public static WebElement quantityButton(){
		return findElementByXpath(QUANTITY_BTN);
	}
	
	public static void clickQuantityBtn(){
		quantityButton().click();
	}
	
	public static void increaseQuantity(String option){
		Select se = new Select(findElementByXpath(QUANTITY_BTN));
		se.selectByVisibleText(option);
	}
	
	
	public static WebElement addToCartButton(){
		return findElementByXpath(ADD_TO_CART_BTN);
	}
	
	public static void clickAddToCart(){
		addToCartButton().click();
	}
	
	public static WebElement shoppingBagButton(){
		return findElementByXpath(SHOPPING_BAG_BTN); 
	}
	
	public static void clickSBagButton(){
		shoppingBagButton().click();
	}
	
	public static WebElement emptyShoppingBagButton(){
		return findElementByXpath(EMPTY_SHOPPING_BAG); 
	}
	
	public static WebElement removeFromSBagButton(){
		return findElementByXpath(REMOVE_FROM_BAG_BTN); 
	}  
	
	public static void clickRemoveFromSBag(){
		removeFromSBagButton().click();
	}
	
	public static WebElement addToWishlistButton(){
		return findElementByXpath(WISHLIST_BTN);
	}
	
	public static void clickAddToWishlist(){
		addToWishlistButton().click();
	}
		
	public static WebElement shoppingBagButton2(){
		return findElementByXpath(SHOPPING_BAG_BTN2);
	}
	
	public static void clickSBagButton2(){
		shoppingBagButton2().click();
	}

}
