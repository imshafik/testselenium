package tests;

import org.testng.annotations.Test;

import Pages.LoginPage;

public class UserLoginTest extends TestBase {

	LoginPage Loginobject ;


	@Test (priority = 1)
	public void usercanloginssuccessfully()

	{
		Loginobject = new LoginPage(driver);
		Loginobject.UserLogin("admin@etisalat.eg","123456");
		System.out.println(driver.getCurrentUrl());

	}
	
	@Test (priority = 2)
	public void usercannotlogin()
	{
		Loginobject = new LoginPage(driver);
		Loginobject.UserLogin("","");
	}
}
