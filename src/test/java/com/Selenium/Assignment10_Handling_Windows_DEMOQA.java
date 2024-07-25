package com.Selenium;

import org.testng.annotations.Test;

import com.POM.DemoQAPOM;
import com.Utility.BasePage;
import com.Utility.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Assignment10_Handling_Windows_DEMOQA extends BasePage
{
  @Test(priority=0)
  public void LaunchDemoQAWindowsSite() 
  {
	  System.out.println("inside LaunchDemoQAWindowsSite");
	  driver.get(objProp.getProperty("DemoQAWindowUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  //String title = driver.getTitle();
	  //System.out.println("Title :" +title);
	  //Assert.assertEquals(title, objProp.getProperty("DemoQAWindowTitle"));
  }
  
  @Test(priority=1,enabled=false)
  public void ValidateNewTab() throws Exception
  {
	  System.out.println("inside ValidateNewTab");
	  DemoQAPOM objDemoQAPOM = new DemoQAPOM(driver);
	  String ParentWindow = driver.getWindowHandle();
	  ScrollTillTheElement(objDemoQAPOM.newTabBtn);
	  objDemoQAPOM.newTabBtn.click();
	  Thread.sleep(4000);
	  Set<String> allTabs = driver.getWindowHandles();
	  System.out.println("Number of windows :" +allTabs.size());
	  boolean flag =false;
	  for(String windows : allTabs) 
	  {
		  driver.switchTo().window(windows);
		  Thread.sleep(4000);
		  String title = driver.getTitle();
		  System.out.println("Title:"+title);
		  if(title.equalsIgnoreCase(objProp.getProperty("DemoQANewTabTitle")))
		  {
				String pageSource = driver.getPageSource();
				if(pageSource.contains(objProp.getProperty("TextPresentInNewTab")))
				{
					flag=true;
					Assert.assertTrue(flag, "TextPresentInNewTab is not present");
				}
		  }
	  }
		driver.switchTo().window(ParentWindow);
		Assert.assertEquals(driver.getTitle(),objProp.getProperty("DemoQAWindowTitle"));
		driver.close();
  }
  
  @Test(priority=2,enabled=false)
  public void ValidateNewWindow() throws Exception
  {
	  System.out.println("inside ValidateNewWindow");
	  DemoQAPOM objDemoQAPOM = new DemoQAPOM(driver);
	  String ParentWindow = driver.getWindowHandle();
	  ScrollTillTheElement(objDemoQAPOM.newWindowBtn);
	  objDemoQAPOM.newWindowBtn.click();
	  Thread.sleep(4000);
	  Set<String> allTabs = driver.getWindowHandles();
	  System.out.println("Number of windows :" +allTabs.size());
	  boolean flag =false;
	  for(String windows : allTabs) 
	  {
		  driver.switchTo().window(windows);
		  Thread.sleep(4000);
		  String title = driver.getTitle();
		  System.out.println("Title:"+title);
		  if(title.equalsIgnoreCase(objProp.getProperty("DemoQANewTabTitle")))
		  {
				String pageSource = driver.getPageSource();
				if(pageSource.contains(objProp.getProperty("TextPresentInNewTab")))
				{
					flag=true;
					Assert.assertTrue(flag, "TextPresentInNewTab is not present");
				}
				driver.close();
		  }
	  }
		driver.switchTo().window(ParentWindow);
		Assert.assertEquals(driver.getTitle(),objProp.getProperty("DemoQAWindowTitle"));
  }
  
  @Test(priority=3)
  public void ValidateNewWindowMessage() throws Exception
  {
	  System.out.println("inside ValidateNewWindowMessage");
	  DemoQAPOM objDemoQAPOM = new DemoQAPOM(driver);
	  String ParentWindow = driver.getWindowHandle();
	  ScrollTillTheElement(objDemoQAPOM.messageWindowButton);
	  objDemoQAPOM.messageWindowButton.click();
	  Thread.sleep(4000);
	  Set<String> allTabs = driver.getWindowHandles();
	  System.out.println("Number of windows :" +allTabs.size());
	  //boolean flag =false;
	  for(String windows : allTabs) 
	  {
		  driver.switchTo().window(windows);
		  Thread.sleep(4000);
		  String title = driver.getTitle();
		  System.out.println("Title:"+title);
		  boolean newWindowMessageDisplayed = objDemoQAPOM.newWindowMessage.isDisplayed();
		  Assert.assertEquals(newWindowMessageDisplayed, true);
//		  if(title.equalsIgnoreCase(objProp.getProperty("DemoQANewTabTitle")))
//		  {
//				String pageSource = driver.getPageSource();
//				if(pageSource.contains(objProp.getProperty("TextPresentInNewTab")))
//				{
//					flag=true;
//					Assert.assertTrue(flag, "TextPresentInNewTab is not present");
//				}
//				driver.close();
//		  }
		  //driver.close();
	  }
	  driver.close();
	  driver.switchTo().window(ParentWindow);
	  Assert.assertEquals(driver.getTitle(),objProp.getProperty("DemoQAWindowTitle"));
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("inside beforeMethod");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("inside afterMethod");
  }

  @BeforeClass
  public void beforeClass()
  {
	  System.out.println("inside beforeClass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("inside afterClass");
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("inside beforeTest");
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("inside beforeSuite");
	  try 
	  {
		ReadBasePageFiles();
	} catch (IOException e) 
	{
		e.printStackTrace();
	}
	  
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("inside afterSuite");
  }

}
