package com.sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Tutorial2 {
	@Test
	public void tc1() {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	    WebDriver driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("cricket",Keys.ENTER);
		List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'Cricket') or contains(text(),'cricket')]"));
		int size = elements.size();
		
		System.out.println(size);
	driver.quit();

	}

}
