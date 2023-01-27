/*package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class LoginStepDefinitions {
	
	WebDriver driver;
	
	@Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
		System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");
	 	driver = new FirefoxDriver();
		driver.get("https://classic.freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM()  {
		String title= driver.getTitle();
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}

	@Then("^close the live chatbox$")
	public void close_the_live_chatbox()  {
		driver.switchTo().frame("intercom-borderless-frame");
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card intercom-13njied')]"))).build()
				.perform();
		driver.findElement(By.xpath("//div[@aria-label='Dismiss']")).click();
		driver.switchTo().defaultContent();
	}
	
	// \"(.*)\"-regular expression

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password){
	 driver.findElement(By.name("username")).sendKeys(username);
	 driver.findElement(By.name("password")).sendKeys(password);
	 }

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",loginBtn);
	}

	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page(){
	 String title = driver.getTitle();
	 System.out.println("Home Page title ::"+ title);
	 Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.", title);
	 }
	 
	 @Then("^user moves to new contact page$")
	 public void user_moves_to_new_contact_page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		WebElement contacts = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		action.moveToElement(contacts).build().perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",contacts);
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		
		}
	 
	 @Then("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	 public void user_enters_contacts_details(String firstname, String lastname, String position){
		 driver.findElement(By.id("first_name")).sendKeys(firstname);
		 driver.findElement(By.id("surname")).sendKeys(lastname);
		 driver.findElement(By.id("company_position")).sendKeys(position);
		 driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	 }	 
	 
	 @Then("^Close the browser$")
	 public void Close_the_browser() {
		 driver.quit();
	 }
}*/
