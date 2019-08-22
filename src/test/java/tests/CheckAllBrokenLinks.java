package tests;

import java.net.HttpURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import Pages.HomePage;
import Pages.LoginPage;

public class CheckAllBrokenLinks extends TestBase {

	HomePage HomePageobject ;
	LoginPage Loginobject ;

	
	@Test (priority = 1)
	public void Login()
	{
		Loginobject = new LoginPage(driver);
		Loginobject.UserLogin("alfa@gmail.com","123456");

	}
	@Test (priority = 2)
	public void testBrokenLinks() 
	{
		java.util.List<WebElement> links = driver.findElements(By.tagName("a")); 
		System.out.println("Total Links are: "+ links.size());
		for (int i = 0 ; i < links.size() ; i++ ) 
		{
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			VerifyLink(url);
		}
	}


	public static void VerifyLink(String urlLink) 
	{
		try {
			URL link = new URL(urlLink);
			// create a connection using URL object
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			
			// use getResponseCode() to get the response code
			if(httpConn.getResponseCode() == 200) 
			{
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 404) {
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		}
