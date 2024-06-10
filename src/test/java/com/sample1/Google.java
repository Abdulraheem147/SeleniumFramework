package com.sample1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.sample.Browser;
import org.sample.Locators;
import org.sample.SeleniumBase;
import org.testng.annotations.Test;

public class Google extends SeleniumBase{
	@Test
	void hello() throws InterruptedException {
		setUp(Browser.Chrome,"https://www.google.com/");
		//WebElement search = element("name", "q");
		//type(search, "adactin hotel app");
		type(element(Locators.name,"q"), "adactin hotel app",Keys.ENTER);
		Thread.sleep(2000);
		quit();
	}

}
