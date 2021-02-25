package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.SwitchFrame();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
	Object data[][] = TestUtil.getTestData(sheetName);	
	return data;
	}
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void ValidateCreateNewContact(String title, String firstName, String lastName, String company) {		
		homePage.ClickOnNewContact();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
