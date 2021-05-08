package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void TitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void crmLogoImageTest()
	{
		boolean logo = loginPage.validateCRMImage();
		Assert.assertTrue(logo);
	}
	
	
	@Test(priority = 3)
	public void loginTest()
	{
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
