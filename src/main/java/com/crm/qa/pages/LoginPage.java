package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
  //PageFactory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn ;
	 
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn ;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')][contains(@src,'logo')]")
	WebElement crmlogo ;
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
	username.sendKeys(un);	
	password.sendKeys(pwd);
	loginBtn.click();
	
	return new HomePage();
	}
}







