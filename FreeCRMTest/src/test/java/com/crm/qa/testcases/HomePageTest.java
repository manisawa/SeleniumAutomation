package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage login;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage taskPage;
	TestUtil testUtil;


	public HomePageTest(){
		super();
	}
	
	@BeforeMethod()
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		login = new LoginPage();
		homePage=login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Title is not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserNameLabelTest(){
		testUtil.swithToFrame();
		Assert.assertTrue(homePage.verifyUserNameLabel());
		}
	
	@Test(priority = 3)
	public void verifyContactsLinkPageTest(){
		testUtil.swithToFrame();
		contactsPage = homePage.clickOnContactLink();
	}
	
	@Test(priority = 4)
	public void verifyDealsLinkPageTest(){
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority = 5)
	public void verifyTasksLinkPageTest(){
		taskPage = homePage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
	
}
