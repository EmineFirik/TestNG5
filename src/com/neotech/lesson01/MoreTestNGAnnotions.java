package com.neotech.lesson01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MoreTestNGAnnotions {
	
	@Test
	public void test1 () 
	{
		System.out.println("This is test 1 running.");
	}
	

	
	@Test
	public void test2 () 
	{
		System.out.println("This is test 2 running.");
	}
	
	
	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("Before method.");
	}
	

	@AfterMethod
	public void afterMethod() 
	{
		System.out.println("After method.");
	}
	

	@BeforeClass
	public void beforeClass() 
	{
		System.out.println("Before  class.");
	}
	
	

	@AfterClass
	public void afterClass() 
	{
		System.out.println("After  class.");
	}
	

	@BeforeTest
	public void beforeTest() 
	{
		System.out.println("Before test.");
	}
	
	@AfterTest
	public void afterTest() 
	{
		System.out.println("After test.");
	}
}
