package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract class BrowserUtility  {

	
	public WebDriver getDriver() {
		return driver.get();
	}

	private static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	
	public BrowserUtility(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver.set(new ChromeDriver());
		}
		else if(browsername.equalsIgnoreCase("Edge"))
		{
			driver.set(new EdgeDriver());
		}
		else
		{
			System.err.println("Invalid Browser name");
		}
	}
	public BrowserUtility(Browser browsername)
	{
		if(browsername==Browser.CHROME)
		{
			driver.set(new ChromeDriver());
		}
		else if(browsername==Browser.EDGE)
		{
			driver.set(new EdgeDriver());
		}
		else
		{
			System.err.println("Invalid Browser name");
		}
	}

	public BrowserUtility(Browser browsername,boolean isheadless)
	{
		if(browsername==Browser.CHROME )
		{
			if(isheadless) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
			}
			else
			{
				driver.set(new ChromeDriver());
			}
		}
		else if(browsername==Browser.EDGE)
		{
			driver.set(new EdgeDriver());
		}
		else
		{
			System.err.println("Invalid Browser name");
		}
	}
	
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);;
	}
	
	public void LaunchUrl(String url)
	{
		driver.get().get(url);
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator)
	{
		WebElement  element = driver.get().findElement(locator);
		element.click();
	}
	
	public void entertext(By locator,String text)
	{
		WebElement  element = driver.get().findElement(locator);
		element.sendKeys(text);
	}
	
	public String visibletext(By locator)
	{
		WebElement  element = driver.get().findElement(locator);
		return element.getText();
	}
	
	
	public String takeScreenshot(String name)
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File Screensgotimg=screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("HH-mm-ss");
		String timeStamp=dateformat.format(date);
		String path = System.getProperty("user.dir")+"//screenshot//"+name+" - "+timeStamp+".png";
		File screenShotFile= new File(path);
		try {
			FileUtils.copyFile(Screensgotimg, screenShotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
