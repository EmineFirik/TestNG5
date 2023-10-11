package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class HomeWork extends CommonMethods {
//HW2: OrangeHRM Add Employee:

   //Open chrome browser
   //Go to "https://hrm.neotechacademy.com/"
   //Login into the application
   //Click on Add Employee
   //Verify labels: Employee Full Name*, Employee Id, Location* are displayed
   //Provide Employee First and Last Name
   //Select a Location
   //Verify Employee has been added successfully
   //Close the browse
	
	@BeforeSuite
	public void navigateBrowser() throws InterruptedException {
		setUp();
	}

	@AfterSuite
	public void quiteBrowser() {
		tearDown();
	}
	
	@Test ( enabled = false)
	public void loginAplication () 
	{
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		wait(2);
		
		
		String expectedName = "Jacqueline White";
		String actuaName = driver.findElement(By.id("account-name")).getText();
		Assert.assertEquals(expectedName, actuaName, " Asscount name is not Displayed.");
		
		
	}
	
	@Test
	public void clickAndAddEmployee () 
	{

		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		wait(2);
		
		click(driver.findElement(By.xpath("//span[text()='PIM']")));
		click(driver.findElement(By.xpath("//span[text()='Add Employee']")));
		
		SoftAssert sa = new SoftAssert();
		
		WebElement fulName = driver.findElement(By.xpath("//label[text()='Employee Full Name']"));
		sa.assertEquals(fulName, true, "Ful Name is not Displayed");
		
		WebElement employeId = driver.findElement(By.xpath("//label[text()='Employee Id']"));
		sa.assertTrue(employeId.isDisplayed()," Employe ID is not Displayed");
		
		WebElement location = driver.findElement(By.xpath("//label[text()='Location']"));
		sa.assertTrue(location.isDisplayed(), "Location is not Displayed.");
		wait(2);
		
	}
	
	@Test(dependsOnMethods="clickAndAddEmployee")
	public void addEmploye () 
	
	{

		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		wait(2);
		
		click(driver.findElement(By.xpath("//span[text()='PIM']")));
		click(driver.findElement(By.xpath("//span[text()='Add Employee']")));
		wait(2);
		//add employee
		sendText(driver.findElement(By.id("first-name-box")), "Sule");
		sendText(driver.findElement(By.id("last-name-box")), "Kaptan");
		//sendText(driver.findElement(By.id("employeeId")), "0197");
		selectDropdown(driver.findElement(By.id("location")), "Canadian Development Center");
		click(driver.findElement(By.id("modal-save-button")));
		wait(2);
		
		WebElement newEmployee =  driver.findElement(By.id("pim.navbar.employeeName"));
		Assert.assertEquals(newEmployee.isDisplayed(),true,"Employe name is not correct.");
		wait(2);
	}

	
}
