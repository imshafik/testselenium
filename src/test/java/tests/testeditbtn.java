package tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.AdminLoginPage;


public class testeditbtn extends TestBaseadmin {

	AdminLoginPage adminpageobject ;

	@BeforeTest 
	public void admin_can_login_ssuccessfully() throws InterruptedException

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
	public void edit_company() throws InterruptedException
	{
		WebElement Companies_table = driver.findElement(By.id("addform"));
		List<WebElement> rows = Companies_table.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement>  cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				for (int i = 0; i < cols.size(); i++) {
					WebElement addtotimeline = col.findElement(By.xpath("//a[@class='btn blue btn-outline sbold add_to_timeline ']"));
					WebElement editbtn = col.findElement(By.xpath("//a[@class='btn green btn-outline sbold editBtn']"));
					System.out.println(col.getText());	
					addtotimeline.click();	
					editbtn.click();	

				}
			}
		}
	} 
}