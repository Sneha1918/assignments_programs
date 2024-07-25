package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.BasePage;

public class SeleniumDevPOM extends BasePage
{
	public SeleniumDevPOM()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "myframe")
	public WebElement myFrame;
	
	@FindBy(xpath = "//body/div[text()='Simple page with simple test.']")
	public WebElement textInsideFrame;
	
	@FindBy(xpath = "//a[@id='a-link-that-opens-a-new-window']")
	public WebElement newWindowLink;
}
