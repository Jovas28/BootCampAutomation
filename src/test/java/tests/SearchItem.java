package tests;

import base.BaseClass;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchItem extends BaseClass {
    @Test
    public void RunTC06() {
        try {
			Thread.sleep(2500);
			driver.findElement(By.cssSelector("#ec_product_image_effect_dnk-yellow-shoes > .ec_image_link_cover")).click();
			Thread.sleep(2500);
			driver.findElement(By.name("ec_search")).click();
			Thread.sleep(2500);
			driver.findElement(By.name("ec_search")).sendKeys("TSHIRT");
			Thread.sleep(2500);
			driver.findElement(By.cssSelector("form:nth-child(1) > input:nth-child(3)")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //driver.get("https://academybugs.com/find-bugs/");
    //driver.manage().window().setSize(new Dimension(1936, 1048));
}
