package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class TesTBrokenLinks extends TestBase {

	HomePage HomePageobject ;
	LoginPage Loginobject ;


	@BeforeTest
	public void Login()
	{
		Loginobject = new LoginPage(driver);
		Loginobject.UserLogin("admin@etisalat.eg","123456");

	}
	@Test (priority = 1)
	public void Open_Global_Page() throws Exception
	{
		WebElement Globallink = driver.findElement(By.linkText("Global"));
		System.out.println(Globallink.getAttribute("href"));	
		Globallink.click();
		Thread.sleep(1000L);
		WebElement Global_page_title = driver.findElement(By.id("page-title"));
		Thread.sleep(2000L);
		Assert.assertTrue(Global_page_title.getText().contains("GLOBAL"));
		System.out.println("this page title is " + Global_page_title.getText());
	}

	@Test (priority = 2)
	public void Check_Post_Data()
	{
		WebElement Post_Data = driver.findElement(By.cssSelector("#front-posts > div:nth-child(3) > div:nth-child(1)"));
		List<WebElement> Post_data_Elements = Post_Data.findElements(By.tagName("li"));
		System.out.println(Post_data_Elements);

		for (WebElement Post_Element_title : Post_data_Elements) 
		{
			System.out.println(Post_Element_title.getText() + "\t");
			System.out.println("");
		}
	}
	@Test (priority = 3)
	public void testBrokenLinks() 
	{
		java.util.List<WebElement> links = driver.findElements(By.tagName("a")); 
		System.out.println("Total Links are: "+ links.size());
		for (int i = 0 ; i < links.size() ; i++ ) 
		{
			WebElement element = links.get(i);
			String url = element.getAttribute("href");					
			try {
				URL link = new URL(url);
				// create a connection using URL object
				HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();
				// use getResponseCode() to get the response code
				if(httpConn.getResponseCode() == 200) 
				{
					System.out.println(url+" - "+httpConn.getResponseMessage());
					System.out.println("");
				}
				if (httpConn.getResponseCode() == 404) {
					System.out.println(url+" - "+httpConn.getResponseMessage());
					System.out.println("");
				}
			} catch (MalformedURLException e) {	
				System.out.println("error in this url  " + element.getText());
				System.out.println("error in this url  " + element.getTagName());
			} 
			catch (IOException e) {			}	
		}
	}
	@AfterTest
	public void close_driver()
	{
		driver.quit();
	}
}
