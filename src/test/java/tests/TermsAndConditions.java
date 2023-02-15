package tests;
import base.BaseClass;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TermsAndConditions extends BaseClass{
	
	@Test
	public void TC07() {
		 driver.findElement(By.linkText("Terms & Conditions")).click();
	}
}
