package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage logInPage;
	HomePage homePage;
	TestUtil testutil;
	 ContactPage contactsPage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		logInPage = new LoginPage();
		homePage=logInPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil=new TestUtil();
		contactsPage=new ContactPage();
	}

	@Test(priority = 1)

	public void verifyHomePage(){
		String title = homePage.verifyHomeTitle();
		AssertJUnit.assertEquals(title, "CRMPRO");
	}

	@Test(priority = 2)
	public void verifyUser() {
		testutil.SwitchToFrame();
		AssertJUnit.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifycontactclick(){
	 homePage =new HomePage();
		testutil.SwitchToFrame();
	 contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
      driver.quit();
	}
}
