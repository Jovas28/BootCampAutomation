package tests;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import base.BaseClass;

public class FilterByPrice extends BaseClass {
	final private String _productXpath = "//*[@id=\"ec_product_image_effect_dnk-yellow-shoes\"]/a";
	final private String _filterXpath = "//*[contains(@href, 'pricepoint=4')]";
	@Test
	public void TC11() {
		WebElement product = driver.findElement(By.xpath(_productXpath));
		product.click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		
		WebElement filter = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(_filterXpath));
			}
		});
		
		filter.click();
	}
}
