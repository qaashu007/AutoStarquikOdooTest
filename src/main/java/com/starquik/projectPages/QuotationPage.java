package com.starquik.projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.starquik.pageObject.QuotationPageObject;
import com.starquik.pages.BaseClass;
import com.starquik.pages.ILogLevel;

public class QuotationPage extends BaseClass{

	public QuotationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isQuotationPageOpen() {
		waitForElementDisplayed(By.xpath(QuotationPageObject.QuotationPageText_Xpath));
		boolean QuotationTitle = isElementPresent(By.xpath(QuotationPageObject.QuotationPageText_Xpath));
		if(QuotationTitle) {
			return true;
		}return false;
	}

	public void clickCreateButton() {
		waitForElementDisplayed(By.xpath(QuotationPageObject.createButton_Xpath));
		click(By.xpath(QuotationPageObject.createButton_Xpath));
		log("Click on [Create] button", ILogLevel.METHOD);
	}

	public boolean isCreateSaleOrderPageOpen() {
		waitForElementDisplayed(By.xpath(QuotationPageObject.newText_Xpath));
		boolean sale_order_form = isElementPresent(By.xpath(QuotationPageObject.newText_Xpath));
		if(sale_order_form) {
			return true;
		}return false;
	}

	public void enterCustomerName(String _customer) {
		waitForElementDisplayed(By.xpath(QuotationPageObject.customerNameText_xpath));
		sendKeys(By.xpath(QuotationPageObject.customerNameText_xpath), _customer);
        log("Enter the [Customer Name]", ILogLevel.METHOD);
	}
	
	public void enterDeliveryDate() {
		pause(3);
		waitForElementDisplayed(By.xpath(QuotationPageObject.deliveryDatefield_xpath));
		click(By.xpath(QuotationPageObject.deliveryDatefield_xpath));
		log("Enter [Delivery Date]", ILogLevel.METHOD);
	}
	
	public void clickAddItemLink() {
		waitForElementDisplayed(By.linkText(QuotationPageObject.addItem_LinkText));
		click(By.linkText(QuotationPageObject.addItem_LinkText));
		log("Click on [Add an item] link", ILogLevel.METHOD);
		pause(4);
	}
	public void enterItemName(String _item) {
		waitForElementDisplayed(By.xpath(QuotationPageObject.itemInput_Xpath));
		sendKeys(By.xpath(QuotationPageObject.itemInput_Xpath), _item);
		log("Enter the [Item]", ILogLevel.METHOD);
	}
	
	public void clickOtherInfoTab() {
		pause(2);
		waitForElementDisplayed(By.xpath(QuotationPageObject.otherInfoTab_Xpath));
		click(By.xpath(QuotationPageObject.otherInfoTab_Xpath));
		log("click on [Other Information] tab", ILogLevel.METHOD);
	}


}
