package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class TitleAndLoginValidation extends CommonMethods{

	@BeforeMethod
	public void openAndNavigate() throws InterruptedException
	{
		setUp();
	}
	
	@AfterMethod
	public void quitBrowser()
	{
		tearDown();
	}
	
	@Test
	public void  titleValidation() throws Exception
	{
		String expectedTitle = "OrangeHRM123";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle))
		{
			System.out.println("Title Validation Passed!!");
		}
		else
		{
			System.out.println("Title Validation Failed!!");
			//we add this intentionally to create an issue (for now)
			throw new Exception();
		}
	}
	
	@Test
	public void logoValidation() throws Exception
	{
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
		
		if(logo.isDisplayed())
		{
			System.out.println("Logo Validation Passed!!");
		}
		else
		{
			System.out.println("Logo Validation Failed!!");
			//we add this intentionally to create an issue (for now)
			throw new Exception();
		}
	}
	
	@Test
	public void loginValidation() throws Exception
	{
		sendText(driver.findElement(By.id("txtUsername")),
				ConfigsReader.getProperty("username"));
		
		sendText(driver.findElement(By.id("txtPassword")),
				ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		
		//lets check if the profile img is shown
		
		WebElement userImg = driver.findElement(By.xpath("//div[@id='menu-profile']/img"));

		if(userImg.isDisplayed())
		{
			System.out.println("Login Validation Passed!!");
		}
		else
		{
			System.out.println("Login Validation Failed!!");
			//we add this intentionally to create an issue (for now)
			throw new Exception();
		}
		
		
	}
	
	//Order of execution: 
	//BeforeMethod
		//loginValidation Test
	//AfterMethod
	//BeforeMethod
		//logoValidation Test
	//AfterMethod
	//BeforeMethod
		//titleValidation Test
	//AfterMethod
	

}
