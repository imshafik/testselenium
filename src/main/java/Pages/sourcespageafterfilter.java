package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class sourcespageafterfilter extends PageBase {

	public sourcespageafterfilter(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//b[@title='Promotions']")
	public WebElement searchedsources ;
	
	
	
}
