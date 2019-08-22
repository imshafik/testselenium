package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class ScrolltobottomTest extends TestBase {

	HomePage HomePageobject ;
	LoginPage Loginobject ;

	
	@Test (priority = 1)
	public void Login()
	{
		Loginobject = new LoginPage(driver);
		Loginobject.UserLogin("admin@etisalat.eg","123456");

	}
	@Test (priority = 2)
	public void openmypage() throws Exception
	{
        Thread.sleep(3000L);
	}
	
	@Test (priority = 3)
	public void Scrolldown() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
        for (int i = 0; i < 5; i = i + 1) {
        jse.executeScript("window.scrollBy(0, 20000)", "");
        Thread.sleep(1000L);
        }
        }
	@Test (priority = 4)
	public void totalpostsdisplayed() 
	{
		List<WebElement>  posts = driver.findElements(By.xpath("//p[@class='company-name']"));
		System.out.println("Total Posts are: "+ posts.size());
		
		
	}
	
		
}
