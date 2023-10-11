package com.neotech.lesson03;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class HomeWork_1  extends CommonMethods{
	//HomeWork:
	//Open chrome browser
	//Go to "https://hrm.neotechacademy.com/"
	//Login to the application
	//Add 3 different Employees and Create Login Details by providing:
	//First Name
	//Last Name
	//Username
	//Password
	//Verify Employee has been added successfully and take screenshot (you must have 3 different screenshots)
	//Close the browser
	//Specify a group for this test case, add it into specific suite and execute from the xml file.
	
	@Test(dataProvider = "userData")
	public void loginAplication (String username, String password,String firstName ,String lastName, String location) 
	{
		sendText(driver.findElement(By.id("txtUsername")),username );
		sendText(driver.findElement(By.id("txtPassword")),password);
		
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		click(driver.findElement(By.xpath("//span[text()='PIM']")));
		click(driver.findElement(By.xpath("//span[text()='Add Employee']")));
		
		//Add Emplployee
		sendText(driver.findElement(By.id("first-name-box")), firstName);
		sendText(driver.findElement(By.id("last-name-box")), lastName);
		
		selectDropdown(driver.findElement(By.id("location")), location);
		click(driver.findElement(By.id("modal-save-button")));
		
		wait(5);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String getTimeStamp = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		try {
			Files.copy(sourceFile, new File("screenshot/HRM" + getTimeStamp + ".png"));

		} catch (IOException e) {

			e.printStackTrace();

			System.out.println("Unable to save the screenshot");
		}
	}
	@DataProvider(name = "userData")
	public Object [][] getdata(){
		Object [][] a = {
				{"Admin", "Neotech@123", "Emine", "Firik" ,"Canadian Development Center "},
				
				{"Admin", "Neotech@123", "Dincer", "Firik" ,"Canadian Regional HQ",},
				
				{"Admin", "Neotech@123", "Seray",  "Firik", "Chinese Development Center",},
				};
				
			return a;	
		}
		
		
		
	}


