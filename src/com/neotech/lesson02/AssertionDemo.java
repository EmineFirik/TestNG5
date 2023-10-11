package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class AssertionDemo  extends CommonMethods{
	
	@BeforeMethod 
    public void openAndNavigate () throws InterruptedException 
	{
		setUp();
	}
	
	@AfterMethod
	public void quitBrowser () 
	{
		tearDown();
	}
	
	
	@Test(enabled =false)
	public void titleValidation () 
	
	{
		String expected = "OrangeHRM";
		String actualTitle = driver.getTitle();
		
		// Assert.assertEquals(expected, actualTitle);
		
		Assert.assertEquals(expected, actualTitle, " Title is match!");
		
	}
	
	@Test
	public void logoValidation () 
	{
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogin\"]/div[2]/div/div[1]/img"));
		//Assert.assertTrue(logo.isDisplayed());
		
		Assert.assertEquals(logo.isDisplayed(), true, "Logo is displayed");
		
	}
}
