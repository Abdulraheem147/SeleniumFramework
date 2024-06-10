package org.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sample.SeleniumBase;

public class logIn {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		properties.load(new FileInputStream("./PropFile/file1.properties"));
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		RemoteWebDriver driver=new ChromeDriver(op);
		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys(properties.getProperty("phNo"));
		driver.findElement(By.name("pass")).sendKeys(properties.getProperty("pass"));
		driver.findElement(By.name("login")).click();

	}

}
