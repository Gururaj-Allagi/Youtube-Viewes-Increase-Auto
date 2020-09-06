package com.YoutubeReload.www;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;

import org.python.core.exceptions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class YoutubeClassNewImpl 
{
	boolean flag = true;
	static Robot r ;
	static Screen scr ;
	public static int count = 0;
	public static FileInputStream fis;
	public static Properties prop;
	public static int Total_Ran_Count = 0;
	
	public static void OpenBrowser() 
	{
		try
		{
			r = new Robot();
			scr = new Screen();
			
			r.delay(2000);
			
			r.keyPress(KeyEvent.VK_WINDOWS);
			r.keyPress(KeyEvent.VK_D);
			r.keyRelease(KeyEvent.VK_WINDOWS);
			r.keyRelease(KeyEvent.VK_D);
			
			System.out.println("Click on browser");
	
			r.delay(1000);
			r.keyPress(KeyEvent.VK_UP);
			r.delay(500);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(500);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(500);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(500);
			r.keyPress(KeyEvent.VK_ENTER);
			
			System.out.println("Browser opened successfully");
			
		}
		catch(Throwable e1)
		{
			System.out.println("Browser not opened successfully");
			r.delay(500);
			OpenBrowser();
		}
	}
	
	public static void MaximizeBrowser()
	{
		try 
		{
			Pattern Browser_Maximize=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Browser_Maximize.PNG");
			scr.click(Browser_Maximize);
			System.out.println("Brower maximized successfully");
			count=0;
		} 
		catch (Exception e) 
		{
			if(count<=10)
			{
				r.delay(2000);
				count++;
				MaximizeBrowser();
			}
		}
	}
	
	public static void broswerSearchBar()
	{
		try
		{
			Pattern search_bar = new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Search_bar.PNG");
			scr.type(search_bar, "https://www.youtube.com/");	
			r.keyPress(KeyEvent.VK_ENTER);
			System.out.println("successfully entered into to youtube");
			count=0;
		}
		catch (Exception e) 
		{
			if(count<=20)
			{
				r.delay(2000);
				count++;
				broswerSearchBar();
			}
		}
	}
	
	public static void skipAdd()
	{
		try
		{
			Pattern skip_add=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Remind_Me_Later.PNG");
			scr.click(skip_add);
			count=0;
		}
		catch(Exception e)
		{
			if(count<=2)
			{
				System.out.println("trying to skip the add");
				r.delay(2500);
				count++;
				skipAdd();
			}
		}
	}
	
	public static void YoutubeSearchBar()
	{
		try
		{
			Pattern Youtube_Search_Bar=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Youtube_Search_Bar.PNG");
			scr.click(Youtube_Search_Bar);
			System.out.println("Youtube Search bar found");
			//skipAdd(); 
			typeVideoName();
			count=0;
		}
		catch (Exception e) 
		{
			if(count<=20)
			{
				System.out.println("Re-Searching youtube Search bar");
				r.delay(2000);
				count++;
				YoutubeSearchBar();
			}		
		}
	}
	
	public static void typeVideoName()
	{
		try 
		{
			r.delay(1000);
			Pattern Youtube_Search_Bar=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Youtube_Search_Bar.PNG");
			//scr.type(Youtube_Search_Bar, "sakuni marketing adviser");
			scr.type(Youtube_Search_Bar, "Filmy Profile ");
			r.keyPress(KeyEvent.VK_ENTER);
			count=0;
		} 
		catch (Exception e) 
		{
			if(count<=5)
			{
				System.out.println("Re-Searching youtube Search bar");
				r.delay(2000);
				count++;
				typeVideoName();
			}		
		}
	}
	
	public static void VideoFromYoutubeList()
	{
		try
		{
			r.delay(2000);
			//Pattern Sakuni_video=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Sakuni_video.PNG");
			Pattern Sakuni_video=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Filmy_Profile 10m.PNG");	
			scr.click(Sakuni_video);
			System.out.println("Successfully opened required video");
			count=0;
		}
		catch (Exception e) 
		{
			if(count<=15)
			{
				System.out.println("Video rechecking");
				r.delay(2000);
				count++;
				if(count>=15)
				{
					
					System.out.println("typing video again");
					YoutubeSearchBar();
				}
				VideoFromYoutubeList();
			}
			
		}
	}
	
	public static void CloseBrowser()
	{
		try
		{
			Pattern Setting_Icon=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Settings_Quality.PNG");
			scr.click(Setting_Icon);
			r.delay(5000);
			Pattern Quality=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Quality.PNG");
			scr.click(Quality);
			r.delay(500);
			Pattern Quality144p=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Quality144p.PNG");
			scr.click(Quality144p);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(30000);
			r.delay(10000);
			Pattern Browser_Close_Icon=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Browser_Close_Icon.PNG");	
			scr.click(Browser_Close_Icon);
			System.out.println("Brower closed successfully");
			count=0;
			System.out.println(Total_Ran_Count);
		}
			catch (Exception e) 
		{
			if(count<=20)
			{
				System.out.println("rechecking");
				r.delay(2000);
				count++;
				CloseBrowser();
			}
			
		}
	}
	
	public static void main(String[] args)  
	{
		try
		{	
			for(int i=0;i<=100;i++)
			{
				OpenBrowser();
				
				broswerSearchBar();
				
				MaximizeBrowser();
				
				YoutubeSearchBar();
				
				VideoFromYoutubeList();
				
				CloseBrowser();
				
				Total_Ran_Count++;
			}
		}
		catch (Exception e) 
		{
			try 
			{
				Pattern Browser_Close_Icon=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Browser_Close_Icon.PNG");
				scr.click(Browser_Close_Icon);
			} 
			catch (FindFailed e1) 
			{
				
			}
			r.delay(1000);
			System.out.println("failed to run");
		}
	}
}
