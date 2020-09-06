package com.YoutubeReload.www;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.exec.ExecuteException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class YoutubeClaas {

	boolean flag=true;
	static Robot r;
	static Screen scr;
	public static int count=0;
	public static void main(String[] args) throws AWTException, FindFailed 
	{
		
	for(int i=0;i<=100;i++)
		{
			r=new Robot();
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
			try
			{
				scr=new Screen();
				//r.delay(20000);
				Pattern Browser_Maximize=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Browser_Maximize.PNG");
				scr.click(Browser_Maximize);
				//r.delay(1000);
				Pattern search_bar=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Search_bar.PNG");
				scr.type(search_bar, "https://www.youtube.com/");	
				r.keyPress(KeyEvent.VK_ENTER);
				//r.delay(30000);
				Pattern Youtube_Search_Bar=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Youtube_Search_Bar1.PNG");
				scr.type(Youtube_Search_Bar, "sakuni marketing adviser");	
				r.keyPress(KeyEvent.VK_ENTER);
				//r.delay(30000);
				Pattern Sakuni_video=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Sakuni_video.PNG");	
				scr.click(Sakuni_video);
				//r.delay(30000);
				//r.delay(30000);
				//r.delay(30000);
				Pattern Browser_Close_Icon=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Browser_Close_Icon.PNG");	
				scr.click(Browser_Close_Icon);
				r.delay(1000);
				count=0;
			}
			catch(Exception e)
			{
				if(count<=10)
				{
					r.delay(5000);
					count++;
					main(args);
					
					
					/*r.keyPress(KeyEvent.VK_S);
					r.keyPress(KeyEvent.VK_A);
					r.keyPress(KeyEvent.VK_K);
					r.keyPress(KeyEvent.VK_U);
					r.keyPress(KeyEvent.VK_N);
					r.keyPress(KeyEvent.VK_I);
					r.keyRelease(KeyEvent.VK_S);
					r.keyRelease(KeyEvent.VK_A);
					r.keyRelease(KeyEvent.VK_K);
					r.keyRelease(KeyEvent.VK_U);
					r.keyRelease(KeyEvent.VK_N);
					r.keyRelease(KeyEvent.VK_I);*/
					
				}
				else
				{
					Pattern Browser_Close_Icon=new Pattern("C:\\Eclipse Work Space\\YoutubeReload\\Screens\\Browser_Close_Icon.PNG");
					scr.click(Browser_Close_Icon);
					r.delay(1000);
					System.out.println("failed to run");
				}
				
					
			}
			
			
			
		}
	
	}
	
	
}
