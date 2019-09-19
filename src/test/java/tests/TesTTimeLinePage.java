package tests;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class TesTTimeLinePage extends TestBase{


		LoginPage LoginObject ;
		HomePage HomePageObject ;

		@BeforeTest
		public void  Open_timeline_page() throws Exception 
		{
			WebElement TimeLinelink = driver.findElement(By.partialLinkText("Time"));
			System.out.println(TimeLinelink.getAttribute("href"));	
			TimeLinelink.click();
			Thread.sleep(1000L);
		}

		@Test (priority = 1)
		public void Scrolldown() throws InterruptedException
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			for (int i = 0; i < 2; i = i + 1) {
				jse.executeScript("window.scrollBy(0, 1000)", "");
				Thread.sleep(1000L);
			}
		}
		@Test (priority = 2)
		public void totalpostsdisplayed() 
		{
			List<WebElement>  posts = driver.findElements(By.xpath("//h4[@class='bottommargin-20 pull-left']"));
			System.out.println("Total Posts are: "+ posts.size());
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
				System.out.println("post url : "+ url) ;
				VerifyLink(url);
			}
		}
		@org.testng.annotations.Parameters ({ "urlLink" })
		
		@Test (priority = 6)
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
