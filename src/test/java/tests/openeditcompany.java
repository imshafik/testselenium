package tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.AdminLoginPage;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;


public class openeditcompany extends TestBaseadmin {

	AdminLoginPage adminpageobject ;
	@BeforeTest 
	public void admin_can_login_ssuccessfully()

	{
		adminpageobject = new AdminLoginPage(driver);
		adminpageobject.Adminlogin("admin@gmail.com","123456");

	}

	@Test (priority = 1)

	public void open_companies_page()
	{
		WebElement companiestab = driver.findElement(By.linkText("Companies"));
		companiestab.click();
	}

	@Test (priority = 2 )
	public void open_Second_Page_in_companies_page()
	{
		WebElement Secondpage = driver.findElement(By.linkText("3"));
		Secondpage.click();
	}


	@Test (priority = 3)
	public void edit_company()
	{
		WebElement  editbtn ;
		

			for (int row =5  ; row <10 ; row ++ ) {
		editbtn = driver.findElement(By.xpath("//*[@id=\"addform\"]/tbody/tr["+ row +"]/td[5]/span/a[1]"));		
		editbtn.click();
		System.out.println(editbtn.getLocation());
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+editbtn.getLocation().y+")");
		}
			
		
		WebElement compeitiorslistmenu = driver.findElement(By.id("competitive_companies"));
		Select compititorslist = new Select (compeitiorslistmenu);
		for (int i=0 ; i<25 ; i++ ) {
		compititorslist.selectByIndex(i);
	
		}
	}		
		
		@Test (priority = 4)
		public void save()
		{
			WebElement savebtn = driver.findElement(By.cssSelector("#ajax > div > div > div > div > div > form > div.modal-footer > input"));
			savebtn.click();		
		}
	}


