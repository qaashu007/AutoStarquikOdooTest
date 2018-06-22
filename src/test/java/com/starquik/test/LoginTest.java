package com.starquik.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.starquik.pages.TestCore;
import com.starquik.projectPages.DashboardPage;
import com.starquik.projectPages.LoginPage;

public class LoginTest extends TestCore{
	
	@Test(priority = 0)
	public void testLogin() {
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashbordPage = new DashboardPage(driver);
		
		loginPage.enterEmail(config.getProperty("usr_email"));
		loginPage.enterPassword(config.getProperty("usr_pwd"));
		loginPage.clickLoginButton();
		Assert.assertTrue("Loggedin page verification is failed", dashbordPage.isLoggedinPageOpen());
	}
	

}
