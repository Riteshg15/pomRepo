package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fio = new FileInputStream(
					"E:\\maven_p\\PageObjectModelProject1\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fio);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
	String browserName=prop.getProperty("browser");
	
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Driver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", "E:\\Selenium Driver\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.implicite_timeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}