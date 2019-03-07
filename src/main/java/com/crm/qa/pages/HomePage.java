package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: ritesh gawande')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')")
	WebElement DealsLink;

	@FindBy(xpath="//a[contains(text(),'Tasks')")
	WebElement TasksLink;
	
	//Initialize the PageObject:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyHomeTitle(){
		return driver.getTitle();	
	}
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactPage();
	}
	public  DealsPage clickOnDealsLink(){
		DealsLink.click();
		return new DealsPage();
	}
	public  TasksPage clickOnTasksLink(){
		TasksLink.click();
		return new TasksPage();
	}
}
