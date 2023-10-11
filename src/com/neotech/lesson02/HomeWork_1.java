package com.neotech.lesson02;

import org.testng.annotations.Test;

public class HomeWork_1 {
	
	//HW1: Executing tests using priority and enable attributes

	//Create a class TaskOne that has 5 test methods named:
	//firstMethod
	//firstMethod1
	//secondMethod
	//thirdMethod
	//fourthMethod
	
	//And each of them printing the method name
	//Run and observe results

	//Then, add the needed attributes to print the following result:
	//fourthMethod
	//thirdMethod
	//secondMethod
	//firstMethod
	
	@Test(priority = 1)
	public void firstMethod() 
	{
		System.out.println("First Method!");
	}

	
	@Test(priority = 2,enabled =false)
	public void firstMethod1() 
	{
		System.out.println("First Method1!");
	}


	@Test(priority = 0)
	public void secondMethod() 
	{
	System.out.println("Second Method!");	
	}
	
	
	@Test(priority = 3)
	public void thirdMethod() 
	{
		System.out.println("Third Method!");
	}
	
	@Test(priority = 4)
	public void fourthMethod() 
	{
		System.out.println("Fourt Method!");
	}
	
}
