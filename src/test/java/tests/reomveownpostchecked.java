package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.AdminLoginPage;
import Pages.AdminmainPage;

public class reomveownpostchecked extends TestBaseadmin{


	AdminmainPage adminmainbject;
	AdminLoginPage Adminloginobject ;

	@Test (priority = 1)
	public void Login_And_Open_New_User_Popup()
	{
		Adminloginobject = new AdminLoginPage(driver);
		Adminloginobject.Adminlogin("admin@etisalat.eg", "123456");
		adminmainbject = new AdminmainPage(driver);
		adminmainbject.editpostspage();

	}

	@Test (priority = 5)
	public void testBrokenLinks() 
	{

		java.util.List<WebElement> edits = driver.findElements(By.xpath("//a[@class='btn green btn-outline sbold editBtn']")); 
		System.out.println("Total Links are: "+ edits.size());
		for (int i = 0 ; i < edits.size() ; i++ ) 
		{
			WebElement element = edits.get(i);

			((WebElement) element).click();
			adminmainbject.ownpost();
			String url = element.getAttribute("href");
			System.out.println("post url : "+ url) ;

		}


		
		
		}
	}
