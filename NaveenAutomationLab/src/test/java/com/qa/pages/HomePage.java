package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase 
{

	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement useNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	  public String verifyHomePageTitle()
	  {
		  return driver.getTitle();
	  }
	
	  
	  public boolean verifyUserName()
	  {
		  return useNameLabel.isDisplayed();
	  }
	  
	  
	  public ContactsPage clickOnContactsLink()
	  {
		  contactsLink.click();
		  return new ContactsPage();
		  
	  }
	
	  public DealsPage clickOnDealsLink()
	  {
		  dealsLink.click();
		  return new DealsPage();
	  }
	
	
	 public TasksPage clcikOnTasksLink()
	 {
		 tasksLink.click();
		 return new TasksPage();
	 }
	
	
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	
	
	
	
	
	
	
	
}
