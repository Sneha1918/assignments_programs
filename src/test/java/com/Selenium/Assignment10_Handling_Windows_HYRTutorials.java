package com.Selenium;

import org.testng.annotations.Test;

import com.POM.HYRTutorialsPOM;
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

public class Assignment10_Handling_Windows_HYRTutorials extends BasePage
{
  @Test(priority=0)
  public void LaunchHYRTutorialSite() 
  {
	  System.out.println("inside LaunchHYRTutorialSite");
	  driver.get(objProp.getProperty("HYRTutorialWindowUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  //System.out.println("Title :" +title);
	  Assert.assertEquals(title, objProp.getProperty("HYRTutorialWindowTitle"));
  }
  
  @Test(priority=1,enabled=false)
  public void ValidateOpenNewWindow() throws Exception
  {
	  System.out.println("inside ValidateOpenNewWindow");
	  HYRTutorialsPOM hyrPOM = new HYRTutorialsPOM(driver);
	  ScrollTillTheElement(hyrPOM.newWindowBtn);
	  String ParentWindow = driver.getWindowHandle();
	  hyrPOM.newWindowBtn.click();
	  Thread.sleep(4000);
	  Set<String> allWindows = driver.getWindowHandles();
	  System.out.println("Number of windows :" +allWindows.size());
	  boolean flag =false;
	  for(String windows : allWindows) 
	  {
		  driver.switchTo().window(windows);
		  Thread.sleep(4000);
		  driver.manage().window().maximize();
		  String title = driver.getTitle();
		  System.out.println("Title:"+title);
		  if(title.equalsIgnoreCase(objProp.getProperty("HYRTutorialNewWindowTitile")))
		  {
				String pageSource = driver.getPageSource();
				if(pageSource.contains(hyrPOM.pageHeader.getText()))
				{
					flag=true;
					Assert.assertTrue(flag, "Page Header is not present");
				}
				driver.close();
		  }
	  }
		driver.switchTo().window(ParentWindow);
		Assert.assertEquals(driver.getTitle(),objProp.getProperty("HYRTutorialWindowTitle"));
  }
  
  @Test(priority=2)
  public void ValidateMultipleWindows() throws Exception
  {
	  System.out.println("inside ValidateMultipleWindows");
	  HYRTutorialsPOM hyrPOM = new HYRTutorialsPOM(driver);
	  ScrollTillTheElement(hyrPOM.newMultipleWindowsBtn);
	  String ParentWindow = driver.getWindowHandle();
	  hyrPOM.newMultipleWindowsBtn.click();
	  Thread.sleep(4000);
	  Set<String> allWindows = driver.getWindowHandles();
	  System.out.println("Number of windows :" +allWindows.size());
	  boolean flag =false;
	  for(String windows : allWindows) 
	  {
		  driver.switchTo().window(windows);
		  Thread.sleep(4000);//explicit wait
		  driver.manage().window().maximize();
		  String title = driver.getTitle();
		  System.out.println("Title:"+title);
		  if(title.equalsIgnoreCase(objProp.getProperty("HYRTutorialNewWindowTitile")))
		  {
				String pageSource = driver.getPageSource();
				if(pageSource.contains(hyrPOM.pageHeader.getText()))
				{
					flag=true;
					Assert.assertTrue(flag, "Page Header is not present");
				}
				driver.close();
		  }
		  else if(title.equalsIgnoreCase(objProp.getProperty("HYRTutorialNewWindowTitile2")))
		  {
				String pageSource = driver.getPageSource();
				driver.manage().window().maximize();
				if(pageSource.contains(hyrPOM.titleInsideMultipleWindow.getText()))
				{
					flag=true;
					Assert.assertTrue(flag, "Title is not present");
				}
				driver.close();
		  }
	  }
		driver.switchTo().window(ParentWindow);
		Assert.assertEquals(driver.getTitle(),objProp.getProperty("HYRTutorialWindowTitle"));
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
