package com.starquik.projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.starquik.pageObject.DashboardPageObject;
import com.starquik.pages.BaseClass;
import com.starquik.pages.ILogLevel;

public class DashboardPage extends BaseClass{

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isLoggedinPageOpen() {
		waitForElementDisplayed(By.xpath(DashboardPageObject.headerText_Xpath));
		boolean loggedinText = isElementPresent(By.xpath(DashboardPageObject.headerText_Xpath));
		if(loggedinText) {
			return true;
		}return false;
	}
	
	public void clickMenuButton() {
		pause(2);
		waitForElementDisplayed(By.xpath(DashboardPageObject.menuIcon_Xpath));
		click(By.xpath(DashboardPageObject.menuIcon_Xpath));
		log("click on [menu] icon", ILogLevel.METHOD);
	}
	
	public void clickSalesIcon() {
		pause(3);
		waitForElementDisplayed(By.xpath(DashboardPageObject.salesIcon_Xpath));
		click(By.xpath(DashboardPageObject.salesIcon_Xpath));
		log("click on [Sales] icon", ILogLevel.METHOD);
	}
	
	
	
	

}
