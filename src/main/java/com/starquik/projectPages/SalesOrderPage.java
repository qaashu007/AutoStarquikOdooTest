package com.starquik.projectPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.starquik.pageObject.SalesOrderPageObject;
import com.starquik.pages.BaseClass;
import com.starquik.pages.ILogLevel;

public class SalesOrderPage extends BaseClass {

	public SalesOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSalesPageOpen() {
		waitForElementDisplayed(By.xpath(SalesOrderPageObject.salesPageText_Xpath));
		boolean SalesTitle = isElementPresent(By.xpath(SalesOrderPageObject.salesPageText_Xpath));
		if(SalesTitle) {
			return true;
		}
		return false;
		
	}
	
	public void clickSalesDropDown() {
		waitForElementDisplayed(By.xpath(SalesOrderPageObject.SalesDropdown_Xpath));
		click(By.xpath(SalesOrderPageObject.SalesDropdown_Xpath));
		log("Click on [Sales] dropdown", ILogLevel.METHOD);
	}
	
	public void SelectSalesOption(String _option) {
		waitForElementDisplayed(By.xpath("//a[@data-menu-name='"+_option+"']"));
		driver.findElement(By.xpath("//a[@data-menu-name='"+_option+"']")).click();
		log("Click on ["+_option+"] option", ILogLevel.METHOD);
	}

}
