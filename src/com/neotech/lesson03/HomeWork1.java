package com.neotech.lesson03;

import org.testng.annotations.Test;

public class HomeWork1 {
	
	@Test(priority = 10)
	public void firstMethod() 
	{
		System.out.println("First Method");
	}
	
	@Test(enabled = false)
	public void secondMethod() 
	{
		System.out.println("Second Method");
	}
	
	
	@Test(priority = 5)
	public void thirdMethod() 
	{
		System.out.println("Third Method");
	}
	

	@Test(priority = 3)
	public void fourthMethod() 
	{
		System.out.println("Fourth Method");
	}
	

}
