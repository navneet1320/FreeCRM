package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class HomePage extends Base{
	
	@FindBy(xpath="//td[contains(text(),'User: dhara patel')]")
	WebElement user;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return user.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()//return contactpage so return type is contactpage
	{
		contactsLink.click();
		return new ContactsPage();//create object of contact page
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskLink()
	{
		taskLink.click();
		return new TaskPage();
	}
	
	public void clickOnNewContact()
	{
		Actions a = new Actions(driver);
		a.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
	
	

}
