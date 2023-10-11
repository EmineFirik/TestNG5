package com.neotech.lesson02;

import org.testng.annotations.Test;

public class DependsDemo {

	
		@Test
		public void firstTest() throws Exception {
			System.out.println("first test");
			 throw new Exception();
		}

		
		@Test
		public void secondTest() {
			System.out.println("second test");
		}

		@Test(dependsOnMethods = { "firstTest", "secondTest" })
		public void thirdTest() {
			System.out.println("third test");
			
		}

		@Test(dependsOnMethods = "thirdTest")
		public void fourthTest() {
			System.out.println("fourth test");
		}
	}








































