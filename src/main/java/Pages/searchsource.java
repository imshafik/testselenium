package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchsource extends PageBase {

	public searchsource(WebDriver driver) {
		super(driver);
	}
	// searcg source elements
	
	@FindBy (xpath = "//button[@class='btn dropdown-toggle bs-placeholder btn-default']")
	WebElement searchsourcebutton ;
	
	@FindBy (xpath = "//a[@role='option']")
	List<WebElement>  selectedsource ;
		
	@FindBy (xpath = "//input[@class='button button-3d topmargin-sm']")
	WebElement searchbtn ;
	
	@FindBy (partialLinkText = "Facebook")
	WebElement sourcedata ;
	
	public void addsource (String productname )
	{
		setTextElementText(searchsourcebutton, productname);
		selectedsource.get(0).click();
		searchbtn.click();
	}
	public void checksourcedata ()
	{
		sourcedata.getText();
	}
}
