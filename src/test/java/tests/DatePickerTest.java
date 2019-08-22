package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.DatePickerPage;
import Pages.HomePage;
import Pages.LoginPage;

public class DatePickerTest extends TestBase{

	private DatePickerPage datePickerPage;
	LoginPage LoginObject ;
	HomePage HomePageObject ;

	@Test (priority = 1)
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
	

	@Test(dataProvider = "inputDates")
	public void dateTest(String ipDate, String opDate) {
		datePickerPage.goTo();
		datePickerPage.getDatePicker().setDate(ipDate);

		
	}

	@DataProvider(name = "inputDates")
	public void selectdate ()
	{
		datePickerPage.clickselecteddate();
	}
}


