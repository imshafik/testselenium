package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class TesTGlobalPage extends TestBase {

	LoginPage LoginObject ;
	HomePage HomePageObject ;
	String TagSearchData = "WE";


	@BeforeTest 
	public void Login() throws InterruptedException
	{
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin("admin@etisalat.eg","123456");
		Thread.sleep(1000);
	}
	@Test (priority = 1)
	public void Open_global_page() throws Exception 
	{
		WebElement Globallink = driver.findElement(By.linkText("Global"));
		System.out.println(Globallink.getAttribute("href"));	
		Globallink.click();
		Thread.sleep(1000L);
		WebElement Global_page_title = driver.findElement(By.id("page-title"));
		Assert.assertTrue(Global_page_title.getText().contains("GLOBAL"));
		System.out.println("this page title is " + Global_page_title.getText());

	}

	@Test (priority = 2)
	public void display_primary_menu() 
	{
		try {
			WebElement pagetabs = driver.findElement(By.id("primary-menu"));
			List<WebElement>  tabs = pagetabs.findElements(By.tagName("li"));
			System.out.println("Total tabs are: "+ tabs.size());
			System.out.println("third tab is: "+ tabs.get(2).getText());
			System.out.println("third tab is: "+ tabs.get(0).getText());
			System.out.println("----------------------------- ");
		} catch (IndexOutOfBoundsException  e) {	System.out.println("fix error data please ");
		}
	}


	//print how much post in page and print fifth one title
	@Test (priority = 3)
	public void Check_Menu_Tabs() 
	{
		WebElement Manutabs = driver.findElement(By.id("page-menu"));
		List<WebElement> Tabs = Manutabs.findElements(By.tagName("li"));
		System.out.println("Tabs in menu  " + Tabs.size());
		Assert.assertEquals(3, Tabs.size());
		for (WebElement Tab_Title1 : Tabs) 
		{
			System.out.println(Tab_Title1.getText() + "\t");
			System.out.println("");
		}
	}
	@Test (priority = 4)
	public void Check_filter_tool_bar_fields() 
	{
		//date range field exist or not 

		WebElement date_range_title = driver.findElement(By.xpath("//label[@for='filter-from-date']"));
		String date_range_Field_title = "DATE RANGE";
		Assert.assertEquals(date_range_Field_title, date_range_title.getText());
		System.out.println(date_range_title.getText() + "field is exist ");


		//source dropdown exist or not 

		WebElement Source_title = driver.findElement(By.cssSelector("#front-posts > div.row.clearfix > div > form > div.row > div:nth-child(2) > label"));
		String source_Field_title = "SOURCE";
		Assert.assertEquals(source_Field_title, Source_title.getText());
		System.out.println( Source_title.getText() + " field is exist ");

		//Tags dropdown exist or not 

		WebElement Tags_title = driver.findElement(By.cssSelector("#front-posts > div.row.clearfix > div > form > div.row > div:nth-child(3) > label"));
		String Tags_Field_title = "TAGS";
		Assert.assertEquals(Tags_Field_title, Tags_title.getText());
		System.out.println( Tags_title.getText() + " field is exist ");

		//boosted  exist or not 

		WebElement Boosted_checkbos = driver.findElement(By.id("filter-boosted"));
		System.out.println(" Boosted checkbox field is exist ");

		//search button exist or not 

		WebElement search_button = driver.findElement(By.cssSelector("#front-posts > div.row.clearfix > div > form > div.row > div.col-md-1.text-left > input"));
		System.out.println(" search button is exist ");


		//Tags dropdown exist or not 

		WebElement post_count_result_title = driver.findElement(By.cssSelector("#front-posts > div:nth-child(2) > div > span.label.label-default > i"));
		System.out.println(" Result field is exist ");
		System.out.println("");

	}
	@Test (priority = 5)
	public void display_total_post_count() 
	{
		try {
			WebElement postsdisplayed = driver.findElement(By.id("content"));
			List<WebElement>  posts = postsdisplayed.findElements(By.className("company-name"));
			//	List<WebElement>  posts = postsdisplayed.findElements(By.className("data-id"));
			System.out.println("Total displayed Posts are: "+ posts.size());
			System.out.println("");
		} catch (NoSuchElementException  e) {	System.out.println("cannot count the posts in current page ");
		}
	}

	@Test (priority = 6)
	public void User_can_scroll_down () throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for (int i = 0; i < 1; i = i + 1) {
			jse.executeScript("window.scrollBy(0, 1000)", "");
			Thread.sleep(1000L);
		}
	}
	@Test (priority = 7)
	public void check_companies_counts()
	{
		try {
			WebElement companies = driver.findElement(By.id("companyElement"));
			Select selectonecompany = new Select(companies);

			// check if company elements  count like admin page or not
			Assert.assertEquals(4, selectonecompany.getOptions().size());

		} catch (Exception e) { 
			System.out.println("cannot assert companies because its not exist in current page");

		}
	}
	@Test (priority = 8)
	public void user_can_filter_by_date()
	{
		try {
			//select date 
			WebElement date_range_dropdown = driver.findElement(By.id("filter-daterange"));
			date_range_dropdown.click();
			WebElement date_dropdown_List = driver.findElement(By.cssSelector("body > div.daterangepicker.ltr.show-ranges.opensright > div.ranges > ul"));
			List<WebElement> Date_Dropdown = date_dropdown_List.findElements(By.tagName("li"));
			for (WebElement Date : Date_Dropdown) {
				if (Date.getText().equals("Today")) {
					Date.click();
					return;
				}
				System.out.println("User can filter date using today selection ");
			}
		} catch (Exception e) { System.out.println("cannot filter using your selection because its not exist");
		}
	}
	@Test (priority = 9)
	public void user_can_filter_by_company()
	{
		try {	
			// select company 

			WebElement companies = driver.findElement(By.id("companyElement"));
			Select selectonecompany = new Select(companies);
			selectonecompany.selectByVisibleText("WE");
			Assert.assertFalse(selectonecompany.isMultiple());
			Assert.assertEquals(4, selectonecompany.getOptions().size());
		} catch (Exception e) { System.out.println("cannot filter using company because its not exist in current page");

		}
	}
	@Test (priority = 10)
	public void check_source_counts()
	{

		WebElement Sources = driver.findElement(By.id("sourcesElement"));
		Select selectonesource = new Select(Sources);
		// check if source is multi or not 
		Assert.assertFalse(selectonesource.isMultiple());
		// check if source count like admin page or not
		Assert.assertEquals(9, selectonesource.getOptions().size());
	}

	@Test (priority = 11)
	public void user_can_filter_by_source()
	{

		WebElement Sources = driver.findElement(By.id("sourcesElement"));
		Select selectonesource = new Select(Sources);
		selectonesource.selectByVisibleText("Facebook");
		boolean sourceword = selectonesource.getFirstSelectedOption().getText().contains("Facebook");
		System.out.println("the source is filtered to Facebook " + sourceword);

	}
	@Test (priority = 12)
	public void user_can_filter_by_Tags()throws InterruptedException
	{
		//select Tag 
		try {
			WebElement Tags_dropdown = driver.findElement(By.xpath("//*[@id=\"front-posts\"]/div[1]/div/form/div[2]/div[3]/div/button"));
			Tags_dropdown.click();
			WebElement Tags_dropdown_Search = driver.findElement(By.cssSelector("#front-posts > div.row.clearfix > div > form > div.row > div:nth-child(3) > div > div > div.bs-searchbox > input"));
			Tags_dropdown_Search.sendKeys(TagSearchData);
			Thread.sleep(2000L);

			WebElement Tags_dropdown_List = driver.findElement(By.xpath("//*[@id=\"front-posts\"]/div[1]/div/form/div[2]/div[3]/div/div/div[2]/ul"));
			List<WebElement> Tags_Dropdown_Select = Tags_dropdown_List.findElements(By.tagName("span"));
			int tagcount = Tags_Dropdown_Select.size();
			System.out.println(tagcount);
		
		
				

			for (WebElement TagSearchResult : Tags_Dropdown_Select) {
				if (TagSearchResult.getText().equals(TagSearchData)) {
					System.out.println(TagSearchResult.getText());
					TagSearchResult.click();
					break;
				}	} 
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{

		}
	}
	
	
	

	@Test (priority = 13)
	public void check_boosted_posts_()
	{
		WebElement boostedposts = driver.findElement(By.id("filter-boosted"));
		boostedposts.click();			
	}

	@Test (priority = 14)
	public void click_on_serach()
	{
		WebElement searchbtn = driver.findElement(By.cssSelector("#front-posts > div.row.clearfix > div > form > div.row > div.col-md-1.text-left > input"));
		searchbtn.submit();	
		System.out.println("User can search");		
	}

	@AfterTest
	public void close_driver()
	{
		driver.quit();
	}
}

