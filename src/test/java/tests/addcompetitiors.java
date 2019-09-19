package tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.AdminLoginPage;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;


public class addcompetitiors extends TestBaseadmin {

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
		WebElement Secondpage = driver.findElement(By.linkText("2"));
		Secondpage.click();
	}


	@Test (priority = 3)
	public void edit_company()
	{
		WebElement Companiestable = driver.findElement(By.id("addform"));
		List<WebElement> rows = Companiestable.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			List<WebElement>  cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				WebElement addtotimeline = col.findElement(By.className("btn blue btn-outline sbold add_to_timeline "));
				System.out.println(col.getText());	
				addtotimeline.click();
			}			
		}
	} 
}

