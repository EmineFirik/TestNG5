package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class HomeWork  extends CommonMethods{
	
	//Homework 1: HRMS Application Negative Login: 

   // 1. Open chrome browser
   // 2. Go to "https://hrm.neotechacademy.com/"
   // 3. Enter valid username
   // 4. Leave password field empty
   // 5. Verify error message with text "Password cannot be empty" is displayed.
	
	@BeforeMethod
	public void openNavigate () throws InterruptedException
	{
	setUp()	;
	}
	
	
	@AfterMethod
	public void quitBrowser()
	
	{
		tearDown();
	}
	
	
	@Test
	public void loginValidate () 
	{
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		
		sendText(driver.findElement(By.id("txtPassword")), "");
		
		click(driver.findElement(By.xpath("//button[@type='submit']")) );
		
		WebElement errorText = driver.findElement(By.id("txtPassword-error"));
		
		if( errorText.isDisplayed()) {
			
			System.out.println("Test is Passed.");
		}else {
			System.out.println("Test is Failed.");
		}
		
	}
	
	
}
