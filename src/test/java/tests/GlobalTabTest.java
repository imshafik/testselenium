package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class GlobalTabTest extends TestBase {
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
	public void openglobalpage() throws Exception 
	{
		WebElement Globallink = driver.findElement(By.linkText("Global"));
		System.out.println(Globallink.getAttribute("href"));	
		Globallink.click();
		Thread.sleep(1000L);
	}

	@Test (priority = 3)
	public void Scrolldown() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for (int i = 0; i < 3; i = i + 1) {
			jse.executeScript("window.scrollBy(0, 3000)", "");
			Thread.sleep(1000L);
		}
	}
	@Test (priority = 4)
	public void totalpostsdisplayed() 
	{
		List<WebElement>  posts = driver.findElements(By.xpath("//div[@class='row clearfix overview article white-panel']"));
		System.out.println("Total Posts are: "+ posts.size());
	}


	@Test (priority = 5)
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

			if (link.getContent() != null) {
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());

			}
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 7)
	public void anotherTestMethod() {
		ITestResult result = Reporter.getCurrentTestResult();
		System.err.println("Running " + result.getMethod().getConstructorOrMethod().getMethod().getName());
	}
}