package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class HomePageLinkstest extends TestBase {

	HomePage homepageobject ;
	LoginPage Loginobject ;

	@Test (priority =1)
	public void Login() throws InterruptedException
	{
		Loginobject = new LoginPage(driver);
		Loginobject.UserLogin("admin@etisalat.eg","123456");
		Thread.sleep(2000);

	}
	@Test (priority =2)
	public void opentimelinepage() throws Exception 
	{
		WebElement TimeLinelink = driver.findElement(By.partialLinkText("timeline"));
		System.out.println(TimeLinelink.getAttribute("href"));	
		TimeLinelink.click();
		Thread.sleep(1000L);
	}
	@Test (priority =3)
	public void openglobalpage() throws Exception 
	{
		WebElement Globallink = driver.findElement(By.linkText("Global"));
		System.out.println(Globallink.getAttribute("href"));	
		Globallink.click();
		Thread.sleep(1000L);
	}
	@Test (priority = 4)
	public void openmypagepage() throws Exception 
	{
		WebElement mypagelink = driver.findElement(By.linkText("My Page"));
		System.out.println(mypagelink.getAttribute("href"));	
		mypagelink.click();
		Thread.sleep(1000L);
	}
	
	@Test (priority = 5)
	public void OpenCompetitionstab() throws Exception 
	{
		WebElement competitionsLink = driver.findElement(By.linkText("Competitions"));
		System.out.println(competitionsLink.getAttribute("href"));	
		competitionsLink.click();
		Thread.sleep(1000L);
	}
	}
