package com.sample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tutorial1 {
	private static WebDriver driver;

	
	@BeforeClass
	public  static void browserLaunch() {
ChromeOptions option=new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe" );
		 driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		}	
	@Before
	public void urlLaunch() {
		driver.get("https://www.facebook.com/");
		}
	@Test
	public void usernameEnter() {
		driver.findElement(By.id("email")).sendKeys("AbdulRaheem");
	}
	@After
	public void password() {
		driver.findElement(By.id("pass")).sendKeys("Raheem@123");
		}
	@AfterClass
	public static void LogIn() {
		driver.findElement(By.name("login")).click();
	}
	public static void main(String[] args) {
		Tutorial1 tu=new Tutorial1();
		tu.usernameEnter();
		tu.urlLaunch();
		Tutorial1.browserLaunch();
		Tutorial1.LogIn();
		tu.password();
	}

}
