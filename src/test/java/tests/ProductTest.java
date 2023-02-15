package tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseClass;

public class ProductTest extends BaseClass {
	
	final private String _productXpath = "//*[@id=\"ec_product_image_effect_dnk-yellow-shoes\"]/a";
	final private String _addCarBtnXpath = "//*[@id=\"post-1675\"]/div/section/div[1]/div[3]/form/div[8]/div[2]/input";
	final private String _hotItemXpath = "//*[@id=\"ec_image_product_widget_anchor-bracelet_1_0\"]/img";
	
	@Test(description="Validate that the user is able to add a product to the Car", priority=1)
	public void TC05() {
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
	
	 @Test (description="Validate that the user is able to search a product", priority=2)
    public void TC06() {
        try {
        	driver.get(pageUrl);
			Thread.sleep(2500);
			driver.findElement(By.cssSelector("#ec_product_image_effect_dnk-yellow-shoes > .ec_image_link_cover")).click();
			Thread.sleep(2500);
			driver.findElement(By.name("ec_search")).click();
			Thread.sleep(2500);
			driver.findElement(By.name("ec_search")).sendKeys("TSHIRT");
			Thread.sleep(2500);
			driver.findElement(By.cssSelector("form:nth-child(1) > input:nth-child(3)")).click();
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test (description="Validate that the user is able to see a hot item", priority=3)
	public void TC10_1() {
		try {
			driver.get(pageUrl);
			Thread.sleep(2500);
			WebElement product = driver.findElement(By.xpath(_productXpath));
			product.click();
			Thread.sleep(3500);
			WebElement hotItem = driver.findElement(By.xpath(_hotItemXpath));
			hotItem.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(description="validate if the user is able to sort products by a filter", priority=4)
	public void TC08() {
		Select sortSel = new Select(driver.findElement(By.name("sortfield")));
		Random r = new Random(); // Random lib to pick a filter
		int product = r.nextInt(7 - 1) + 1;// Products del 1 al 7
		sortSel.selectByIndex(product);
	}
}
