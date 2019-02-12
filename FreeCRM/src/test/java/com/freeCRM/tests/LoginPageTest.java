package com.freeCRM.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freeCRM.pages.LoginPage;
import com.freeCRM.testBase.TestBaseClass;
import com.freeCRM.utilities.Utility;

public class LoginPageTest extends TestBaseClass{
	
	LoginPage loginPage;
	
	public LoginPageTest() throws Exception
	{
		super();
	}

	@BeforeMethod
	public void start() throws Exception
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void testLoginPageTitle()
	{
		String actualTitle = loginPage.getTitle();
		Assert.assertEquals(actualTitle, Utility.loginPageTitle);
	}
}