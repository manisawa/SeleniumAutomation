package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory - OR:
	
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement logo;
	
	//Initializing the page Object
	public LoginPage() {
		PageFactory.initElements(driver, this);
		}
	
	
	//Actions:
	//Verify Page Title
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	
	//Verify CRM Logo
	public boolean verifyLogo(){
		return logo.isDisplayed();
	}
	
	//Login to App:
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	

}
