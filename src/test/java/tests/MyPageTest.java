package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class MyPageTest extends TestBase {

	LoginPage LoginObject ;
	HomePage HomePageObject ;

	@Test  (priority = 1)
	public void Login() throws InterruptedException
	{
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin("admin@etisalat.eg","123456");
		Thread.sleep(5000);
	}
	@Test (priority = 2)
	public void openmypagepage() throws Exception 
	{
		WebElement mypagetitle = driver.findElement(By.id("page-title"));
		Thread.sleep(1000L);
		Assert.assertTrue(mypagetitle.getText().contains("PAGE"));
		System.out.println("this page title is " + mypagetitle.getText());
	}

	@Test (priority = 3)
	public void databloks() throws Exception 
	{
		WebElement datablocksrow = driver.findElement(By.cssSelector("#my-page > section.grid.bg-grey > div > div.row.topmargin-sm"));
		System.out.println("this page blocks is " + datablocksrow.getTagName());
		List<WebElement> blocksdesc = datablocksrow.findElements(By.className("desc"));
		System.out.println("this page blocks size is " + blocksdesc.size());
		assertEquals(4, blocksdesc.size());
		List<WebElement> blocksdata = datablocksrow.findElements(By.className("details"));
		
		for (WebElement block_data : blocksdata) 
		{
			System.out.println(block_data.getText() + "\t");
			System.out.println("");
		}
		System.out.println("");
		System.out.println("all blocks description and  data is exist");
	}
}


