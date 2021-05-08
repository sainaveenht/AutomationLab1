package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase
{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	TestUtil testUtil;
	
	public HomePageTest() 
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
		
		
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitle()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","HomePage Not Matching");
	}
	
	@Test(priority = 2)
	public void verifyLoginUser()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority = 3)
	public void openContactsPage()
	{ 
		
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority = 4)
	public void openDealsPage()
	{
	
		dealsPage=homePage.clickOnDealsLink();
	}
	
	@Test(priority = 5)
	public void openTasksPage()
	{
		
		tasksPage=homePage.clcikOnTasksLink();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
