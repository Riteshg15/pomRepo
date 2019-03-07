package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = ".//*[@id='loginForm']/div/div/input")
	
	WebElement loginBut;
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String validatepageTitle() {
		return driver.getTitle();
		
	}
	public boolean vlidateimg()
	{
		
		return crmlogo.isDisplayed();
	}
	public HomePage login(String un,String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass,Keys.ENTER);
		//loginBut.click();
		return new HomePage(); 
	}
}
