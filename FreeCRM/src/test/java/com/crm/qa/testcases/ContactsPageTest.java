package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void selectContactsTest()
	{
		contactsPage.selectContacts("Maharsh patel");
	}
	
	@Test(priority=3)
	public void multipleContactsTest()
	{
		contactsPage.selectContacts("test1 test2");
		contactsPage.selectContacts("yashvi patel");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4 , dataProvider = "getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstName, String lastName, String company)
	{
		homePage.clickOnNewContact();
		contactsPage.createNewContact(title,firstName,lastName,company);
		
	}
		//@AfterMethod
//		public void tearDown()
//		{
//			driver.quit();
//		}

}
