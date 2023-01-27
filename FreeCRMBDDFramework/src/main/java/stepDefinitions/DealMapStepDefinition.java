/*package stepDefinitions;


import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DealMapStepDefinition {
	WebDriver driver;

	@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {
		System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://classic.freecrm.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_free_CRM() {
		String title = driver.getTitle();
		Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.", title);
	}

	@Then("^close the live chatbox$")
	public void close_the_live_chatbox() {
		driver.switchTo().frame("intercom-borderless-frame");
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card intercom-13njied')]"))).build()
				.perform();
		driver.findElement(By.xpath("//div[@aria-label='Dismiss']")).click();
		driver.switchTo().defaultContent();
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) {
		for(Map<String,String> data : credentials.asMaps(String.class, String.class)) {
		driver.findElement(By.name("username")).sendKeys(data.get("username"));
		driver.findElement(By.name("password")).sendKeys(data.get("password"));
		}
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}

	@Then("^user is on home page$")
	public void user_is_on_hopme_page() {
		String title = driver.getTitle();
		Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.", title);
	}

	@Then("^user moves to new deal page$")
	public void user_moves_to_new_deal_page() throws InterruptedException {
		driver.switchTo().frame("mainpanel");
		Thread.sleep(10000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();

	}

	@Then("^user enters deal details$")
	public void user_enters_deal_details(DataTable dealData) {
		for(Map<String, String> dealValues : dealData.asMaps(String.class, String.class)){
		driver.findElement(By.id("title")).sendKeys(dealValues.get("title"));
		driver.findElement(By.id("amount")).sendKeys(dealValues.get("amount"));
		driver.findElement(By.id("probability")).sendKeys(dealValues.get("probability"));
		driver.findElement(By.id("commission")).sendKeys(dealValues.get("commission"));
		}
	}

}*/

