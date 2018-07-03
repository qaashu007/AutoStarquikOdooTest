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
	String randomNumber = AutogenerateNumber(8);

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
		log("Enter the [Item] name", ILogLevel.METHOD);
		pause(2);
		click(By.xpath(QuotationPageObject.saleOrderWeight_Xpath));
		log("Click outside to add item",ILogLevel.METHOD);	
	}
	public void clickQuantityConfirmDialogue() {
		waitForElementDisplayed(By.cssSelector(QuotationPageObject.okButtonDialogue_Css));
		click(By.cssSelector(QuotationPageObject.okButtonDialogue_Css));
		log("Accept confirm dialogue", ILogLevel.METHOD);
	}
	public void clickOtherInfoTab() {
		waitForElementDisplayed(By.xpath(QuotationPageObject.otherInfoTab_Xpath));
		click(By.xpath(QuotationPageObject.otherInfoTab_Xpath));
		log("click on [Other Information] tab", ILogLevel.METHOD);
	}
	public void enterWarehouse(String _warehouse) {
		waitForElementDisplayed(By.xpath(QuotationPageObject.warehouseTextfield_Xpath));
		driver.findElement(By.xpath(QuotationPageObject.warehouseTextfield_Xpath)).clear();
		sendKeys(By.xpath(QuotationPageObject.warehouseTextfield_Xpath), _warehouse);
		log("enter the [Warehouse]", ILogLevel.METHOD);
		pause(2);
	}
	public void clickActivateDeliveryCheckbox() {
		waitForElementDisplayed(By.id(QuotationPageObject.activateDeliveryCheckbox_Id));
		click(By.id(QuotationPageObject.activateDeliveryCheckbox_Id));
		log("Click on [Activate Delivery] checkbox", ILogLevel.METHOD);
	}
	public void enterCustomerReferenceNumber() {
		waitForElementDisplayed(By.id(QuotationPageObject.customerRefnoTextField_Id));
		sendKeys(By.id(QuotationPageObject.customerRefnoTextField_Id), randomNumber);
		log("enter the [Customer Reference No.]", ILogLevel.METHOD);
	}
	public void selectDeliverySlot(String _slot) {
		waitForElementDisplayed(By.id(QuotationPageObject.deliverySlot_Id));
		sendKeys(By.id(QuotationPageObject.deliverySlot_Id), _slot);
		log("Select [Delivery Slot]", ILogLevel.METHOD);
	}
	public void clickSaveButton() {
		waitForElementDisplayed(By.id(QuotationPageObject.SaveButton_Xpath));
		click(By.id(QuotationPageObject.SaveButton_Xpath));
		log("Click on [Save] button", ILogLevel.METHOD);
	}


}
