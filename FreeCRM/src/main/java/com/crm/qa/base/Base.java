package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utilities.TestUtil;
import com.crm.qa.utilities.WebEventListner;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListner eventListener;

	public Base() {
		try {
			prop = new Properties();
			FileInputStream f = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
			prop.load(f);

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\QA\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//object of event firing wedriver classs
		e_driver = new EventFiringWebDriver(driver);
		//object of Web event listner class
		eventListener = new WebEventListner();
		//register eventlistner class object with event listner firing webdriver
		e_driver.register(eventListener);
		//assign event listner driver to main driver
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

		driver.switchTo().frame("intercom-borderless-frame");
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card intercom-13njied')]"))).build()
				.perform();
		driver.findElement(By.xpath("//div[@aria-label='Dismiss']")).click();
		driver.switchTo().defaultContent();
	}
}
