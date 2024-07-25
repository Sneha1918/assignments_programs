package com.Selenium;

import org.testng.annotations.Test;

import com.POM.DemoQAPOM;
import com.Utility.BasePage;
import com.Utility.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Assignment11_Drag_And_Drop_DemoQA extends BasePage
{
  @Test(priority=0)
  public void LaunchDemoQASite() 
  {
	  System.out.println("inside LaunchDemoQASite");
	  driver.get(objProp.getProperty("DemoQADragAndDropUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  //System.out.println("Title :" +title);
	  Assert.assertEquals(title, objProp.getProperty("DemoQADragAndDropTitle"));
  }
  
  @Test(priority=1)
  public void CalendarDragAndDrop()
  {
	  System.out.println("inside CalendarDragAndDrop");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  ScrollTillTheElement(objAlertPOM.dateOfBirthInput);
	  objAlertPOM.dateOfBirthInput.click();
	  
	  Select objMonth = new Select(objAlertPOM.monthDropDown);
	  objMonth.selectByVisibleText(objProp.getProperty("Month"));
	  Select objYear = new Select(objAlertPOM.yearDropDown);
	  objYear.selectByValue(objProp.getProperty("Year"));
	  
	  List<WebElement>allDaysInCalendar = objAlertPOM.allCalendarDays; 
	  for(int i=0;i<=allDaysInCalendar.size();i++)
	  {
		  String dayFromCalendar = allDaysInCalendar.get(i).getText();
		  if(dayFromCalendar.equals(objProp.getProperty("CalendarDay")))
		  {
			  allDaysInCalendar.get(i).click();
			  break;
		  }
	  }
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
