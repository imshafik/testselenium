package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompetitionsPage extends PageBase {

	public CompetitionsPage(WebDriver driver) {
		super(driver);
	}
	//main tabs in home page 


	@FindBy(id="filter-from-date")
	WebElement filterfromdate;

	@FindBy(id="filter-to-date")
	WebElement filtertodate;

	@FindBy(id="companyElement")
	WebElement selectcompany ;

	@FindBy (id="sourcesElement")
	WebElement selectsource ;

	@FindBy (id="tags-filter")
	WebElement serachontag ;

	@FindBy (id="filter-boosted")
	WebElement boostedfilter ;

	@FindBy (xpath = "//input[@value='Search']")
	WebElement searchbtn ;

	public void filterbydate_from()
	{
		filterfromdate.click();
	}public void to()
	{
		filtertodate.click();
	}
	public void selectcompanyfromlist()
	{		
		selectcompany.click();
	}
	public void selectsourcefromlist()
	{
		selectsource.click();

	}
	public void searchontag_select()
	{
		serachontag.click();

	}
	public void checkboosted()
	{
		boostedfilter.click();

	}
	public void clickonserachbtn()
	{
		searchbtn.click();

	}

}
