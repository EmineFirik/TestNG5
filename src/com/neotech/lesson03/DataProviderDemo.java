package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class DataProviderDemo extends CommonMethods {

	// @BeforeMethod
	// public void navigateBrowser() throws InterruptedException
	// {
	// setUp();
	// }

	// @AfterMethod
	// public void quiteBrowser()
	// {
	// tearDown();
	// }

	@DataProvider(name = "userData")
	public Object[][] getdata() {
		Object[][] a = { 
				
				{ "Admin", "Admin123" }, 
				{ "Emine", "Emine123" }, 
				{ "Seray", "Seray123" } 
				};

		return a;

	}

	@Test(dataProvider = "userData")
	public void loginfanctionality(String username, String password) {

		
		sendText(driver.findElement(By.id("txtUsername")), username);

		sendText(driver.findElement(By.id("txtPassword")), password);

		wait(5);

		click(driver.findElement(By.xpath("//button[@type='submit']")));

		wait(2);

	}
}
