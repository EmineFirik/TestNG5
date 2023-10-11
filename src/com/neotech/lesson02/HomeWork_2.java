package com.neotech.lesson02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.BaseClass;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class HomeWork_2 extends CommonMethods{
//HW2: OrangeHRM Add Employee:

    //Open chrome browser
   // Go to "https://hrm.neotechacademy.com/"
    //Login into the application
   // Click on Add Employee
   // Verify labels: Employee Full Name*, Employee Id, Location* are displayed
    //Provide Employee First and Last Name
   // Select a Location
   // Verify Employee has been added successfully
   // Close the browser
	@BeforeMethod
	public void navigateBrowser() throws InterruptedException {
		setUp();
	}
	@AfterMethod
	public void quiteBrowser() {
		tearDown();
	}
	@Test
	public void LoginValidatePage() 
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
	sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
	click(driver.findElement(By.xpath("//button[@type='submit']")));
	
	click(driver.findElement(By.xpath("//span[contains(text(),'PIM')]")));
	click(driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']//span[@class='left-menu-title']")));
	
	WebElement fullName = driver.findElement(By.xpath("//label[text()='Employee Full Name']"));
	Assert.assertTrue(fullName.isDisplayed(), "Full name is not  Displayed.");
	
	WebElement employeeID = driver.findElement(By.xpath("//label[text()='Employee Id']"));
	Assert.assertTrue(employeeID.isDisplayed()," Employee ID is  not displayed.");
	
	WebElement location =driver.findElement(By.xpath("//label[text()='Location']"));
	Assert.assertTrue(location.isDisplayed(), "Location is not  Displayed");
	wait(2);
	
	sendText(driver.findElement(By.id("first-name-box")) , " Emine");
	sendText (driver.findElement(By.id("last-name-box")), "Firik");
	sendText ( driver.findElement(By.id("employeeId")), " 0213");
	
	selectDropdown(driver.findElement(By.id("location")), "Canadian Development Center");
	click(driver.findElement(By.id("modal-save-button")));
	
	String expected = "Emine Firik";
	String actualName = driver.findElement(By.id("pim.navbar.employeeName")).getText();
	
	Assert.assertEquals(expected,actualName, "Employee has been added successfully ");
	wait(2);
	
	}
}
