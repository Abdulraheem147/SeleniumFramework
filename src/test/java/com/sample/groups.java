package com.sample;

import org.testng.annotations.Test;

public class groups {
	@Test(groups= {"hello"})
	public void signUp() {
		System.out.println("signup");
	}
	@Test(groups= {"smoke"})
	public void logIn() {
		System.out.println("login");
	}
	@Test(groups= {"sanity"},priority=1)
	public void searchProduct() {
		System.out.println("search product");
	}
	@Test(groups= {"reg"})
	public void addtToCart() {
		System.out.println("add to cart");
	}
	@Test(groups= {"sanity"},priority=0)
	public void signOut() {
		System.out.println("sign out");
	}

}
