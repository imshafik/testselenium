package tests;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.CompetitionsPage;
import Pages.HomePage;
import Pages.LoginPage;

public class TestFiltersToolbarinCcompetitions extends TestBase {

	LoginPage LoginObject ;
	HomePage HomePageObject ;
	CompetitionsPage competitionsfiltertoolbarobject   ;
	

	@Test  (priority = 1)
	public void Login() throws InterruptedException
	{
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin("admin@gmail.com","123456");
		Thread.sleep(1000);
	}
	@Test (priority = 2)
	public void OpenCompetitionstab() throws Exception 
	{
		WebElement competitionsLink = driver.findElement(By.linkText("Competitions"));
		System.out.println(competitionsLink.getAttribute("href"));	
		competitionsLink.click();
		Thread.sleep(1000L);
	}

	@Test (priority = 2)
	public void select_company_posts() throws Exception 
	{
		competitionsfiltertoolbarobject.selectcompanyfromlist();
		competitionsfiltertoolbarobject.clickonserachbtn();
		Thread.sleep(1000L);
	}
	




	
}