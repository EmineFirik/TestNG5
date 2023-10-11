package com.neotech.lesson02;

import org.testng.annotations.Test;

public class EnableAndDisable {
	

	@Test(priority = 0)
	public void FirstTest ()
	{
	System.out.println("First Test");	
	}

	

	@Test(priority = 1, enabled = false )
	public void secondTest ()
	{
	System.out.println("Second Test");	
	}


	@Test(priority = 2)
	public void ThirdtTest ()
	{
	System.out.println("Third Test");	
	}

	
	

	@Test(priority =3)
	public void FourtTest ()
	{
	System.out.println("Fourth Test");	
	}


}
