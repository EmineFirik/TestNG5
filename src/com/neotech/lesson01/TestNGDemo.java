package com.neotech.lesson01;

import org.testng.annotations.Test;

public class TestNGDemo {
		
	@Test(groups ="smoke")
	public void testOne() 
	{
		System.out.println("Test one!");
	}
	
	@Test
	public void testTwo() 
	{
		System.out.println("Test Two!");
	}
		
	@Test
	public void testTree() 
	{
		System.out.println("Test Tree!");
	}		
	
}
