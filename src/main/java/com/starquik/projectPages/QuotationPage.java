package com.starquik.projectPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		pause(8);
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
		pause(2);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//waitForElementDisplayed(By.xpath(QuotationPageObject.customerNameText_xpath));
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
		pause(1);
		Boolean addItemLinkPresent = isElementPresent(By.linkText(QuotationPageObject.addItem_LinkText));
		
		if(!addItemLinkPresent) {
			waitForElementDisplayed(By.xpath(QuotationPageObject.orderLineTab_Xpath));
			click(By.xpath(QuotationPageObject.orderLineTab_Xpath));
			log("click on [Order Line] tab", ILogLevel.METHOD);

			waitForElementDisplayed(By.linkText(QuotationPageObject.addItem_LinkText));
			click(By.linkText(QuotationPageObject.addItem_LinkText));
			log("Click on [Add an item] link", ILogLevel.METHOD);
			pause(4);
		}
		else {
			waitForElementDisplayed(By.linkText(QuotationPageObject.addItem_LinkText));
			click(By.linkText(QuotationPageObject.addItem_LinkText));
			log("Click on [Add an item] link", ILogLevel.METHOD);
			pause(4);
		}

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
	public void scrollDown() {
		pause(2);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(250,450)", "");
	}
	public void enterWarehouse(String _warehouse) {
		waitForElementDisplayed(By.xpath("//input[starts-with(@id,'o_field_input_64')]"));
		click(By.xpath("//input[starts-with(@id,'o_field_input_64')]"));
		pause(1);

		driver.findElement(By.xpath("//input[starts-with(@id,'o_field_input_64')]")).clear();
		sendKeys(By.xpath("//input[starts-with(@id,'o_field_input_64')]"), _warehouse);
		log("enter the [Warehouse]", ILogLevel.METHOD);
		pause(1);
	}
	public void clickActivateDeliveryCheckbox() {
		waitForElementDisplayed(By.name(QuotationPageObject.activateDeliveryCheckbox_Name));
		click(By.name(QuotationPageObject.activateDeliveryCheckbox_Name));
		log("Click on [Activate Delivery] checkbox", ILogLevel.METHOD);
	}
	public void enterCustomerReferenceNumber(String _randomNumber) {
		waitForElementDisplayed(By.xpath(QuotationPageObject.customerRefnoTextField_Xpath));
		List<WebElement> elementsList = driver.findElements(By.xpath(QuotationPageObject.customerRefnoTextField_Xpath));
		elementsList.get(1).sendKeys(_randomNumber);
		log("enter the [Customer Reference No.]", ILogLevel.METHOD);
	}
	public void selectDeliverySlot(String _slot) {
		waitForElementDisplayed(By.id(QuotationPageObject.deliverySlot_Id));
		//sendKeys(By.id(QuotationPageObject.deliverySlot_Id), _slot);
		click(By.id(QuotationPageObject.deliverySlot_Id));  //ui-menu-item   [D3] 12 PM-02 PM
		click(By.linkText(""+_slot+""));
		log("Select [Delivery Slot]", ILogLevel.METHOD);
	}
	public void clickSaveButton() {
		waitForElementDisplayed(By.cssSelector(QuotationPageObject.SaveButton_Css));
		click(By.cssSelector(QuotationPageObject.SaveButton_Css));
		log("Click on [Save] button", ILogLevel.METHOD);
	}
	public void clickQuotationLink() {
		pause(3);
		waitForElementDisplayed(By.linkText("Quotations"));
		click(By.linkText("Quotations"));
		log("click on [Quotations] link", ILogLevel.METHOD);
	}
	public boolean verifyCreatedOrder(String _randomNumber) {
		waitForElementDisplayed(By.xpath("//td[@data-field='client_order_ref']"));
		String actualOrderNumber= driver.findElement(By.xpath("//td[@data-field='client_order_ref']")).getText();
		String expectedOrderNumber= _randomNumber;
		if(actualOrderNumber.equals(expectedOrderNumber)) {
			return true;
		}return false;

	}


}
