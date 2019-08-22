package tests;

import org.testng.annotations.Test;

import Pages.AddNewUserPopUp;
import Pages.AdminLoginPage;
import Pages.AdminmainPage;
import Pages.UserRegisrationPage;

public class AddNewUserTest extends TestBaseadmin

{
	AdminmainPage adminmainbject;
	UserRegisrationPage addpostobject;
	AdminLoginPage Adminloginobject ;
	AddNewUserPopUp  adduserobject ;

	@Test (priority = 1)
	public void Login_And_Open_New_User_Popup()
	{
		Adminloginobject = new AdminLoginPage(driver);
		Adminloginobject.Adminlogin("admin@etisalat.eg", "123456");
		adminmainbject = new AdminmainPage(driver);
		adminmainbject.openpostspage();
	}
	@Test (priority = 2)
	public void add_new_user_name ()
	{

		adduserobject = new AddNewUserPopUp(driver);
		adduserobject.addcompanyname("SODIC | سوديك	");
	}
	@Test (priority = 3)
	
	public void add_new_user_email ()
	{

		adduserobject.addcompanyemail("sodic@gmail.com");
	}
	
	@Test (priority = 4)
	public void add_new_user_password ()
	{
		adduserobject.addpassword("123456");
	}
	@Test (priority = 5)
	public void add_new_user_role ()
	{
		adduserobject.addcompanyrole("5c57c8508b5ba31aec001f72");
	}

	@Test (priority = 6)
	public void select_new_user_company ()
	{
		adduserobject.selectcompany("5c5e97ffff1f251c64002298");
	}
	@Test (priority = 7)
	public void select_new_user_compitivescompany ()
	{
		adduserobject.selectcompetitivecompanies("5c77d9b836bbaa13176141f1");
		adduserobject.selectcompetitivecompanies("5c7bb88136bbaa049826d582");

	}
	@Test (priority = 8)
	public void check_user_as_active ()
	{
		adduserobject.checkactivebox();

	}
	@Test (priority = 9)
	public void save_new_user_data ()
	{
		adduserobject.saveuserdata();
		}

}
