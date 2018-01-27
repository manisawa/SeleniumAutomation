package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	
	public DealsPageTest(){		
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		dealsPage = new DealsPage();		
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.swithToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=1)
	public void verifyDealsTitleTest(){
		Assert.assertTrue(dealsPage.verifyTitle());
	}
	
	@Test(priority=2)
	public void selectDealByTitleTest(){
		dealsPage.selectDealByTitle(prop.getProperty("title"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
