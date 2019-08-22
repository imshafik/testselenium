package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.commentsfrommypage;



public class opencommentpage extends TestBase {


	LoginPage LoginObject ;
	HomePage HomePageObject ;
	commentsfrommypage Commentspageobject ;


	@Test  (priority = 1)
	public void Login() throws InterruptedException
	{
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin("admin@etisalat.eg","123456");
		Thread.sleep(2000);
	}



	@Test (priority = 2) 
	public void openviewanalisyspage() throws InterruptedException 
	{
		WebElement viewanalisys = driver.findElement(By.xpath("//a[@href='https://test.epsilonsocial.com/my-page/5cff86c4206627469e4d2223/show']"));
		System.out.println(viewanalisys.getAttribute("href"));	
		viewanalisys.click();
		Thread.sleep(2000);


	}
	@Test (priority = 3)
	public void opencomments() 
	{
		WebElement opencomments = driver.findElement(By.xpath("//a[@href='https://test.epsilonsocial.com/my-page/5cff86c4206627469e4d2223/comments']"));
		System.out.println(opencomments.getAttribute("href"));	
		opencomments.click();

	}
}
