package com.Selenium;

import org.testng.annotations.Test;

import com.POM.SeleniumDevPOM;
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

public class Assignment10_Handling_Windows_SeleniumDev extends BasePage
{
  @Test(priority=0)
  public void LaunchSeleniumDevWindowSite() 
  {
	  System.out.println("inside LaunchSeleniumDevWindowSite");
	  driver.get(objProp.getProperty("SeleniumDevWindowUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  //System.out.println("Title :" +title);
	  Assert.assertEquals(title, objProp.getProperty("SeleniumDevWindowTitle"));
  }
  
  @Test(priority=1,enabled=false)
  public void ValidateFrame()
  {
	  System.out.println("inside ValidateFrame");
	  SeleniumDevPOM objDevPOM = new SeleniumDevPOM();
	  driver.switchTo().frame(objDevPOM.myFrame);
	  String textInFrame = objDevPOM.textInsideFrame.getText();
	  Assert.assertEquals(textInFrame, objProp.getProperty("TextInsideFrame"));
  }
  
  @Test(priority=2)
  public void ValidateNewWindow() throws Exception
  {
	  System.out.println("inside ValidateNewWindow");
	  SeleniumDevPOM objDevPOM = new SeleniumDevPOM();
	  String ParentWindow = driver.getWindowHandle();
	  objDevPOM.newWindowLink.click();
	  Set<String> allWindows = driver.getWindowHandles();
	  System.out.println("Number of windows :" +allWindows.size());
	  boolean flag =false;
	  for(String windows : allWindows) 
	  {
		  driver.switchTo().window(windows);
		  Thread.sleep(4000);
		  String title = driver.getTitle();
		  System.out.println("Title:"+title);
		  if(title.equalsIgnoreCase(objProp.getProperty("NewWindowTitile")))
		  {
				String pageSource = driver.getPageSource();
				if(pageSource.contains(objProp.getProperty("TextPresentInNewWindow")))
				{
					flag=true;
					Assert.assertTrue(flag, "TextPresentInNewWindow is not present");
				}
				driver.close();
		  }
	  }
		driver.switchTo().window(ParentWindow);
		Assert.assertEquals(driver.getTitle(),objProp.getProperty("SeleniumDevWindowTitle"));
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
