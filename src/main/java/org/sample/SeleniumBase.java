package org.sample;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.sample.Browser;


public abstract class SeleniumBase implements Base{
      long timeout=30;
      long maxWaitTime=10;
      RemoteWebDriver driver=null;
      WebDriverWait wait=null;
	@Override
	public void setUp(String url) {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		wait= new WebDriverWait(driver,Duration.ofSeconds(maxWaitTime));
	}

	@Override
	public void setUp(Browser browserName, String url) {
		switch(browserName) {
		case Chrome:
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(op);
			break;
        case Firefox:
         driver=new FirefoxDriver();
			break;
		default:
			System.out.println("Not defined Driver");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		wait= new WebDriverWait(driver,Duration.ofSeconds(maxWaitTime));
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public void quit() {
		driver.quit();
		
	}

	@Override
	public WebElement element(Locators type, String value) {
		switch (type) {
		case id:
		return	driver.findElement(By.id(value));
		case name:
			return	driver.findElement(By.name(value));
		case xpath:
			return	driver.findElement(By.xpath(value));
		case text:
			return	driver.findElement(By.linkText(value));
		default:
			break;
		}
		return null;
	}

	@Override
	public void switchToWindow(int i) {
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> list=new ArrayList<String>(handles);
		driver.switchTo().window(list.get(i));
		
	}

	@Override
	public void selectValue(WebElement ele, String value) {
		WebElement visible = isElementVisible(ele);
		new Select(visible).selectByValue(value);
		
	}

	@Override
	public void selectText(WebElement ele, String text) {
		WebElement visible = isElementVisible(ele);
		new Select(visible).selectByVisibleText(text);
		
		
	}

	@Override
	public void selectIndex(WebElement ele, int position) {
		WebElement visible = isElementVisible(ele);
		new Select(visible).selectByIndex(position);
		
		
	}

	@Override
	public void click(WebElement ele) {
		WebElement until = wait.withMessage("element is not clickable").until(ExpectedConditions.elementToBeClickable(ele));
		until.click();
		
		
	}

	@Override
	public void type(WebElement ele, String testData) {
		WebElement until = isElementVisible(ele);
		until.clear();
		until.sendKeys(testData);
		
	}

	private WebElement isElementVisible(WebElement ele) {
		WebElement until = wait.until(ExpectedConditions.visibilityOf(ele));
		return until;
	}
	public void type(WebElement ele, String testData,Keys keys) {
		WebElement until = isElementVisible(ele);
		until.clear();
		until.sendKeys(testData,keys);
		}

	@Override
	public void appendText(WebElement ele, String testData) {
		
		WebElement until = isElementVisible(ele);
		until.sendKeys(testData);
	}

	@Override
	public String getTitle() {
		
		return driver.getTitle();
		}

	@Override
	public String getURL() {
		
		return driver.getCurrentUrl();
	}

	@Override
	public boolean isDisplayed(WebElement ele) {
		
		return false;
	}

	

}
