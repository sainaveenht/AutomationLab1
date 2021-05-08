package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	String sheetName ="contacts";
	
	
	public ContactsPageTest() {
	   super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		
		 contactsPage = new ContactsPage();
		 contactsPage = homePage.clickOnContactsLink();
	
	}
	
	@Test(priority = 1)
	public void checkContactsLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts Label is missing");
	}
	
	@Test(priority = 2)
	public void selectContactTest()
	{
		contactsPage.selectContactsByName();
	}
	
	
	@Test(priority = 3,dataProvider = "getTestData")
	public void validateCreateNewContact(String title,String firstname,String middlename,String lastname,String company)
	{
		homePage.clickOnContactsLink();
		//contactsPage.createNewContact("Mr.", "pooja", "naveen", "sairam", "tirumal");
		contactsPage.createNewContact(title,firstname,middlename,lastname,company);
	}
	
	
	@DataProvider
	public Object[][] getTestData() 
	{
		
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
