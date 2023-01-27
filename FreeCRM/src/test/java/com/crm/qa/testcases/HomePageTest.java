package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}
	
	//test cases should be seprated
	//before each test case -launch browser and login 
	//there is memory issue and browser will be creashed bcz of running 1000 test case on same browser without refreshing page
	//@test- execute test
	// after each test case -close the browser
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	//@AfterMethod
//	public void tearDown()
	//{
	//	driver.quit();
	//}
	

}
