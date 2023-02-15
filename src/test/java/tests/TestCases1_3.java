package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class TestCases1_3 extends BaseClass {

	// TC-001 Products displayed on main page
	@Test
	public void mainPageProducts() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	// TC-002 Product clicked should be display detailed information
	@Test(dependsOnMethods = "mainPageProducts")
	public void productDetails() {
		WebElement profesionalSuit = driver
				.findElement(By.xpath("//div[@id='ec_product_image_effect_3981370']//a[@class='ec_image_link_cover']"));
		profesionalSuit.click();
	}

	// TC-003 Product details, quantity selected and currency selection
	@Test(dependsOnMethods = "productDetails")
	public void productQuantity() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,120)");
		WebElement productQty = driver.findElement(By.xpath("//input[@id='ec_quantity_29']"));
		productQty.clear();
		productQty.sendKeys("03");
	}

}
