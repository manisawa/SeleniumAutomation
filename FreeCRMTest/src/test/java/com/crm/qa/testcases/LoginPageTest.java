package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.ExtentListener.ExtentReporterNG;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginPageTest extends TestBase{
	LoginPage login;
	HomePage homePage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		login=new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void pageTitleTest(){
		String HomePageTitle = login.verifyPageTitle();
		//ExtentReporterNG.extent.startTest(testName);
		//ExtentTest test = ExtentReporterNG.extent.startTest(this.getClass());
		Assert.assertEquals(HomePageTitle, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority = 2)
	public void logoTest(){
		boolean flag = login.verifyLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest(){
		homePage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
