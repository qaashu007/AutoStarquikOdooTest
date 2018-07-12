package com.starquik.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.starquik.pages.TestCore;
import com.starquik.projectPages.DashboardPage;
import com.starquik.projectPages.LoginPage;
import com.starquik.projectPages.QuotationPage;
import com.starquik.projectPages.SalesOrderPage;

public class CreateSaleOrderTest extends TestCore{
	
	@Test(priority = 0)
	public void testCreateSaleOrder() {
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashbordPage = new DashboardPage(driver);
		SalesOrderPage saleOrderPage = new SalesOrderPage(driver);
		QuotationPage quotationPage = new QuotationPage(driver);
		
		loginPage.enterEmail(config.getProperty("usr_email"));
		loginPage.enterPassword(config.getProperty("usr_pwd"));
		loginPage.clickLoginButton();
		Assert.assertTrue("Loggedin page verification is failed", dashbordPage.isLoggedinPageOpen());
		
		dashbordPage.clickMenuButton();
		dashbordPage.clickSalesIcon();
	    Assert.assertTrue("Sale Order page isn't open yet", saleOrderPage.isSalesPageOpen());
	    
	    saleOrderPage.clickSalesDropDown();
	    saleOrderPage.SelectSalesOption("Quotations");
	    Assert.assertTrue("Quotation page isn't open yet", quotationPage.isQuotationPageOpen());
	    
	    quotationPage.clickCreateButton();
	    Assert.assertTrue("Create Sale Order page isn't open yet", quotationPage.isCreateSaleOrderPageOpen());
	    
	    quotationPage.enterCustomerName(config.getProperty("cust_name"));
	    quotationPage.enterDeliveryDate();
	    quotationPage.clickAddItemLink();
	    quotationPage.enterItemName(config.getProperty("item_name"));
	    quotationPage.clickQuantityConfirmDialogue();
	    quotationPage.clickOtherInfoTab();
	    quotationPage.scrollDown();
	    quotationPage.enterWarehouse(config.getProperty("warehouse"));
	    quotationPage.clickActivateDeliveryCheckbox();
	    quotationPage.enterCustomerReferenceNumber();
	    quotationPage.selectDeliverySlot(config.getProperty("delivery_slot"));
	    quotationPage.clickSaveButton();
	    
		
	}

}
