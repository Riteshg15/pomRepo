package com.crm.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	@FindBy (xpath="/.//*[@id='navmenu']/ul/li[4]/a")
	WebElement contactlabel;
	 @FindBy (id="first_name")
	 WebElement FirstName;
	 @FindBy (id="middle_initial")
	 WebElement Middlename;
	 @FindBy (id="surname")
	 WebElement LastName;
	 @FindBy (xpath=".//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	 WebElement Submit;
	public ContactPage()
	{
		PageFactory.initElements(driver,this);
	}
	 public boolean verifycontactlable()
	 {
		 return contactlabel.isDisplayed();
	 }
	 /*public void selectContactByName()
	 {
		 driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[5]/td[1]/input")).click();
	 }*/
	 public void createnewContact(String title1,String firstname,String midlename, String lastname) throws InterruptedException
	 {
		 Thread.sleep(5000);
		 Select  select= new Select(driver.findElement(By.name("title")));
		 select.selectByVisibleText(title1);
		 FirstName.sendKeys(firstname);
		 Middlename.sendKeys(midlename);
		 LastName.sendKeys(lastname);
		 Submit.click();
		 Thread.sleep(5000);
		 
	}

}


