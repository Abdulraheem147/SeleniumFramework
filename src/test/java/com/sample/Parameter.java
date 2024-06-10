package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter{
	@Parameters({"emailId","password"})
	@Test
	public void launch(String emai ,String pas) {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	    WebDriver driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys(emai);
		driver.findElement(By.name("pass")).sendKeys(pas);
		driver.findElement(By.name("login")).click();
		String string = driver.getTitle();
		System.out.println(string);

		
	}

}
