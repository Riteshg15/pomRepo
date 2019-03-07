package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase {
	
	 LoginPage logInpage;
	 HomePage homePage;
	 TestUtil testUtil;
	 ContactPage contactsPage;
	 String sheetname="Sheet1";  
	 
	 public ContactsPageTest()
		
	 {
		 super();
	 }
	 @BeforeMethod
	 public void setup()
	 {
		 initialization();
		 testUtil= new TestUtil();
		 logInpage=new LoginPage();
		 contactsPage= new ContactPage();
		 homePage=new HomePage();
		 logInpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testUtil.SwitchToFrame();
	    contactsPage=homePage.clickOnContactsLink();
	 }
     @Test(priority=1)
     public  void verifycontactPageLabel()
    
     {
    	 Assert.assertTrue(contactsPage.verifycontactlable());
    	 
     } 
    /* @Test(priority=2)
     public void selectcontactTest()
     {
    	 contactsPage.selectContactByName();
     }*/
     @DataProvider(name="TestData")
     public Object [][] getcrmdata(String sheetname)
     {
    	 Object data[][]=TestUtil.getTestData(sheetname);
     return data;
     }
     
     
     
      @Test(priority=2,dataProvider="TestData")
     public void validateCreateContact(String title,String fname, String mname,String lname ) throws InterruptedException
     {
    	 homePage.clickOnContactsLink();
    	 //contactsPage.createnewContact("Mr.", "Ritesh","V", "Gawande");
     contactsPage.createnewContact(title, fname, mname, lname);
     
     }
     
     
	 @AfterMethod
	 public void tearDown()
	 {
		 driver.quit();
	 }
	 
	}
