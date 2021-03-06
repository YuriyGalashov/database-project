package com.sqa.yg.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sqa.yg.auto.Core;

public class BasicTest extends Core {

	public BasicTest(String baseUrl) {
		super(baseUrl);
	}

	@BeforeClass(enabled = true)
	public void setUpChrome() throws Exception {
		System.out.println("Setup Chrome");
		// Set system property to use Chrome driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		// Setup the driver to use Chrome
		setDriver(new ChromeDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Goto Base URL
		getDriver().get(getBaseURL());
	}

	@BeforeClass(enabled = false)
	public void setUpFirefox() throws Exception {
		System.out.println("Setup Firefox");
		// Setup the driver to use IE
		setDriver(new FirefoxDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Goto Base URL
		getDriver().get(getBaseURL());
	}

	@BeforeClass(enabled = false)
	public void setUpIE() throws Exception {
		System.out.println("Setup IE");
		// Set system property to use IE driver
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		// Setup the driver to use IE
		setDriver(new InternetExplorerDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Goto Base URL
		getDriver().get(getBaseURL());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// quit closes all instances of the browser.
		getDriver().quit();
		// close method would close current instance only.
		// ex: driver.close();
	}
}
