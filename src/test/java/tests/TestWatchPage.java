package tests;

import java.io.IOException;
import java.util.List;

import org.apache.maven.wagon.providers.http.org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.watchdatamanager;

public class TestWatchPage extends TestBase {

	LoginPage LoginObject ;
	HomePage HomePageObject ;


	@BeforeTest 
	public void Login() throws InterruptedException
	{
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin("admin@gmail.com","123456");
		Thread.sleep(1000);
	}
	@Test (priority = 1)
	public void Open_Competitions_tab() throws Exception 
	{
		WebElement Watchlink = driver.findElement(By.linkText("Watch!"));
		System.out.println("Watch Page Opened and this is the link  "+ Watchlink.getAttribute("href"));	
		Watchlink.click();
		Thread.sleep(1000L);
		WebElement WatchPageTitle = driver.findElement(By.id("page-title"));
		Thread.sleep(1000L);
		Assert.assertTrue(WatchPageTitle.getText().contains("Watch"));
		System.out.println("this page title is " + WatchPageTitle.getText());
	}
	// Selenium-TestNG Execution Engine
	@Test(dataProvider = "WatchLinksdata" , priority = 2)
	public void flightDeals(String Title, String Links, String Label, String Type)
			throws InterruptedException, IOException {
		
		
		//WebElement LinksTypeselections = driver.findElement(By.xpath("//div[@class='col-md-6']"));
		//LinksTypeselections.click();
		WebElement LinksType = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		//LinksType.click();
		
			Select addlinkstype = new Select(LinksType);
				addlinkstype.selectByIndex(1);
	
		
		try {
			WebElement Label_dropdown = driver.findElement(By.id("select2-watch-label-container"));
			Label_dropdown.click();
			WebElement Label_dropdown_Search = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
			Label_dropdown_Search.sendKeys(Label);
			Thread.sleep(2000L);

		WebElement Label_dropdown_List = driver.findElement(By.id("select2-watch-label-results"));
			List<WebElement> Label_Dropdown_Select = Label_dropdown_List.findElements(By.tagName("li"));
			int Labelcount = Label_Dropdown_Select.size();
			
			System.out.println(Labelcount);
     		for (WebElement LabelSearchResult : Label_Dropdown_Select) {
				if (LabelSearchResult.getText().equals(Label)) {
					System.out.println(LabelSearchResult.getText());
					LabelSearchResult.click();
					break;
				}	} 
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		}
		
		
			WebElement Watchtitle = driver.findElement(By.id("watch-title"));
			Watchtitle.sendKeys(Title);
			System.out.println(Title +"is added to page");
			
			WebElement WatchUrls = driver.findElement(By.id("watch-urls"));
			WatchUrls.sendKeys(Links);
			System.out.println(Links +"is added to page");
			
			WebElement Importbtn = driver.findElement(By.xpath("//input[@type='submit']	"));
			Importbtn.click();
			System.out.println("submit now ");
			
			
			WebElement SuccessAlert = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			Assert.assertTrue(SuccessAlert.getText().contains("processing"));
			
			
			
					
	}
	// Data Provider
	@DataProvider(name = "WatchLinksdata")
	public Object[][] datasupplier() throws Exception {
		final String xlsxFile = System.getProperty("user.dir") + "\\Resources\\watch_input.xlsx";
		Object[][] arrayObject = watchdatamanager.getExcelData(xlsxFile, "Sheet1");
		return arrayObject;
	}
}
