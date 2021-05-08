package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase 
{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="middle_initial")
	WebElement MiddleName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(id="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[4]/ul/li[1]/a")
	WebElement newContactLink;
	
	
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
		
	public ContactsPage()
	{
	   PageFactory.initElements(driver, this);	
	}
	
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName()
	{
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[7]/td[2]/a")).click();
		
	}
	
	public void createNewContact(String title,String fn,String mn,String ln,String cname)
	{
		Select select1 = new Select(driver.findElement(By.name("title")));
		select1.selectByVisibleText(title);
		firstName.sendKeys(fn);
		MiddleName.sendKeys(mn);
		LastName.sendKeys(ln);
		companyName.sendKeys(cname);
		saveBtn.click();
		
		
		
	}
	
	
	
}
