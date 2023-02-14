package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class ProductTest extends BaseClass {
	final private String _productXpath = "//*[@id=\"ec_product_image_effect_dnk-yellow-shoes\"]/a";
	final private String _addCarBtnXpath = "//*[@id=\"post-1675\"]/div/section/div[1]/div[3]/form/div[8]/div[2]/input";
	final private String _hotItemXpath = "//*[@id=\"ec_image_product_widget_anchor-bracelet_1_0\"]/img";
	@Test
	public void addProductCar() {
		try {
			driver.manage().window().maximize();
			Thread.sleep(2500);
			WebElement product = driver.findElement(By.xpath(_productXpath));
			product.click();
			WebElement addCarBtn = driver.findElement(By.xpath(_addCarBtnXpath));
			Thread.sleep(1500);
			addCarBtn.click();
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testkHotItem() {
		try {
			driver.get(pageUrl);
			Thread.sleep(2500);
			WebElement product = driver.findElement(By.xpath(_productXpath));
			product.click();
			Thread.sleep(2500);
			WebElement hotItem = driver.findElement(By.xpath(_hotItemXpath));
			hotItem.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
