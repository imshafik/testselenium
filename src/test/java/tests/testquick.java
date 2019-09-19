package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class testquick extends TestBase {

	HomePage HomePageobject ;
	LoginPage Loginobject ;

	@BeforeTest
	public void Login()
	{
		Loginobject = new LoginPage(driver);
		Loginobject.UserLogin("admin@etisalat.eg","123456");
		WebElement Globallink = driver.findElement(By.linkText("Competitions"));
		Globallink.click();
	}
	@Test (priority = 1)
	public void Check_filter_tool_bar_fields() 
	{
		//date range field exist or not 
		WebElement date_range_title = driver.findElement(By.xpath("//label[@for='filter-from-date']"));
		String date_range_Field_title = "DATE RANGE";
		Assert.assertEquals(date_range_Field_title, date_range_title.getText());
		System.out.println(date_range_title.getText() + "field is exist ");
		try {
			WebElement date_range_dropdown = driver.findElement(By.id("filter-daterange"));
			date_range_dropdown.click();
			WebElement searchbtn = driver.findElement(By.cssSelector("#front-posts > div.row.clearfix > div > form > div.row > div.col-md-1.text-left > input"));

			WebElement date_dropdown_List = driver.findElement(By.cssSelector("body > div.daterangepicker.ltr.show-ranges.opensright > div.ranges > ul"));
			List<WebElement> Date_Dropdown = date_dropdown_List.findElements(By.tagName("li"));
			for (WebElement Date : Date_Dropdown) {
				if (Date.getText().equals("Today")) {
					Date.click();
					return;
				}
				searchbtn.submit();	
				System.out.println("User can filter date using today selection ");
			}
		} catch (Exception e) { System.out.println("cannot filter using your selection because its not exist");
		}
	}
	@Test (priority = 2)
	public void change_date_to_yesterday() 
	{
		//date range field exist or not 
		try {
			WebElement date_range_dropdown = driver.findElement(By.id("filter-daterange"));
			date_range_dropdown.click();
			WebElement date_dropdown_List = driver.findElement(By.cssSelector("body > div.daterangepicker.ltr.show-ranges.opensright > div.ranges > ul"));
			List<WebElement> Date_Dropdown = date_dropdown_List.findElements(By.tagName("li"));
			for (WebElement Date : Date_Dropdown) {
				if (Date.getText().equals("Yesterday")) {
					Date.click();
					return;
				}
				System.out.println("User can filter date using Yesterday selection ");
			}
		} catch (Exception e) { System.out.println("cannot filter using your selection because its not exist");
		}
	}
	@Test (priority = 4)
	public void click_on_serach_again()
	{
		WebElement searchbtn = driver.findElement(By.cssSelector("#front-posts > div.row.clearfix > div > form > div.row > div.col-md-1.text-left > input"));
		searchbtn.submit();	
		System.out.println("User can search");		
	}

	@Test (priority = 9)
	public void display_total_post_count() 
	{
		try {

			WebElement postsdisplayed = driver.findElement(By.id("content"));
			List<WebElement>  posts = postsdisplayed.findElements(By.className("brand-name"));
			List<WebElement>  videoinsidepost = postsdisplayed.findElements(By.xpath("//i[@class='icon-line-play']"));
			System.out.println("Total displayed Posts are: "+ videoinsidepost.size());
		} catch (NoSuchElementException  e) {System.out.println("cannot count the posts in current page ");
		}
	}
	@AfterTest
	public void close_driver()
	{
		//	driver.quit();
	}
}
