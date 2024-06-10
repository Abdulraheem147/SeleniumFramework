package com.sample;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Tutorial3 {
	@Test
	public void tc2() {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		op.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	    WebDriver driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("iphone 14 pro",Keys.ENTER);
		WebElement istmobile = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
		istmobile.click();
		String window1id = driver.getWindowHandle();
		System.out.println("Parent Windows Id:"+window1id);
		Set<String> allwindowid = driver.getWindowHandles();
		System.out.println("All Windows Id:"+allwindowid);
	        for (String x : allwindowid) {
	        	if(!window1id.equals(x)) {
	        		System.out.println("child windows id:"+x);
	        		driver.switchTo().window(x);
	        	}
	        	driver.switchTo().window(window1id);
	        	WebElement mobile2 = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
				mobile2.click();
				Set<String> window3id = driver.getWindowHandles();
				List<String> li=new LinkedList<String>();
				li.addAll(window3id);
				String window4id = li.get(2);
				System.out.println("second window id:"+window4id);
				driver.switchTo().window(window4id);
				driver.switchTo().window(x);
				driver.switchTo().window(window1id);
				driver.switchTo().window(x);
				String url = driver.getCurrentUrl();
				System.out.println(url);
				driver.switchTo().window(li.get(0));
			
		}

	}

}
