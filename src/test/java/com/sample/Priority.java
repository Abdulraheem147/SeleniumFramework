package com.sample;

import org.testng.annotations.Test;

/*public class Priority {
	@Test(priority=-2)
	public void signUp() {
		System.out.println("signup");
	}
	@Test(priority=-1)
	public void logIn() {
		System.out.println("login");
	}
	@Test
	public void searchProduct() {
		System.out.println("search product");
	}
	@Test(priority=1)
	public void addtToCart() {
		System.out.println("add to cart");
	}
	@Test(priority=2)
	public void signOut() {
		System.out.println("sign out");
	}
	
	
}*/

public class Priority {
	@Test()
	public void signUp() {
		System.out.println("signUp");
	}
	
	@Test(dependsOnMethods="signUp",priority=-1,description="This is used to login")
	public void logIn() {
		System.out.println("login");
	}
	
	@Test(dependsOnMethods="logIn",description="This shows exception")
			
	public void searchProduct() {
		System.out.println("search product");
		throw new RuntimeException();
	}
	
	@Test(dependsOnMethods="searchProduct",alwaysRun=true,description = "This is used to do addToCart")
	public void addtToCart() {
		System.out.println("add to cart");
	}
	
	@Test(dependsOnMethods="addtToCart",alwaysRun=true,enabled = false)
	public void signOut() {
		System.out.println("signout");
	}
	
	//alwaysRun default value is false and enable default value is true
}

