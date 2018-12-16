package com.starquik.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.starquik.pages.ILogLevel;
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


		for(int i=1;i<=2;i++) {
			log("=========Creating Sale Order ["+i+"] for ["+config.getProperty("warehouse")+"]=========",ILogLevel.TEST);

			quotationPage.clickCreateButton();
			Assert.assertTrue("Create Sale Order page isn't open yet", quotationPage.isCreateSaleOrderPageOpen());

			quotationPage.enterCustomerName(config.getProperty("cust_name"));
			quotationPage.enterDeliveryDate();
			String items = config.getProperty("item_name");
			String[] splitItems = items.split(", ");
			for (int j=0; j < splitItems.length; j++)
			{
				quotationPage.clickAddItemLink();
				quotationPage.enterItemName(splitItems[j]);
				quotationPage.clickQuantityConfirmDialogue();
			}
			
			quotationPage.clickOtherInfoTab();
			quotationPage.enterWarehouse(config.getProperty("warehouse"));
			quotationPage.clickActivateDeliveryCheckbox();

			String randomNumber = RandomStringUtils.randomNumeric(8);

			quotationPage.enterCustomerReferenceNumber(randomNumber);
			quotationPage.selectDeliverySlot(config.getProperty("delivery_slot"));
			quotationPage.clickSaveButton();
			quotationPage.clickQuotationLink();
			Assert.assertTrue("Sale Order is not created successfully", quotationPage.verifyCreatedOrder(randomNumber));
		}

	}

}
