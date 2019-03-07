package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage logInPage;
	HomePage homePage;

	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		logInPage = new LoginPage();

	}

	@Test(priority = 1)

	public void loginpageTitle() throws InterruptedException {
		Thread.sleep(5000);
		String title = logInPage.validatepageTitle();
		AssertJUnit.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void crmLogoimageTest() {
		boolean flag = logInPage.vlidateimg();
		AssertJUnit.assertTrue(flag);
	}

	@Test(priority = 3)
	public void login() {
		homePage = logInPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
      driver.quit();
	}

}
