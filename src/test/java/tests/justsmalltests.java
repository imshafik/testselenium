


	package tests;
	
	import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.List;
	import org.testng.annotations.Parameters;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

	import Pages.HomePage;
	import Pages.LoginPage;

	public class justsmalltests extends TestBase {

		LoginPage LoginObject ;
		HomePage HomePageObject ;

		@Test  (priority = 1)
		public void Login() throws InterruptedException
		{
			LoginObject = new LoginPage(driver);
			LoginObject.UserLogin("admin@etisalat.eg","123456");
			Thread.sleep(1000);
		}
		@Test (priority = 2)
		public void OpenCompetitionstab1() throws Exception 
		{
			WebElement competitionsLink = driver.findElement(By.linkText("Competitions"));
			System.out.println(competitionsLink.getAttribute("href"));	
			competitionsLink.click();
		}
		
			@Test (priority = 3)
			public void display_primary_menu() 
			{
				try {
					WebElement pagetabs = driver.findElement(By.id("primary-menu"));
					List<WebElement>  tabs = pagetabs.findElements(By.tagName("li"));
					System.out.println("Total tabs are: "+ tabs.size());
					System.out.println("third tab is: "+ tabs.get(2).getText());
					System.out.println("third tab is: "+ tabs.get(0).getText());
					System.out.println("----------------------------- ");
				} catch (IndexOutOfBoundsException  e) {	System.out.println("fix error data please ");
				}
			}
			
					
		@Test (priority = 4)
		public void display_page_Tabs() 
		{
			try {
				WebElement pagetabs = driver.findElement(By.id("page-menu-wrap"));
				List<WebElement>  tabs = pagetabs.findElements(By.tagName("li"));
				System.out.println("Total tabs are: "+ tabs.size());
				System.out.println("third tab is: "+ tabs.get(2).getText());
				System.out.println("third tab is: "+ tabs.get(0).getText());
				tabs.get(2).click();
				System.out.println("----------------------------- ");
			} catch (IndexOutOfBoundsException  e) {	System.out.println("fix error data please ");
			}
		}
		
		@Test (priority = 5)
		public void display_total_post_count() 
		{
			try {
				WebElement postsdisplayed = driver.findElement(By.id("content"));
				List<WebElement>  posts = postsdisplayed.findElements(By.className("company-name"));
			//	List<WebElement>  posts = postsdisplayed.findElements(By.className("data-id"));
				System.out.println("Total Posts after scroll are: "+ posts.size());
				System.out.println("Total Posts after scroll are: "+ posts.get(2).getText());
				System.out.println("----------------------------- ");
			} catch (NoSuchElementException  e) {	System.out.println("fix error data please ");
			}
		}
		@Test (priority = 6)
		public void checkdatemenu() 
		{
			try {
				WebElement datemenu = driver.findElement(By.cssSelector("input#form-control tleft"));
				List<WebElement>  datetabs = datemenu.findElements(By.tagName("li"));
			//	List<WebElement>  posts = postsdisplayed.findElements(By.className("data-id"));
				System.out.println("Total li tabs are : "+ datetabs.size());
				System.out.println("second tab is: "+ datetabs.get(2).getText());
				System.out.println("----------------------------- ");
			} catch (NoSuchElementException  e) {	System.out.println("fix error data please ");
			}
		}
	}
	
