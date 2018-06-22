package com.starquik.projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.starquik.pageObject.LoginPageObject;
import com.starquik.pages.BaseClass;
import com.starquik.pages.ILogLevel;
import com.starquik.pages.TestCore;

public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver) {
		super(driver);
		waitForElementDisplayed(By.id(LoginPageObject.emailField_Id));
	}
	
	public void enterEmail(String _email) {
		waitForElementDisplayed(By.id(LoginPageObject.emailField_Id));
		sendKeys(By.id(LoginPageObject.emailField_Id), _email);
		log("Enter [Email]", ILogLevel.METHOD);
		
	}
	
	public void enterPassword(String _pwd) {
		waitForElementDisplayed(By.id(LoginPageObject.pwdField_id));
		sendKeys(By.id(LoginPageObject.pwdField_id), _pwd);
		log("Enter [Password]", ILogLevel.METHOD);
	}
	
	public void clickLoginButton() {
		click(By.xpath(LoginPageObject.loginButton_Xpath));
		log("Click [Login] button", ILogLevel.METHOD);
	}

}
