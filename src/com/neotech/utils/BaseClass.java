package com.neotech.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public static WebDriver driver;
    @BeforeMethod(alwaysRun= true)
	public static void setUp() throws InterruptedException {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		String browser = ConfigsReader.getProperty("browser");
		// System.out.println(browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;

		case "firefox":
			//System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}

		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_WAITTIME));
		driver.manage().window().maximize();
		String website = ConfigsReader.getProperty("url");
		driver.get(website);
	}
   @AfterMethod(alwaysRun = true)
	public static  void tearDown() {//birsey ilave edeceksen once config sin icine yazacaksin sonrada buraya ekleyip kullanicaz
		
		if (driver != null) {
				driver.quit();
			}
		}
	}
	