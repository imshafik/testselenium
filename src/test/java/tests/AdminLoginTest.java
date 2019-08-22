package tests;

import org.testng.annotations.Test;

import Pages.AdminLoginPage;


public class AdminLoginTest extends TestBaseadmin {

	AdminLoginPage adminpageobject ;

	@Test 
	public void admin_can_login_ssuccessfully()

	{
		adminpageobject = new AdminLoginPage(driver);
		adminpageobject.Adminlogin("admin@etisalat.eg","123456");

	}
	
}



