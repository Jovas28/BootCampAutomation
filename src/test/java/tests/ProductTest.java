package tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseClass;

public class ProductTest extends BaseClass {
	
	final private String _productXpath = "//*[@id=\"ec_product_image_effect_dnk-yellow-shoes\"]/a";
	final private String _addCarBtnXpath = "//*[@id=\"post-1675\"]/div/section/div[1]/div[3]/form/div[8]/div[2]/input";
	final private String _hotItemXpath = "//*[@id=\"ec_image_product_widget_anchor-bracelet_1_0\"]/img";
	final private String _sortFiledName = "sortfield";
	final private String _inputSearchProductName = "ec_search";
	final private String _productToSearch = "TSHIRT";
	final private String _searchProductBtnXpath = "form:nth-child(1) > input:nth-child(3)";
	final private String _paginateBtnXpath = "//a[@class='what-we-offer-pagination-link']";
	
	@Test (description="Products displayed on main page", priority=1)
	public void TC01() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	@Test (description="Product clicked should be display detailed information", dependsOnMethods = "TC01", priority=2)
	public void TC02() {
		WebElement profesionalSuit = driver.findElement(By.xpath(_productXpath));
		profesionalSuit.click();
	}

	@Test (description="Product details, quantity selected and currency selection", dependsOnMethods = "TC02", priority=3)
	public void TC03() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,120)");
		WebElement productQty = driver.findElement(By.xpath("//input[@id='ec_quantity_29']"));
		productQty.clear();
		productQty.sendKeys("03");
	}
	
	@Test(description="Validate that the user is able to add a product to the Car", priority=4)
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
	
	 @Test (description="Validate that the user is able to search a product", priority=5)
    public void TC06() {
        try {
        	driver.get(pageUrl);
			Thread.sleep(2500);
			driver.findElement(By.cssSelector(_productXpath)).click();
			Thread.sleep(2500);
			driver.findElement(By.name(_inputSearchProductName)).click();
			Thread.sleep(2500);
			driver.findElement(By.name(_inputSearchProductName)).sendKeys(_productToSearch);
			Thread.sleep(2500);
			driver.findElement(By.cssSelector(_searchProductBtnXpath)).click();
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test (description="Validate that the user is able to see a hot item", priority=6)
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
	
	@Test(description="validate if the user is able to sort products by a filter", priority=7)
	public void TC08() {
		try {
			driver.get(pageUrl);
			Thread.sleep(2500);
			Select sortSel = new Select(driver.findElement(By.name(_sortFiledName)));
			Random r = new Random(); // Random lib to pick a filter
			int product = r.nextInt(7 - 1) + 1;// Products del 1 al 7
			sortSel.selectByIndex(product);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TC-09 
    @Test (description="Pagination table shows elements")
    public void TC09() {
        try {
        	WebElement paginationTable = driver.findElement(By.xpath(_paginateBtnXpath));
            paginationTable.click();
            Thread.sleep(500);
            WebElement errorMessage = driver.findElement(By.xpath("//*[@class=\"academy-bug-overlay\"]"));
            if(errorMessage != null) {
            	throw new Error("SI EXISTE ERROR");  
            }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
