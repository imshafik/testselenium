package tests;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;


public class TesTBrokenImages extends TestBase {


	HomePage HomePageobject ;
	LoginPage Loginobject ;
	private int invalidImageCount; 

	@BeforeTest 
	public void Login()
	{
		Loginobject = new LoginPage(driver);
		Loginobject.UserLogin("admin@etisalat.eg","123456");
	}
	@Test (priority = 1)
	public void Open_global_page() throws Exception 
	{
		WebElement Globallink = driver.findElement(By.linkText("Global"));
		System.out.println(Globallink.getAttribute("href"));	
		Globallink.click();
		Thread.sleep(1000L);
		WebElement Global_page_title = driver.findElement(By.id("page-title"));
		Thread.sleep(1000L);
		Assert.assertTrue(Global_page_title.getText().contains("GLOBAL"));
		System.out.println("this page title is " + Global_page_title.getText());
	}

	@Test (priority = 2)
	public void Scrolldown() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for (int i = 0; i < 1; i = i + 1) {
			jse.executeScript("window.scrollBy(0, 5000)", "");
			Thread.sleep(1000L);

		}
	}
	@Test(priority = 3)
	public void testBrokenImages() 
	{
		invalidImageCount = 0 ; 
		List<WebElement> imageList = driver.findElements(By.tagName("img")); 
		for(WebElement imgElement : imageList) 
		{
			if (imgElement != null) 
			{
				VerifyImageActive(imgElement);
			}
		}
		System.out.println("Total no. of invalid Images are : " + invalidImageCount);
	}
	@Parameters ({"imgElement"})
	@Test(priority = 5)

	public void VerifyImageActive(WebElement imgElement) 
	{
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(imgElement.getAttribute("src"));

		try {
			HttpResponse response = client.execute(request);

			if (response.getStatusLine().getStatusCode() != 200) {
				invalidImageCount++ ; 
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}