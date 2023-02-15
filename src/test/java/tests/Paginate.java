package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class Paginate extends BaseClass{
	//TC-09 Pagination table shows elements
    @Test
    public void TC09()
    {
        WebElement paginationTable = driver.findElement(By.xpath("//a[@class='what-we-offer-pagination-link']"));
        paginationTable.click();
    }
}
