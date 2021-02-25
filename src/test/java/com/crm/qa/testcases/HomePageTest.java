package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void VerifyUserName() {
		testUtil.SwitchFrame();
		Assert.assertTrue(homePage.ValidateLoggedInUser());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
