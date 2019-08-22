package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class simpletest 
{
	public WebDriver driver ; 

	@BeforeClass
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver" ,System.getProperty("user.dir") + "/drivers/chromedriver.exe");

		driver = new ChromeDriver(); 
		driver.navigate().to("http://the-internet.herokuapp.com/");
	}

	@Test
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
	@Parameters({ "urlLink" })

	@Test
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
