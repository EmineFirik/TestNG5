package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class TitleAndLoginValidationn extends CommonMethods {
	
	
	@BeforeMethod
	public void openAndNavigate () throws InterruptedException 
	{
		setUp();
	}
	
	
	@AfterMethod
	public void  quitBrowser () 
	{
		tearDown();
	}
	
	
	
	
	
	@Test
	public void titleValidation() 
	{
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		
		if (expectedTitle.equals(actualTitle)) {
			
			System.out.println("Title validation is pass.");
		}
		
		else 
		{
			System.out.println("Title validation failed.");
		}
		
	}
	
	@Test
	public void logoValidation() 
	{
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
		if( logo.isDisplayed()) {
			System.out.println("Logo validation is pass.");
		}else {
			System.out.println("Logo valoidation is not displayed");
		}	
}
	@Test
	public void loginValidation()
	
	{
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		
		WebElement userImage = driver.findElement(By.xpath("//div[@id='menu-profile']/img"));
		if( userImage.isDisplayed()) {
			System.out.println("Login validation is passed.");
			
		}else {
			System.out.println("Login validation is failed.");
		}
		
		
	}
	
	
	
	
	
	
	
	
}