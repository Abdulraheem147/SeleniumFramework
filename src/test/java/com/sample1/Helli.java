
package com.sample1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Helli {
	RemoteWebDriver driver;
	@Parameters({"email","pass","browser"})
	@Test
	public void launch(String emai,String pas,String bro) throws InterruptedException {
		switch (bro) {
		case "chrome":
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(op);
			
			break;
		case "fire":
			FirefoxOptions opt=new FirefoxOptions();
			opt.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	
			driver=new FirefoxDriver(opt);
			break;
		default:
			System.err.println("Browser is not defined");
			break;
		}
		
		/*ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	    WebDriver driver=new ChromeDriver(op);*/
		//driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys(emai);
		driver.findElement(By.name("pass")).sendKeys(pas);
		driver.findElement(By.name("login")).click();
		String string = driver.getTitle();
		System.out.println(string);

		

		
	}

}
