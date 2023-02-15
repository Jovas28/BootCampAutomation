package tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseClass;

public class SortProducts extends BaseClass {
	/**
	 * Test case 8
	 */
	@Test
	public void run() {
		Select sortSel = new Select(driver.findElement(By.name("sortfield")));
		Random r = new Random(); // Random lib to pick a filter
		int product = r.nextInt(7 - 1) + 1;// Products del 1 al 7
		sortSel.selectByIndex(product);
		
	}
}
