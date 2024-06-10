package com.sample1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest extends Report{
	
	@BeforeTest
	void myTest() {
		
		desc="First Test";
		author="Abdul";
		category="Testing";
	}
	
	
	
	
@Test
 void setData() {
	System.out.println("Test begins"); 
	stepReport("pass","description");
	System.out.println("Test end");
	
 }
}
