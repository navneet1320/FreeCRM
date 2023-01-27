package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base{
	
	//page factory
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login(String name, String pass)
	{
		username.sendKeys(name);
		password.sendKeys(pass);
		
	//	driver.switchTo().frame("intercom-borderless-frame");
	//	Actions action = new Actions(driver);
	//	action.moveToElement(popup).build().perform();
	//	closePopup.click();
		
		loginBtn.click();
		
		return new HomePage();
	}
	
	

}
