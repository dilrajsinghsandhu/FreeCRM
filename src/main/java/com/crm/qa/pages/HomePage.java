package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	@CacheLookup
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactslink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean ValidateLoggedInUser() {
		return usernameLabel.isDisplayed();
	}	
	
	public void ClickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newcontactslink.click();		
	}
} 
