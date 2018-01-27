package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsTitle;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@name='company_position']")
	WebElement position;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}	
	
	public boolean verifyContactsTitle(){
		return contactsTitle.isDisplayed();
	}
	
	public void selectContactByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td"
				+ "//child::input[@name='contact_id']")).click();
	}
	
	public void addNewContactTest(String title, String fName, String lName, String cName, String pName){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByValue(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(cName);
		position.sendKeys(pName);
		saveBtn.click();
	}
	

}
