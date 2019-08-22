package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.searchsource;
import Pages.sourcespageafterfilter;

public class serachpagetest extends TestBase{

	String sourcename =" Facebook" ;
	String sourcename2 =" Twitter" ;
	String sourcename3 =" hgfhfh" ;
	searchsource searchobject ;
	LoginPage loginobject ;
	sourcespageafterfilter serachedpageobject ;

	@Test  (priority = 1)
	public void Login() throws InterruptedException
	{
		loginobject = new LoginPage(driver);
		loginobject.UserLogin("admin@etisalat.eg","123456");
		Thread.sleep(1000);
	}
	@Test (priority = 2)
	public void openglobalpage() throws Exception 
	{
		WebElement Globallink = driver.findElement(By.linkText("Global"));
		System.out.println(Globallink.getAttribute("href"));	
		Globallink.click();
		Thread.sleep(1000L);
	}

	@Test(priority = 3)

	public void user_can_search_for_valid_source ()
	{
		searchobject = new searchsource(driver) ;
		serachedpageobject = new sourcespageafterfilter(driver) ;
		searchobject.addsource(sourcename);
	}
	@Test(priority = 4)
	public void user_can_search_for_valid_source_again ()
	{
		searchobject.addsource(sourcename2);
	}
	@Test(priority = 5)
	public void user_can_search_for_invalid_source ()
	{
		WebElement errormessage = driver.findElement(By.className("inner open"));
		searchobject.addsource(sourcename3);
		Assert.assertTrue(errormessage.getText().contains("No results"));

	}

	@Test (priority = 6)
	public void totalpostsdisplayed() 
	{
		List<WebElement>  posts = driver.findElements(By.xpath("//div[@class='row clearfix overview article white-panel']"));
		Assert.assertEquals(sourcename, sourcename);
		System.out.println("Total Posts are: "+ posts.size());
	}
}
