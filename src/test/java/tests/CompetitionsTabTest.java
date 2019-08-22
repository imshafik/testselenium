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

public class CompetitionsTabTest extends TestBase {

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
	public void OpenCompetitionstab() throws Exception 
	{
		WebElement competitionsLink = driver.findElement(By.linkText("Competitions"));
		System.out.println(competitionsLink.getAttribute("href"));	
		competitionsLink.click();
		Thread.sleep(1000L);
	}
	//print how much post in page and print fifth one title
	@Test (priority = 3)
	public void display_total_post_count() 
	{
		try {
			WebElement postsdisplayed = driver.findElement(By.id("content"));
			List<WebElement>  posts = postsdisplayed.findElements(By.className("company-name"));
		//	List<WebElement>  posts = postsdisplayed.findElements(By.className("data-id"));
			System.out.println("Total Posts after scroll are: "+ posts.size());
			System.out.println("Total Posts after scroll are: "+ posts.get(5).getText());
		} catch (NoSuchElementException  e) {	System.out.println("fix error data please ");
		}
	}

	@Test (priority = 4)
	public void Scrolldown() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for (int i = 0; i < 60; i = i + 1) {
			jse.executeScript("window.scrollBy(0, 5000)", "");
			Thread.sleep(1000L);
		}
	}

	
 //   @Parameters("browser")
    
//	@Test (priority = 6)
	//public static void VerifyLink( String urlLink) 
	{

	//	try {
		//	URL link = new URL(urlLink);
			// create a connection using URL object
		//	HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
		//	httpConn.setConnectTimeout(2000);
		//	httpConn.connect();

			// use getResponseCode() to get the response code
		//	if(httpConn.getResponseCode() == 200) 
			{
		//		System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}
		//	if (httpConn.getResponseCode() == 404) {
		//		System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}

	//	} catch (MalformedURLException e) {
	//		e.printStackTrace();

	//	} catch (IOException e) {
	//		e.printStackTrace();
	//	}
//	}
	@Test (priority = 7)
	public void testBrokenLinks() 
	{
		java.util.List<WebElement> links = driver.findElements(By.tagName("a")); 
		System.out.println("Total Links are: "+ links.size());
		for (int i = 0 ; i < links.size() ; i++ ) 
		{
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			System.out.println("post url : "+ url) ;
		//	VerifyLink(url);
		}
	}
}