package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement dealsTitle;
	
	public DealsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTitle(){
		return dealsTitle.isDisplayed();
	}
	
	public void selectDealByTitle(String name){
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}
	

}
