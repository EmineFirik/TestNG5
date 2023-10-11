package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class SoftAssretDemo  extends CommonMethods{


	@BeforeMethod 
	public void NavigateBrowser () throws InterruptedException 
	{
		setUp ();
	}
	
	@AfterMethod
	public void quiteBrowser ()
	{
		tearDown();
	}
	
	
	@Test
	public void logoAndLoginValidation()
	{
		
			WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogin\"]/div[2]/div/div[1]/img"));
			boolean isLogoDisplayed = logo.isDisplayed();
			//logo is displayed validation
			SoftAssert softAssert = new SoftAssert();
			
			softAssert.assertTrue(isLogoDisplayed);
			
			//login validation
			
			sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
			sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
			click(driver.findElement(By.xpath("//button[@type='submit']")));
			
			wait(2);
			String expected = "Jacqueline White";
		    String actual = driver.findElement(By.id("account-name")).getText();
		    softAssert.assertEquals(expected, actual, "Account name is not Jacqueline White");
		    softAssert.assertAll();
		  
		}
		
	}

