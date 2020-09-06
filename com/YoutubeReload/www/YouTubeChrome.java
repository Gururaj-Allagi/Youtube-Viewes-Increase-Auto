package com.YoutubeReload.www;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YouTubeChrome
{
	public static WebDriver driver;
	public static FileInputStream fip;
	public static Properties prop;
	//public static int no=Integer.parseInt(prop.getProperty("How_many_times_want_to_view_the_video"));
	
	@BeforeMethod
	public static void BaseMethod() 
	{	
		try 
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver(); //OpenBrowser
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize(); //maximize browser
			System.out.println("Brower opened successfully");
			driver.get("https://www.youtube.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			fip = new FileInputStream(".\\Globel.Properties");
			prop = new Properties();
			prop.load(fip);	
		}
		catch(Exception e2)
		{
			System.out.println("Browser is not opened successfully, Problem in Base Method");
			
		}
	}
	
	@Test(invocationCount=10)
	public static void Youtube() throws Exception
	{
		try
		{
			System.out.println("Searched video is "+prop.getProperty("VideoName"));
			driver.findElement(By.cssSelector("input[id='search']")).sendKeys(prop.getProperty("VideoName"));
			driver.findElement(By.cssSelector("button[id='search-icon-legacy']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(prop.getProperty("VideoLink"))).click();
			System.out.println("Video Successfully Opened");
			if(prop.getProperty("Do_you_want_to_mute(Y/N)").equalsIgnoreCase("y"))
			{
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("button[class='ytp-mute-button ytp-button']")).click();
				System.out.println("Video Muted");
			}
		}
		catch(Exception e3)
		{
			System.out.println("Problem in searching the video");
		}
		try
		{
			String s=prop.getProperty("How_much_seconds_do_you_want_to_watch");
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+s+"')]")));
			System.out.println("Video Played "+s+"sec");
		}
		catch(Exception e1)
		{	
			System.out.println("Video Waited for 60 sec by default");
		}
	}
	
	@AfterMethod
	public static void Exit()
	{
		try
		{
			driver.manage().deleteAllCookies();
			driver.quit();
		}
		catch(Exception e1)
		{	
			driver.quit();
			System.out.println("Cookies are not deleted, Problem in Exit method");
		}
	}
}
